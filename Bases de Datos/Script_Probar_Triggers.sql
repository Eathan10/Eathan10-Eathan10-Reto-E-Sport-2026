-- Pruebas para el trigger 
insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (99, 'juan', 'perez', 'española', to_date('2000-01-01', 'yyyy-mm-dd'), 'jp99', 'centinela', 1000, 1);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (100, 'ana', 'garcia', 'española', to_date('1995-05-15', 'yyyy-mm-dd'), 'anita_win', 'centinela', 1500, 1);