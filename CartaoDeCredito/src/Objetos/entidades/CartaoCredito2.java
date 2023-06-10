package Objetos.entidades;

import Objetos.blueprints.cartaoInterface;

public class CartaoCredito2 extends Cartao {
    private final String tipo = "credito";

    public CartaoCredito2(Usuario titular, String documento, String numCartao, String dataValidade,
            double limiteCredito) {
        super(titular, documento, numCartao, dataValidade, limiteCredito);
        
    }
    
}
