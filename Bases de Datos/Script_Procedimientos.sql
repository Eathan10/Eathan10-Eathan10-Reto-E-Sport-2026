CREATE OR REPLACE PROCEDURE informe_jugadores(
p_nombre_equipo IN varchar2,
p_cursor OUT SYS_REFCURSOR)

IS

BEGIN
OPEN p_cursor FOR
SELECT nombre, apellido, rol, sueldo
from datos_jugadores
where nombre_equipo = p_nombre_equipo;

END;
