package Objetos.classesDAO;

import Objetos.entidades.Cartao;
import Objetos.entidades.CartaoCredito2;
import Objetos.entidades.Usuario;
import Objetos.entidades.UsuarioComum;

public class CartaoCredito2DAO {
    
    public CartaoCredito2DAO() {


    }

    public void realizarTransacao(CartaoCredito2 cartao ,double valor){
        //quem vai receber a transacao?
        double limite = cartao.getLimiteCredito();
        double utilizado = cartao.getLimiteUtiizado();
        if (valor + utilizado <= limite){

            cartao.setLimiteUtiizado(utilizado + valor);
            double disponivel = limite - cartao.getLimiteUtiizado();
            System.out.println("Transação realizada com sucesso. \nValor transferido: " + valor + "\nValor utilizado: " + cartao.getLimiteUtiizado() + "\nValor disponível: " + disponivel);
            //inserir no log datetime + usuario + valor + quem recebeu + status - sucesso
        } else {
            System.out.println("Crédito insuficiente para transação.");
            //inserir no log datetime + usuario + valor + quem iria receber + status - falha 
        }
    }

    public void realizarPagamento(CartaoCredito2 cartao, double valor){
        double limite = cartao.getLimiteCredito();
        double utilizado = cartao.getLimiteUtiizado();
        if (valor + utilizado <= limite){

            cartao.setLimiteUtiizado(utilizado + valor);
            double disponivel = limite - cartao.getLimiteUtiizado();
            System.out.println("Pagamento realizado com sucesso. \nValor transferido: " + valor + "\nValor utilizado: " + cartao.getLimiteUtiizado() + "\nValor disponível: " + disponivel);
            //inserir no log datetime + usuario + valor + quem recebeu + status - sucesso
        } else {
            System.out.println("Crédito insuficiente para pagamento.");
            //inserir no log datetime + usuario + valor + quem iria receber + status - falha 
        }
    }

    public void consultarSaldo(CartaoCredito2 cartao){
        System.out.println("Saldo atual do cartão " + cartao.getNumCartao() + ": " + (cartao.getLimiteCredito() - cartao.getLimiteUtiizado()));
    }

    

}
