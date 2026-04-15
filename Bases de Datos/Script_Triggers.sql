
set serveroutput on;

create or replace trigger sueldo_jugador 
before insert or update of sueldo on jugadores
for each row

begin
    if :new.sueldo < 1221 then
        raise_application_error
        (-20001,'El sueldo del jugador no puede ser menor al SMI (1.221)');
    end if;
end;

