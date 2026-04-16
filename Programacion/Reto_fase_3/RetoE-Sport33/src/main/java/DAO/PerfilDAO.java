package DAO;



import Modelo.Perfil;

import Utilidades.*;



import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;





public class PerfilDAO{



    public void altaPerfil (Perfil perfil) throws SQLException {



        String sql = "INSERT INTO perfiles(cod_perfil,nombre, password, tipo) " +

                "VALUES (?,?,?,?)";



        try{
            Connection conexion = BaseDatos.getConnection();

            PreparedStatement ps = conexion.prepareStatement(sql);


            ps.setInt(1, perfil.getCodPerfil() );
            ps.setString(2, perfil.getNombre());
            ps.setString(3, perfil.getPassword());
            ps.setString(4, perfil.getTipo());

            ps.executeUpdate();

        }catch (Exception e){

            e.getMessage();

        }finally {
            BaseDatos.closeConnection();
        }

    }


    public int bajaPerfil(int codPerfil) throws Exception{

        String sql = "DELETE FROM perfiles WHERE cod_perfil = ?";

        int numBorrados = 0;

        try{
            Connection conexion = BaseDatos.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, codPerfil);

            numBorrados = ps.executeUpdate();

            if (numBorrados != 1){

                System.out.println("No se puede borrar el perfil");

            }else{

                System.out.println("El perfil ha sido eliminado");
            }



        }catch(Exception e){
            e.getMessage();

        }finally {
            BaseDatos.closeConnection();

            return numBorrados;

        }

    }


    public int modificarPerfil(Perfil perfil) throws Exception {

        String sql = "UPDATE perfiles" +
                " SET nombre = ? , password = ?, tipo = ?" +
                " WHERE cod_perfil = ?";

        PreparedStatement ps = null;
        try {

            Connection conexion = BaseDatos.getConnection();
            ps = conexion.prepareStatement(sql);

            ps.setString(1, perfil.getNombre());
            ps.setString(2, perfil.getPassword());
            ps.setString(3, perfil.getTipo());
            ps.setInt(4, perfil.getCodPerfil());


        } catch (Exception e) {
            e.getMessage();

        } finally {
            BaseDatos.closeConnection();
        }

        return ps.executeUpdate();
    }

}
