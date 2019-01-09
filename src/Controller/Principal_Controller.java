package Controller;

import Model.Permissoes_Model;
import View.Principal;

/**
 *
 * @author Andre
 */
public class Principal_Controller {

    /**
     * Metodo que recebe um objeto tipo Permissoes_Model, com as referencias das permissoes de um usuario
     * @param permissao 
     */
    public void abrirTelaPrincipal(Permissoes_Model permissao) {

        // atributos que representam uma permissao
        boolean aut = false;
        boolean recF = false;
        boolean abF = false;
        boolean proc = false;
        boolean casm = false;
        boolean nasc = false;
        boolean obt = false;
        boolean altSelo = false;
        boolean nvUser = false;

        // sera verificado o atributo, caso S(sim) torna-se TRUE
        if (permissao.getAutenticacao().equals("S")) {
            aut = true; // autenticacao
        } 
        if(permissao.getRecon_firma().equals("S")) {
            recF = true; // reconhecimento de assinatura
        }
        if(permissao.getAbert_firma().equals("S")) {
            abF = true; // abertufa de firmas
        }
        if(permissao.getProcuracao().equals("S")){
            proc = true; // procuração
        } 
        if(permissao.getCert_casamento().equals("S")){
            casm = true; // casamento
        } 
        if(permissao.getCert_nascimento().equals("S")){
            nasc = true; // nascimento
        } 
        if(permissao.getCert_obito().equals("S")){
            obt = true; // obitos
        } 
        if(permissao.getAlterar_selo().equals("S")){
            altSelo = true; // alterar selos
        }
        if(permissao.getNovo_user().equals("S")){
            nvUser = true; // cadastrar novos usuarios
            
            // caso  seja N entaão sera passando a ser FALSE
        } else {
            aut = false;
            recF = false;
            abF= false;
            proc= false;
            casm= false;
            nasc= false;
            obt= false;
            altSelo= false;
            nvUser= false;
        }
        
        // passando para o construtor que recebera estes atributos e encarregará de habilitar os TRUE's
            Principal tela = new Principal(aut,recF, abF, proc, casm, nasc, obt, altSelo, nvUser);
            tela.setVisible(true);
    }

}
