package Objetos.entidades;

public class UsuarioAdm extends Usuario {
    public Boolean isAdmin = true;

    public UsuarioAdm(String nome, String documento, String dataNascimento, String genero, String telefone) {
        super(nome, documento, dataNascimento, genero, telefone);
        
        //TODO Auto-generated constructor stub
    }
    
}
