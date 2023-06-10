package Objetos.entidades;

public class Cartao {
    private Usuario titular;
    private String documento;
    private String numCartao;
    private String dataValidade;
    private double limiteCredito;

    public Cartao(Usuario titular, String documento, String numCartao, String dataValidade, double limiteCredito) {
        this.titular = titular;
        this.documento = documento;
        this.numCartao = numCartao;
        this.dataValidade = dataValidade;
        this.limiteCredito = limiteCredito;
    }

    public Usuario getTitular() {
        return titular;
    }

    public void setTitular(Usuario titular) {
        this.titular = titular;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    
    
    
}
