package Objetos.entidades;

import Objetos.blueprints.cartaoInterface;

public class CartaoCredito2 extends Cartao {
    private double limiteUtiizado = 0;

    public CartaoCredito2(Usuario titular, String documento, String numCartao, String dataValidade,
            double limiteCredito) {
        super(titular, documento, numCartao, dataValidade, limiteCredito);
        this.setTipo("credito");
        
    }


    public double getLimiteUtiizado() {
        return limiteUtiizado;
    }

    public void setLimiteUtiizado(double limiteUtiizado) {
        this.limiteUtiizado = limiteUtiizado;
    }

    
    
}
