
set serveroutput on;

create or replace trigger tr_sueldo_jugador 
before insert or update of sueldo on jugadores
for each row

begin
    if :new.sueldo < 1221 then
        raise_application_error
        (-20001,'error: El sueldo del jugador no puede ser menor al SMI (1.221)');
    end if;
end tr_sueldo_jugador;
------------------------------------------------------------
create or replace trigger tr_numero_jugadores_max
for insert or update of cod_equipo on jugadores
compound trigger

    after statement is
        v_max_jugadores number;
    begin
        
        select max(count(*)) into v_max_jugadores
        from jugadores
        group by cod_equipo;

        if v_max_jugadores > 6 then
            raise_application_error
            (-20001,'error: Operación cancelada. Ningún equipo puede tener más de 6 jugadores.');
        end if;
        
    end after statement;

end tr_numero_jugadores_max;

--------------------------------------------------------

create or replace trigger tr_numero_jugadores_min 
before update of estado on competiciones
for each row

declare

v_conteo_minimo number;

begin

    select min(count(*)) into v_conteo_minimo
    from jugadores
    group by cod_equipo;
    
    if v_conteo_minimo < 2 then
        raise_application_error(-20006,'No se puede cerrar la etapa de inscripciones. Hay equipos que tienen menos de 2 jugadores.');
    end if;

exception
    when no_data_found then
        raise_application_error(-20009, 'No hay jugadores en ningún equipo.');
end tr_numero_jugadores_min;

---------------------------------------------------

create or replace trigger tr_bloqueo_jugadores
before insert or delete or update of cod_equipo on jugadores
declare
    v_total_partidos number;
begin
    select count(*) into v_total_partidos 
    from partidos;

    if v_total_partidos > 0 then
        raise_application_error(-20010, 'error: el calendario ya está generado. no se pueden modificar los jugadores.');
    end if;
end;

create or replace trigger tr_bloqueo_equipos
before insert or delete on equipos
declare
    v_total_partidos number;
begin
    select count(*) into v_total_partidos 
    from partidos;

    if v_total_partidos > 0 then
        raise_application_error(-20011, 'error: el calendario ya está generado. no se pueden añadir ni eliminar equipos.');
    end if;
end;





























