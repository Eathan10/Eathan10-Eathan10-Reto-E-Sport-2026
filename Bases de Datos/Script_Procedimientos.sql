-- Autor Equipo 1: Unax Gonzales, Urko Lopez, Fatima Din, Eathan Garzon



set serveroutput on;

create or replace procedure informe_jugadores(
p_nombre_equipo IN varchar2,
p_cursor OUT SYS_REFCURSOR)

IS

begin

open p_cursor for
select nombre, apellido, rol, sueldo
from datos_jugadores
where nombre_equipo = p_nombre_equipo;

end;


create or replace procedure pr_obtener_informe_equipos (
    p_cursor out sys_refcursor
) 
as
begin
    open p_cursor for 
    select * from vs_sueldos_numeros_equipos;
end pr_obtener_informe_equipos;
/





