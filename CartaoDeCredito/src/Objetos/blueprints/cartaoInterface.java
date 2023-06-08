package Objetos.blueprints;

public interface cartaoInterface {
    public void novoCartao(int numeroCartao, String dataValidade, int limite);
    public void novoCartaoAdicional(int numeroCartao, String dataValidade, int limite);
    public void transacao(double valor, String estabelecimento);
    public void pagamento(double valor);
    public void consultaSaldo(String numeroCartao);
}
