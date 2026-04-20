-- Autor Equipo 1: Unax Gonzales, Urko Lopez, Fatima Din, Eathan Garzon

drop table jugadores cascade constraints;
drop table equipos cascade constraints;
drop table competiciones cascade constraints;
drop table jornadas cascade constraints;
drop table partidos cascade constraints;
drop table resultados cascade constraints;
drop table perfiles cascade constraints;

create table equipos(
    cod_equipo number, 
    nombre varchar2(55),
    fecha_fundacion date,
    constraint equi_cod_pk primary key (cod_equipo)
);

create table jugadores (
    cod_jugador   number,
    nombre        varchar2(55),
    apellido      varchar2(55),
    nacionalidad  varchar2(55),
    fecha_nac     date,
    nickname      varchar2(55),
    rol           varchar2(20),
    sueldo        number,
    cod_equipo    number,
    constraint jug_cod_pk primary key (cod_jugador),
    constraint jug_rol_ck 
        check (rol in ('duelista', 'iniciador', 'controlador', 'centinela')),
    constraint jug_cod_equip_fk foreign key (cod_equipo) 
        references equipos(cod_equipo),
    constraint jug_nickname_uq unique (nickname)
);

create table competiciones(
    cod_comp number,
    nombre varchar2(55),
    estado varchar2(7),
    premio number,
    constraint comp_cod_pk primary key (cod_comp),
    constraint comp_estado_ck check(estado in ('abierto','cerrado'))
);


create table jornadas(
    num_jornada number,
    fecha_inicio date,
    cod_comp number,
    constraint jor_num_pk primary key (num_jornada),
    constraint jor_cod_comp_fk foreign key (cod_comp)
    references competiciones(cod_comp)
);

create table partidos(
    cod_partido number,
    num_jornada number,
    hora TIMESTAMP,
    constraint part_cod_pk primary key (cod_partido),
    constraint part_num_jorn_fk foreign key (num_jornada)
    references jornadas(num_jornada)
);

create table resultados(
    cod_partido number,
    cod_equipo number,
    resultado number,
    constraint resul_cod_partido_cod_equipo_pk primary key 
    (cod_partido,cod_equipo),
    constraint resul_cod_partido_fk foreign key (cod_partido)
    references partidos(cod_partido),
    constraint resul_cod_equipo_fk foreign key (cod_equipo)
    references equipos(cod_equipo)
);

create table perfiles(
    cod_perfil number,
    nombre varchar2(55),
    password varchar2(55),
    tipo varchar2(55),
    constraint per_cod_pk primary key (cod_perfil),
    constraint per_nombre_uq unique (nombre),
    constraint per_tipo_ck check(tipo in ('usuario','administrador'))
);
/*
creamos la vista para utilizarla en el procedimiento informe_jugadores
y que la select dentro del procedimiento este mas simplificada
*/
create or replace view datos_jugadores as
select j.nombre, j.apellido, j.rol, j.sueldo, e.nombre as nombre_equipo
from jugadores j join equipos e 
on j.cod_equipo = e.cod_equipo;

/*
creamos la vista para utilizarla en el procedimiento pr_informe_equipos
y que la select dentro del procedimiento este mas simplificada
*/

create or replace view vs_sueldos_numeros_equipos as
select e.nombre "Equipo", e.fecha_fundacion "Fundacios", 
        count(j.cod_jugador) "Nº jugadores",max(j.sueldo) "Max. sueldo", 
        min(j.sueldo) "Min. sueldo", round(avg(j.sueldo),2) "Media sueldos"   
from equipos e join jugadores j
on j.cod_equipo = e.cod_equipo
group by e.nombre, e.fecha_fundacion 
;

create index idx_cod_equipo 
on jugadores (cod_equipo);


commit;






