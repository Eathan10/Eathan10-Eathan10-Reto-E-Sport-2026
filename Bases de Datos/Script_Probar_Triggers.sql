-- Pruebas para el trigger tr_sueldo_jugador

-- Fallos

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (99, 'juan', 'perez', 'española', to_date('2000-01-01', 'yyyy-mm-dd'), 'jp99', 'centinela', 1000, 1);

update jugadores 
set sueldo = 1100 
where cod_jugador = 100;

-- Exitos

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (100, 'ana', 'garcia', 'española', to_date('1995-05-15', 'yyyy-mm-dd'), 'anita_win', 'centinela', 1500, 1);

update jugadores 
set sueldo = 2000 
where cod_jugador = 100;

-- Pruebas para el trigger tr_numero_jugadores_max

-- Fallos

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (99, 'juan', 'perez', 'española', to_date('2000-01-01', 'yyyy-mm-dd'), 'jp99', 'centinela', 1500, 1);

update jugadores
set cod_equipo = 1
where cod_jugador = 30;


-- Exitos
insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (101, 'alana', 'torres', 'española', to_date('1995-05-15', 'yyyy-mm-dd'), 'alana', 'centinela', 1500, 3);

update jugadores
set cod_equipo = 3
where cod_jugador = 101;


















