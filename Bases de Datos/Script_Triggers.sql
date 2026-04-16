
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
------------------------------------------
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



