package Controller;

import DAO.Login_Dao;

/**
 *
 * @author Andre
 */
public class Login_Controller {

    /**
     * Metodo que ira passar o usuario e senha para a camada login_Dao
     * @param usuario
     * @param senha
     * @return 
     */
    public boolean Login_Controller(String usuario, String senha) {

        // objeto camada DAO acessar metodos de leitura
        Login_Dao login = new Login_Dao();

        // objeto para armazenar retorno do metodo autenticar, com as referencias dos atos que estao liberados ao usuario
        boolean autorizar = login.Autenticar(usuario, senha);

        return autorizar;
    }
}
