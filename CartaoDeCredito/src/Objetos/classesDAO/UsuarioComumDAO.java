package Objetos.classesDAO;

import Objetos.entidades.Usuario;
import Objetos.entidades.UsuarioComum;

public class UsuarioComumDAO {

    public UsuarioComumDAO() {

    }

    public UsuarioComum cadastrarUsuarioComum(String nome, String documento, String dataNasciemnto, String genero, String telefone){
        UsuarioComum uc = new UsuarioComum(nome, documento, dataNasciemnto, genero, telefone);
        return uc;

    }

    public void criarPrimeiroCartao(UsuarioComum uc) {
        if (uc.getCartaoCredito().size() == 0) {
            // Criar o primeiro cartao
        } else {
            // retornar erro ao criar primerio cartao
        }
    }
    
    
}
