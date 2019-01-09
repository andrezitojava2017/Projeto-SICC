package Model;

import java.io.File;

/**
 *
 * @author rh
 */
public class Abertura_Assinatura_Model {

    public File destinoCopia;
    private String local_ficha;

    
    public Abertura_Assinatura_Model() {
        this.destinoCopia = new File("ficha.txt");
    }

    public String getLocal_ficha() {
        return local_ficha;
    }

    public void setLocal_ficha(String local_ficha) {
        this.local_ficha = local_ficha;
    }

}
