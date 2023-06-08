package Objetos.classesDAO;

import java.util.ArrayList;

import Objetos.blueprints.cartaoInterface;
import Objetos.entidades.CartaoCredito;

public class CartaoCreditoDao extends CartaoCredito implements cartaoInterface {
    private ArrayList<CartaoCredito> cartoesCredito;

    @Override
    public void novoCartao(int numeroCartao, String dataValidade, int limite) {
        CartaoCredito cartao = new CartaoCredito(numeroCartao, dataValidade, limite);
        cartoesCredito.add(cartao);

        System.out.println("Cartão de crédito emitido com sucesso.");
    }

    @Override
    public void novoCartaoAdicional(int numeroCartao, String dataValidade, int limite   ) {
        CartaoCredito cartaoPrincipal = cartoesCredito.get(0);
        if (limite <= cartaoPrincipal.getSaldo()) {
            CartaoCredito cartaoAdicional = new CartaoCredito(numeroCartao, dataValidade, limite);
            cartoesCredito.add(cartaoAdicional);

            System.out.println("Cartão adicional emitido com sucesso.");
        } else {
            System.out.println("Limite de crédito do cartão adicional deve ser menor ou igual ao limite disponível do cartão principal.");
        }
    }

    @Override
    public void transacao(double valor, String estabelecimento) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Transação de R$" + valor + " no estabelecimento " + estabelecimento + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar a transação.");
        }
    }

    @Override
    public void pagamento(double valor) {
        saldo += valor;
        System.out.println("Pagamento de R$" + valor + " realizado com sucesso.");
    }

    @Override
    public void consultaSaldo(String numeroCartao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultaSaldo'");
    }

    // @Override
    // public void consultaSaldo(String numeroCartao) {
    //     for (CartaoCredito cartao : cartoesCredito) {
    //         if (cartao.getNumeroCartao().equals(numeroCartao)) {
    //             System.out.println("Saldo disponível no cartão " + numeroCartao + ": R$" + cartao.getSaldoDisponivel());
    //             return;
    //         }
    //     }
    // }
}
