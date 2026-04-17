--Inserts tabla equipos

insert into equipos (cod_equipo, nombre, fecha_fundacion) 
values (1, 'leones', to_date('01-01-2014', 'dd-mm-yyyy'));

insert into equipos (cod_equipo, nombre, fecha_fundacion) 
values (2, 'fantasmas', to_date('14-03-2004', 'dd-mm-yyyy'));

insert into equipos (cod_equipo, nombre, fecha_fundacion) 
values (3, 'leviatan', to_date('19-03-2020', 'dd-mm-yyyy'));

insert into equipos (cod_equipo, nombre, fecha_fundacion) 
values (4, 'Los Invencibles', sysdate);

--Inserts tabla jugadores

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (10, 'juan', 'perez', 'mexicano', to_date('15-03-1998', 'dd-mm-yyyy'), 'jp-pro', 'duelista', 2500, 1);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (20, 'carlos', 'rodriguez', 'español', to_date('22-07-2000', 'dd-mm-yyyy'), 'charly-r', 'iniciador', 2800, 1);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (30, 'luis', 'garcia', 'argentino', to_date('10-01-1995', 'dd-mm-yyyy'), 'lucho-smoke', 'controlador', 3200, 2);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (40, 'ana', 'martinez', 'colombiana', to_date('05-06-1999', 'dd-mm-yyyy'), 'anam-trap', 'centinela', 3000, 2);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (50, 'diego', 'lopez', 'chileno', to_date('18-11-2002', 'dd-mm-yyyy'), 'diegox', 'duelista', 2700, 3);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (60, 'maria', 'sanchez', 'peruana', to_date('30-09-1997', 'dd-mm-yyyy'), 'mary-spot', 'iniciador', 2900, 3);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (70, 'jhonda', 'ozpina', 'mexicano', to_date('15-03-2008', 'dd-mm-yyyy'), 'jondas', 'duelista', 2590, 1);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (80, 'xemelas', 'torres', 'estadounidense', to_date('11-09-2001', 'dd-mm-yyyy'), 'lol', 'iniciador', 2590, 1);

insert into jugadores (cod_jugador, nombre, apellido, nacionalidad, fecha_nac, nickname, rol, sueldo, cod_equipo)
values (90, 'lola', 'garcia', 'estadounidense', to_date('01-09-2021', 'dd-mm-yyyy'), 'elmejor', 'iniciador', 2590, 1);
