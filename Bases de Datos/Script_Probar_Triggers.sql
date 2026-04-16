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

-- Pruebas para el trigger tr_numero_jugadores_min

-- Fallos

delete from jugadores
where cod_jugador = 30;

-- Esto tiene que dar el error de "No hay jugadores en ningún equipo."
update competiciones 
set estado = 'cerrado' 
where cod_comp = 1;

-- Exitos

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo) 
values (30, 'Carlos', 'López', 'España', sysdate, 'Carlitos', 'iniciador', 1500, 2);

update competiciones 
set estado = 'cerrado' 
where cod_comp = 1;


-- Pruebas para los triggers tr_bloqueo_jugadores y tr_bloqueo_equipos

-- Fallos

insert into jornadas (num_jornada, fecha_inicio, cod_comp) 
values (1, sysdate, 1);

insert into partidos (cod_partido, num_jornada, hora) 
values (1, 1, current_timestamp);

insert into equipos (cod_equipo, nombre, fecha_fundacion) 
values (90, 'equipo bloqueado', sysdate);

delete from equipos 
where cod_equipo = 80;


-- Exitos

delete from partidos;


insert into equipos (cod_equipo, nombre, fecha_fundacion) 
values (80, 'equipo de prueba', sysdate);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo) 
values (800, 'prueba', 'exito', 'españa', sysdate, 'exito_player', 'centinela', 1500, 80);

update jugadores 
set cod_equipo = 2
where cod_jugador = 20;

delete from jugadores 
where cod_jugador = 20;













