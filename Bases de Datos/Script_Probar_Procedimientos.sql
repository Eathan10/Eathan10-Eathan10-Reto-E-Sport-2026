-- Autor Equipo 1: Unax Gonzales, Urko Lopez, Fatima Din, Eathan Garzon

-- Procedimiento anonimo para porbar el procedimieno almacenado pr_obtener_informe_equipos
declare
    p_cursor sys_refcursor;
    
    v_equipo          varchar2(100);
    v_fundacion       date;
    v_num_jugadores   number;
    v_max_sueldo      number;
    v_min_sueldo      number;
    v_media_sueldos   number;
begin

    obtener_informe_equipos(p_cursor);

    loop
       
        fetch p_cursor into v_equipo, v_fundacion, v_num_jugadores, v_max_sueldo, 
                            v_min_sueldo, v_media_sueldos;
        exit when p_cursor%notfound;
        
        dbms_output.put_line('equipo: ' || v_equipo || 
                             ' | fundacion: ' || to_char(v_fundacion, 'dd/mm/yyyy') || 
                             ' | nº jugadores: ' || v_num_jugadores || 
                             ' | max sueldo: ' || v_max_sueldo || 
                             ' | min sueldo: ' || v_min_sueldo || 
                             ' | media: ' || v_media_sueldos);
    end loop;
    
end;


/*
equipo: leones | fundacion: 01/01/2014 | nº jugadores: 5 | max sueldo: 2590 | min sueldo: 2000 | media: 2454
equipo: fantasmas | fundacion: 14/03/2004 | nº jugadores: 2 | max sueldo: 3000 | min sueldo: 1500 | media: 2250
equipo: leviatan | fundacion: 19/03/2020 | nº jugadores: 3 | max sueldo: 2900 | min sueldo: 1500 | media: 2366,67
equipo: equipo de prueba | fundacion: 16/04/2026 | nº jugadores: 1 | max sueldo: 1500 | min sueldo: 1500 | media: 1500

Procedimiento PL/SQL terminado correctamente.

*/









