import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Objetos.classesDAO.UsuarioComumDAO;
import Objetos.entidades.UsuarioComum;



public class App {
    

    public static String leString(String msg) {
        String valor = JOptionPane.showInputDialog(null, msg);
        return valor;
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1- Cadstrar usuário.");
        System.out.println("2- Gerar cartão para usuário.");
        System.out.println("3- Sair");
        System.out.print("Digite: ");
        return teclado.nextInt();
    }

    public static UsuarioComum metodoCadastrarUsuario(){
        Scanner teclado = new Scanner(System.in);
        UsuarioComumDAO u = new UsuarioComumDAO();

        System.out.println("Nome: ");
        String nome = teclado.next();
        System.out.println("Documento: ");
        String documento = teclado.next();
        System.out.println("Data de nascimento (dd/mm/yyyy): ");
        String dataNascimento = teclado.next();
        System.out.println("Genero: ");
        String genero = teclado.next();
        System.out.println("Telefone: ");
        String telefone = teclado.next();

        UsuarioComum uc = u.cadastrarUsuarioComum(nome, documento, dataNascimento, genero, telefone);

        System.out.println(uc.getDocumento());

        return uc;


    }

    private static void metodoCriarCartaoParaUsuario(UsuarioComum uc){
        UsuarioComumDAO udao = new UsuarioComumDAO();
        
        

    }
    public static void main(String[] args) throws Exception {
        ArrayList<UsuarioComum> usuarioComums = new ArrayList<UsuarioComum>();
        int op;

        do {
            op=menu();
            switch (op) {
                case 1: {
                    UsuarioComum uc = metodoCadastrarUsuario();
                    usuarioComums.add(uc);
                    break;
                }

                case 2: {
                    Scanner teclado = new Scanner(System.in);
                    if (usuarioComums.size() > 0){
                        int i = 1;
                        for (UsuarioComum e : usuarioComums){
                            System.out.println(i + " Nome:" + e.getNome() + " | Documento: " + e.getDocumento());
                            i++;
                        }

                        System.out.println("Escolha o usuário (pelo número): ");
                        int index = teclado.nextInt() -1;
                        try {
                            UsuarioComum uc = usuarioComums.get(index);
                            metodoCriarCartaoParaUsuario(uc);
                            
                        } catch (Exception e) {
                            e.getMessage();
                        }

                    } else {
                        System.out.println("Nenhum usuário cadastrado.");
                    }


                    
                    break;
                }
                
                case 3: {
                    System.out.println("Saindo");
                    break;
                }

                default:
                    System.out.println("Opção inválida!!!");
                    break;
            }
        } while (op != 3);
        
    }
}
