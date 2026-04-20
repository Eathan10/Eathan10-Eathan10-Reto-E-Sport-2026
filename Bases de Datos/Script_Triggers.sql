-- Autor Equipo 1: Unax Gonzales, Urko Lopez, Fatima Din, Eathan Garzon


create or replace trigger tr_sueldo_jugador 
before insert or update of sueldo on jugadores
for each row
declare
    e_sueldo exception;

begin
    if :new.sueldo < 1221 then
        raise e_sueldo;
    end if;
exception 
    when e_sueldo then
        raise_application_error(-20001,'error: El sueldo del jugador no puede ser menor al SMI (1.221)');
end tr_sueldo_jugador;
------------------------------------------------------------
create or replace trigger tr_numero_jugadores_max
for insert or update of cod_equipo on jugadores
compound trigger

    v_cod_equipo jugadores.cod_equipo%type;

    before each row is
    begin
        v_cod_equipo := :new.cod_equipo;
    end before each row;

    after statement is
        v_count number;
    begin
        select count(*) into v_count
        from jugadores
        where cod_equipo = v_cod_equipo;
        
        if v_count > 6 then
            raise_application_error(
                -20001,
                'error: el equipo ya tiene 6 jugadores. no se puede agregar mas.'
            );
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

-----------------------------------------------------------------------


create or replace trigger tr_equipos_pares
before update of estado on competiciones
for each row

declare
    v_total_equipos number;
begin

    select count(*) into v_total_equipos
    from equipos;

    if mod(v_total_equipos, 2) != 0 then
        raise_application_error(-20020, 'Error: no se puede cerrar la competición. el número total de equipos (' || v_total_equipos || ') es impar, debe ser par.');
    end if;
    
    if v_total_equipos = 0 then
        raise_application_error(-20021, 'Error: no se puede cerrar la competición. no hay ningún equipo registrado.');
    end if;
end tr_equipos_pares;




























