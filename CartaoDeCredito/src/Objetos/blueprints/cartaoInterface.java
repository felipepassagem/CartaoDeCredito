package Objetos.blueprints;

public interface cartaoInterface {
    public void novoCartao(int numeCartao, String dataValidade, int limiteCredito);
    public void novoCartaoAdicional(int numeCartao, String dataValidade, int limiteCredito);
    public void transacao(double valor, String estabelecimento);
    public void pagamento(double valor);
    public void consultaSaldo(String numeCartao);
}
