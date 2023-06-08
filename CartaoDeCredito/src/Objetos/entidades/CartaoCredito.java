package Objetos.entidades;

public class CartaoCredito{

    protected int saldo;
    private int numeroCartao;
    private String dataValidade;
    private int limite;  
    private int numeroCartaoAdicional;
    private String dataValidadeAdicional;
    private int limiteAdicional;  

    public CartaoCredito(){
        
    }

    public CartaoCredito(int numeroCartao, String dataValidade, int limite) {
        this.numeroCartao = numeroCartao;
        this.dataValidade = dataValidade;
        this.limite = limite;
        // this.saldoDisponivel = limiteCredito;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public int getNumeroCartaoAdicional() {
        return numeroCartaoAdicional;
    }

    public void setNumeroCartaoAdicional(int numeroCartaoAdicional) {
        this.numeroCartaoAdicional = numeroCartaoAdicional;
    }

    public String getDataValidadeAdicional() {
        return dataValidadeAdicional;
    }

    public void setDataValidadeAdicional(String dataValidadeAdicional) {
        this.dataValidadeAdicional = dataValidadeAdicional;
    }

    public int getLimiteAdicional() {
        return limiteAdicional;
    }

    public void setLimiteAdicional(int limiteAdicional) {
        this.limiteAdicional = limiteAdicional;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getlimite() {
        return limite;
    }

    public void setlimite(int limite) {
        this.limite = limite;
    }  
    
}
