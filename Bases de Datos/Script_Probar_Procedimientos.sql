-- Autor Equipo 1: Unax Gonzales, Urko Lopez, Fatima Din, Eathan Garzon


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

