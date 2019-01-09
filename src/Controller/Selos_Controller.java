package Controller;

import DAO.Selos_Dao;

/**
 *
 * @author rh
 */
public class Selos_Controller {

    /**
     * Metodo que irá capturar o ultimo e o proximo selo utilizado e retorna uma
     * vetor string com a sequencia de letras e numero do selo
     *
     * @return sequenciaSelo[]
     */
    public String[] capturarSelo() {

        // vetor de string que ira retornar os valores de ultimoSelo e proximoSelo
        String selos[] = new String[3];

        // vetor para armzenar vetor de retorno do metodo DAO
        String sequenciaSelo[];

        // instanciando objeto DAO
        Selos_Dao captSelo = new Selos_Dao();

        // capturando o ultimo ID da tabela selo, para capturar os dados de LETRA e NUMERO DO SELO
        // e passar como parametro para o metodo que ira capturar o ultimo selo
        int ultimo_id = captSelo.lerIdSelo();

        // capturando o ultimo selo utilizado
        sequenciaSelo = captSelo.carregarSelos(ultimo_id);

        // aqui iremos pegar o valor do ultimo selo e dpois incrementar
        // será  o valor d proximo selo
        int proximoSelo = Integer.parseInt(sequenciaSelo[1]);
        proximoSelo++;

        // atribuindo valores ao vetor selos
        selos[0] = sequenciaSelo[0]; // sequencia LETRAS
        selos[1] = sequenciaSelo[1]; // sequencia NUMERICA - ultimo selo
        selos[2] = String.valueOf(proximoSelo);// sequencia NUMERICA - proximo selo

        // retornamos o vetor
        return selos;
    }

    /**
     * Metodo responsavel em gravar o selo utilizado na tabela de selos
     *
     * @param letras String
     * @param numeroSelo String
     * @param custo Double
     * @return id_selo int
     */
    public int gravarSelo(String letras, String numeroSelo, double custo) {

        // atributo q armazenara o id de retorno
        int id_selo;

        // instanciando objeto tipo DAO
        Selos_Dao inserir = new Selos_Dao();

        // gravando dados na tabela selos e recuperando o id do selo
        id_selo = inserir.gravarSelo(letras, numeroSelo, custo);

        return id_selo;
    }
    
    
}
