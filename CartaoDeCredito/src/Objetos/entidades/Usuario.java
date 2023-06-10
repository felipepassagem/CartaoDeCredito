package Objetos.entidades;

import java.util.ArrayList;


public class Usuario{
    private String nome;
    private String documento;
    private String dataNascimento;
    private String genero;
    private String telefone;
    private ArrayList<Cartao> cartaoCredito;
  


    public Usuario(String nome, String documento, String dataNascimento, String genero, String telefone) {
        this.nome = nome;
        this.documento = documento;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.telefone = telefone;
        this.cartaoCredito = new ArrayList<Cartao>();
        
    }

    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public ArrayList<Cartao> getCartaoCredito() {
        return cartaoCredito;
    }



    public void setCartaoCredito(ArrayList<Cartao> cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }


    

    
    
}
