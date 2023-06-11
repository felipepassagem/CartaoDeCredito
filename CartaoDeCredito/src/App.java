import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Objetos.classesDAO.CartaoCredito2DAO;
import Objetos.classesDAO.UsuarioComumDAO;
import Objetos.entidades.Cartao;
import Objetos.entidades.CartaoCredito2;
import Objetos.entidades.Usuario;
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
        System.out.println("3- Realizar transações.");
        System.out.println("4- Efetuar pagamentos.");
        System.out.println("5- Consultar saldo.");
        System.out.println("6- Listar cartões do usuario.");
        System.out.println("7- Sair");
        System.out.print("Digite: ");
        return teclado.nextInt();
    }

    public static UsuarioComum metodoCadastrarUsuario() {
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

    private static void metodoGerarCartaoParaUsuario(UsuarioComum uc) {
        Scanner teclado = new Scanner(System.in);
        UsuarioComumDAO udao = new UsuarioComumDAO();

        System.out.println("Limite do cartão: ");
        String limite = teclado.next();

        Double limiteD = Double.valueOf(limite);

        udao.gerarCartaoCredito(uc, limiteD);

    }

    private static void metodoRealizarTransacao(Cartao c) {
        Scanner teclado = new Scanner(System.in);
        if (c.getTipo() == "credito") {
            CartaoCredito2DAO cc = new CartaoCredito2DAO();
            CartaoCredito2 cartaoCredito = (CartaoCredito2) c;
            System.out.println("Valor da transação: ");
            double valorTransferir = teclado.nextDouble();
            cc.realizarTransacao(cartaoCredito, valorTransferir);

        }

    }

    private static void metodoRealizaPagamento(Cartao c) {
        Scanner teclado = new Scanner(System.in);
        if (c.getTipo() == "credito") {
            CartaoCredito2DAO cc = new CartaoCredito2DAO();
            CartaoCredito2 cartaoCredito = (CartaoCredito2) c;
            System.out.println("Valor da transação: ");
            double valorTransferir = teclado.nextDouble();
            cc.realizarTransacao(cartaoCredito, valorTransferir);

        }

    }

    private static void metodoSaldoDoCartao(Cartao c){
        if (c.getTipo() == "credito") {
            CartaoCredito2DAO cc = new CartaoCredito2DAO();
            CartaoCredito2 cartaoCredito = (CartaoCredito2) c;
            
            cc.consultarSaldo(cartaoCredito);

        }
    }

    private static void metodoListarCartoes(UsuarioComum uc) {
        UsuarioComumDAO udao = new UsuarioComumDAO();
        udao.listarCartoes(uc);

    }

    public static void main(String[] args) throws Exception {
        ArrayList<UsuarioComum> usuarioComums = new ArrayList<UsuarioComum>();
        int op;

        do {
            op = menu();
            switch (op) {
                case 1: {
                    UsuarioComum uc = metodoCadastrarUsuario();
                    usuarioComums.add(uc);
                    break;
                }

                case 2: {
                    Scanner teclado = new Scanner(System.in);
                    if (usuarioComums.size() > 0) {
                        int i = 1;
                        for (UsuarioComum e : usuarioComums) {
                            System.out.println(i + " Nome:" + e.getNome() + " | Documento: " + e.getDocumento());
                            i++;
                        }

                        System.out.println("Escolha o usuário (pelo número): ");
                        int index = teclado.nextInt() - 1;
                        try {
                            UsuarioComum uc = usuarioComums.get(index);
                            metodoGerarCartaoParaUsuario(uc);

                        } catch (Exception e) {
                            System.out.println("Número de usuário inválido");
                            // System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("Nenhum usuário cadastrado.");
                    }

                    break;
                }
                case 3: {
                    Scanner teclado = new Scanner(System.in);
                    if (usuarioComums.size() > 0) {
                        int i = 1;
                        for (UsuarioComum e : usuarioComums) {
                            System.out.println(i + " Nome:" + e.getNome() + " | Documento: " + e.getDocumento());
                            i++;
                        }

                        System.out.println("Escolha o usuário (pelo número): ");
                        int index = teclado.nextInt() - 1;
                        try {
                            UsuarioComum uc = usuarioComums.get(index);
                            ArrayList<Cartao> listaCartoes = uc.getCartaoCredito();

                            System.out.println("Escolha o cartão do usuário: ");
                            if (listaCartoes.size() > 0) {
                                int j = 1;

                                for (Cartao c : listaCartoes) {
                                    System.out.println(j + " - Num cartão: " + c.getNumCartao());
                                    j++;
                                }
                                System.out.println("Escolha o cartão (pelo número): ");
                                int indexCartao = teclado.nextInt() - 1;
                                Cartao c = listaCartoes.get(indexCartao);
                                metodoRealizarTransacao(c);

                            } else {
                                System.out.println("Esse usuario ainda não possui nenhum cartão.");
                            }

                        } catch (Exception e) {
                            System.out.println("Número de usuário inválido");
                            // System.out.println(e.getMessage());
                        }

                        // realizar transacoes
                        break;
                    }
                }

                case 4: {
                    // efetuar pagamento

                    Scanner teclado = new Scanner(System.in);
                    if (usuarioComums.size() > 0) {
                        int i = 1;
                        for (UsuarioComum e : usuarioComums) {
                            System.out.println(i + " Nome:" + e.getNome() + " | Documento: " + e.getDocumento());
                            i++;
                        }

                        System.out.println("Escolha o usuário (pelo número): ");
                        int index = teclado.nextInt() - 1;
                        try {
                            UsuarioComum uc = usuarioComums.get(index);
                            ArrayList<Cartao> listaCartoes = uc.getCartaoCredito();

                            System.out.println("Escolha o cartão do usuário: ");
                            if (listaCartoes.size() > 0) {
                                int j = 1;

                                for (Cartao c : listaCartoes) {
                                    System.out.println(j + " - Num cartão: " + c.getNumCartao());
                                    j++;
                                }
                                System.out.println("Escolha o cartão (pelo número): ");
                                int indexCartao = teclado.nextInt() - 1;
                                Cartao c = listaCartoes.get(indexCartao);
                                metodoRealizaPagamento(c);
                            } else {
                                System.out.println("Esse usuario ainda não possui nenhum cartão.");
                            }

                        } catch (Exception e) {
                            System.out.println("Número de usuário inválido");
                            // System.out.println(e.getMessage());
                        }

                        
                        break;
                    } else {
                        System.out.println("Nenhum usuario cadastrado.");
                    }
                }
                case 5: {
                    // consultar saldo
                    Scanner teclado = new Scanner(System.in);
                    if (usuarioComums.size() > 0) {
                        int i = 1;
                        for (UsuarioComum e : usuarioComums) {
                            System.out.println(i + " Nome:" + e.getNome() + " | Documento: " + e.getDocumento());
                            i++;
                        }

                        System.out.println("Escolha o usuário (pelo número): ");
                        int index = teclado.nextInt() - 1;
                        try {
                            UsuarioComum uc = usuarioComums.get(index);
                            ArrayList<Cartao> listaCartoes = uc.getCartaoCredito();

                            System.out.println("Escolha o cartão do usuário: ");
                            if (listaCartoes.size() > 0) {
                                int j = 1;

                                for (Cartao c : listaCartoes) {
                                    System.out.println(j + " - Num cartão: " + c.getNumCartao());
                                    j++;
                                }
                                System.out.println("Escolha o cartão (pelo número): ");
                                int indexCartao = teclado.nextInt() - 1;
                                Cartao c = listaCartoes.get(indexCartao);
                                metodoSaldoDoCartao(c);

                            } else {
                                System.out.println("Esse usuario ainda não possui nenhum cartão.");
                            }

                        } catch (Exception e) {
                            System.out.println("Número de usuário inválido");
                            // System.out.println(e.getMessage());
                        }

                        
                        break;
                    } else {
                        System.out.println("Nenhum usuario cadastrado.");
                    }
                }

                case 6: {
                    // listar cartoes
                    Scanner teclado = new Scanner(System.in);
                    if (usuarioComums.size() > 0) {
                        int i = 1;
                        for (UsuarioComum e : usuarioComums) {
                            System.out.println(i + " Nome:" + e.getNome() + " | Documento: " + e.getDocumento());
                            i++;
                        }

                        System.out.println("Escolha o usuário (pelo número): ");
                        int index = teclado.nextInt() - 1;
                        try {
                            UsuarioComum uc = usuarioComums.get(index);
                            metodoListarCartoes(uc);

                        } catch (Exception e) {
                            System.out.println("Número de usuário inválido");
                            // System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("Nenhum usuário cadastrado.");
                    }

                    break;
                }

                case 7: {
                    System.out.println("Saindo...");
                    break;
                }

                default:
                    System.out.println("Opção inválida!!!");
                    break;
            }
        } while (op != 7);

    }
}
