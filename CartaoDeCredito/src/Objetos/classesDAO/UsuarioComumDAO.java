package Objetos.classesDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import Objetos.entidades.Cartao;
import Objetos.entidades.CartaoCredito2;
import Objetos.entidades.Usuario;
import Objetos.entidades.UsuarioComum;

public class UsuarioComumDAO {


    public UsuarioComum cadastrarUsuarioComum(String nome, String documento, String dataNasciemnto, String genero, String telefone){
        UsuarioComum uc = new UsuarioComum(nome, documento, dataNasciemnto, genero, telefone);
        return uc;

    }

    public void criarPrimeiroCartao(UsuarioComum uc) {
        if (uc.getCartaoCredito().size() == 0) {
            // Criar o primeiro cartao
        } else {
            // retornar erro ao criar primerio cartao
        }
    }

   
    public static String gerarDataValidade() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataFutura = dataAtual.plusYears(3);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM-yyyy");
        return dataFutura.format(formato);
    }

    public static String gerarNumeroCartao() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 12; i++) {
            if (i > 0 && i % 4 == 0) {
                sb.append(" ");
            }
            int numeroAleatorio = random.nextInt(10);
            sb.append(numeroAleatorio);
        }
        
        sb.append(" 9999");
        
        return sb.toString();
    }

    public void gerarCartaoCredito(Usuario titular, double limiteCredito) {

        String numCartao = gerarNumeroCartao();
        String dataValidade = gerarDataValidade();


        CartaoCredito2 cCred = new CartaoCredito2(titular, titular.getDocumento(), numCartao, dataValidade, limiteCredito);
        titular.getCartaoCredito().add(cCred);
        
        
    }

    public void listarCartoes(Usuario u) {
        for(Cartao c : u.getCartaoCredito()){
            System.out.println("N do cartão: " + c.getNumCartao() + "| Limite: " + c.getLimiteCredito() +" | Validade: " + c.getDataValidade());
        }
    }
    
    
}
