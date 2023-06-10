package Objetos.entidades;

public class UsuarioComum extends Usuario {
    private final Boolean isAdmin = false;

    public UsuarioComum(String nome, String documento, String dataNascimento, String genero, String telefone) {
        super(nome, documento, dataNascimento, genero, telefone);
        
    }



    
}
