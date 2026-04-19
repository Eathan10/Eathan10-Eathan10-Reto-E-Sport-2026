package Controllers;

import DAO.AdministradorDAO;

public class AministradorController {

    private AdministradorDAO adminDao = new AdministradorDAO();

    public boolean procesarLogin(String nombre, String password) {
        return adminDao.validarAcceso(nombre, password);
    }
}
