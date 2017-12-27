package br.com.customfood.apresentacao.telas.Funcionario;

import br.com.customfood.apresentacao.telas.Funcionario.Cliente.ManipulacaoCliente;
import br.com.customfood.apresentacao.telas.Funcionario.Refeicao.ManipulacaoRefeicao;
import br.com.customfood.dados.ClienteDados;
import br.com.customfood.dados.PedidoDados;
import br.com.customfood.dados.RefeicaoDados;
import br.com.customfood.entidade.Pedido;
import br.com.customfood.entidade.usuario.Cliente;
import br.com.customfood.entidade.Refeicao.RefeicaoC;
import br.com.customfood.excecoes.CpfInvalidoException;
import br.com.customfood.negocio.NegocioCliente;
import br.com.customfood.negocio.NegocioRefeicao;
import br.com.customfood.util.Cpf;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class MenuFuncionario {
    private static Scanner sc = new Scanner(System.in);

    TelaFuncionario telaFuncionario = new TelaFuncionario();
    private static NegocioCliente negocioCliente = new NegocioCliente();
    private static ManipulacaoCliente manipulacaoCliente = new ManipulacaoCliente();

    private static NegocioRefeicao negocioRefeicao = new NegocioRefeicao();
    private static ManipulacaoRefeicao manipulacaoRefeicao = new ManipulacaoRefeicao();


    public static void escolher() throws IOException, ClassNotFoundException {
        
        RefeicaoC tipoRefeicao = new RefeicaoC();
        String opcao = "";
        String mensagem = "";
        
        while (!opcao.equals("0")) {
            TelaFuncionario.telaFuncionario();
            opcao = sc.nextLine();
            if (opcao.equals("1")) {
                TelaFuncionario.opcaoCliente(); //Método cliente
                opcao = sc.nextLine();
                switch (opcao) {
                    case "1":
                        Cliente preencher = manipulacaoCliente.preencher();
                        if(preencher != null) {
                            String mensagemPreencher = negocioCliente.cadastrarCliente(preencher);
                            System.out.println(mensagemPreencher);
                        }

                        break;
                    case "2":
                        Cliente consultar = manipulacaoCliente.consultarCliente();
                        String mensagemConsultar = negocioCliente.consultarCliente(consultar);
                        System.out.println(mensagemConsultar);
                        break;
                    case "3":
                        Cliente atualizar = manipulacaoCliente.atualizarCliente();
                        String mensagemAtualizar = negocioCliente.atualizarCliente(atualizar);
                        System.out.println(mensagemAtualizar);
                        break;
                    case "4":
                        Cliente remover = manipulacaoCliente.removerCliente();
                        String mensagemRemover = negocioCliente.removerCliente(remover);
                        System.out.println(mensagemRemover);
                        break;
                    case "5":
                        ClienteDados mostrar = new ClienteDados();
                        System.out.println(mostrar.exibirClientes());
                        break;
                    case "6":
                        TelaFuncionario.telaFuncionario();
                        break;
                    default:
                        System.err.println("Opção inválida");

                } //Fim opção cliente
            }//Fim opção cliente
            else if (opcao.equals("2")) { //Opção Refeição
                //TelaFuncionario.opcaoRefeicao();
                
                TelaFuncionario.opcaoGenerica();
                opcao = sc.nextLine();
                
                switch (opcao) {
                        case "1":
                            
                            
                            TelaFuncionario.opcaoRefeicao();
                            String opcao_refeicao = sc.nextLine();

                            String tipo = opcao_refeicao.equals("1") ? "ingrediente" : "prato";
                            
                            RefeicaoC preencherRefeicao = manipulacaoRefeicao.preencherRefeicao(tipo);
                            String mensagemPreencher = negocioRefeicao.cadastrarRefeicao(preencherRefeicao);
                            System.out.println(mensagemPreencher);
                            break;
                        case "2":
                            
                            String id = manipulacaoRefeicao.consultarRefeicao();
                            String mensagemConsultar = negocioRefeicao.consultarRefeicaoC(id);
                            System.out.println(mensagemConsultar);
                            
                            break;
                        case "3":

                            RefeicaoC atualizarRefeicao = manipulacaoRefeicao.atualizarRefeicao();
                            String mensagemAtualizar = negocioRefeicao.atualizarRefeicaoC(atualizarRefeicao);
                            System.out.println(mensagemAtualizar);
                            break;
                            
                        case "4":
                            id = manipulacaoRefeicao.removerRefeicao();
                            String mensagemRemover = negocioRefeicao.removerRefeicaoC(id);
                            System.out.println(mensagemRemover);
                            break;
                        case "5":
                            
                            RefeicaoDados mostrarRefeicaoDados = new RefeicaoDados();
                            System.out.println(mostrarRefeicaoDados.exibirRefeicao());
                            
                            break;
                        case "6":
                            break;
                        default:
                            System.err.println("opção inválida");
                    }
                
            }//fim opção de refeições
            else if (opcao.equals("3")) {// opção relatorio
                //System.out.println("gerar relatorio");
                
                int opcao_relatorio;
                
                while(true) {
                    
                    TelaFuncionario.opcaoRelatorio();
                    
                    try {
                            opcao_relatorio = Integer.parseInt(sc.nextLine());

                        } catch(NumberFormatException e) {
                            System.err.println("Valor invalido tente novamente");

                            continue;
                        }
                    
                    if(opcao_relatorio >= 1 && opcao_relatorio <= 3) {
                        
                        PedidoDados pedidoDados = new PedidoDados();
                        HashSet<Pedido> listaPedidos = new HashSet<Pedido>();
                        
                        try {
                            switch (opcao_relatorio) {
                                case 1:
                                    System.out.print("Digite o cpf do cliente: ");
                                    Cpf cpf = new Cpf(sc.nextLine());
                                    listaPedidos = pedidoDados.obterPedidos(cpf);
                                    break;
                                case 2:
                                    System.out.print("Digite a data no formato (XX/XX/XXXX): ");
                                    String data = sc.nextLine();
                                    listaPedidos = pedidoDados.obterPedidos(data);
                                    break;
                                default:
                                    listaPedidos = pedidoDados.obterPedidos();
                                    break;
                            }
                            
                            if(listaPedidos.isEmpty()) {
                                System.err.println("Nenhum pedido encontrado");
                                break;
                            }

                            
                            double total = 0;
                            
                            for(Pedido p : listaPedidos) {
                                System.out.println(p);
                                total += p.getValorTotal();
                            }
                            
                            System.out.println("Valor Total Dos Pedidos: " + total);
                            
                        }catch(CpfInvalidoException e) {
                            System.err.println(e.getMessage());
                            break;
                        }
                        finally {
                            break;
                        }
                        
                    }
                }
                
                
            }// fim opção relatorio
            else {
                if (!opcao.equals("0")) {
                    System.err.println("opção inválida");
                }
            } //Fim  relatorio
        }//fim while
        System.exit(0);
    }
}
