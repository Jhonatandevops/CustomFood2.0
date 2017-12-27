package br.com.customfood.apresentacao.telas.Cliente;

import br.com.customfood.dados.ClienteDados;
import br.com.customfood.dados.PedidoDados;
import br.com.customfood.dados.RefeicaoDados;
import br.com.customfood.entidade.ItemPedido;
import br.com.customfood.entidade.Pedido;
import br.com.customfood.entidade.Refeicao.RefeicaoC;
import br.com.customfood.entidade.usuario.Cliente;
import br.com.customfood.excecoes.PedidoVazioException;
import br.com.customfood.util.UsuarioLogado;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;

public class MenuCliente {
    
    private static Scanner sc = new Scanner(System.in);
    static String opcao = "";
    static ClienteDados clienteDados = new ClienteDados();
    static PedidoDados pedidoDados = new PedidoDados();
    static final double DESCONTO = 15; //Valor do desconto
    
    
    public static void escolher() throws IOException, ClassNotFoundException {
        
        
        while(true) {
            TelaCliente.opcaoCliente();
            opcao = sc.nextLine();

            switch(opcao) {
                case "1":
                    RefeicaoDados rDados = new RefeicaoDados();
                    HashSet<RefeicaoC> refeicoes = rDados.exibirRefeicao(); //Faz a busca de refeicoes disponiveis no banco de dados para exibir no cardapio
                    
                    Cliente cliente = clienteDados.consulta(UsuarioLogado.CPF); //Obtem cpf do usuario logado,
                                                                                //Cpf é necessario para identificar quem fez o pedido
                    HashSet<ItemPedido> listaDeItems = new HashSet();   //Armazena itens pedidos pelo cliente
                    
                    Calendar c = Calendar.getInstance(); //Obtem instancia da classe Calendar para obtencao das datas
                    
                    //Cria string com a data atual no formato xx/xx/xxxx
                    //A contagem do mes inicia em 0, por tanto deve-se somar + 1
                    String data_atual = String.format("%02d",c.get(Calendar.DAY_OF_MONTH)) + "/" +
                                        String.format("%02d", (c.get(Calendar.MONTH) + 1)) + "/" + 
                                        String.format("%04d",c.get(Calendar.YEAR)); 
                    
                    Pedido pedido = new Pedido(cliente, data_atual, DESCONTO);    //Cria novo pedido | adicionado data_atual no construtor

                    int quantidade = 0;
                    int i = 0;
                    int opcaoRefeicao = 0;

                    //Converte HashSet para arraylist para podermos
                    //referenciar cada item da lista por um indice
                    ArrayList<RefeicaoC> cardapio = new ArrayList();
                    for(RefeicaoC r : refeicoes) {
                        cardapio.add(r);
                    }

                    do {


                        //Exibe cardapio
                        System.out.println();
                        System.out.println("=========CARDAPIO============");


                        for(i = 0; i < cardapio.size(); i++) {
                            System.out.println(Integer.toString(i+1) + " - " + cardapio.get(i).getNome() + " | R$ " + cardapio.get(i).getPreco());
                        }

                        System.out.println("=============================");
                        
                        //Fim do cardapio

                        try {

                            System.out.print("Selecione uma refeicao para adicionar a lista de pedidos(Digite 0 para fechar o pedido): ");
                            opcaoRefeicao = Integer.parseInt(sc.nextLine());
                            
                            if(opcaoRefeicao == 0) {
                                break;
                            }
                            
                            //Volta ao menu caso o valor esteja fora da faixa disponivel no menu
                            if((opcaoRefeicao < 0) || (opcaoRefeicao > (cardapio.size()))) {
                                System.err.println("Valor invalido, por favor tente novamente");
                                continue;
                            }

                        } catch(NumberFormatException e) {
                            System.err.println("Valor invalido, por favor tente novamente");
                            continue;
                        }


                        try {

                            int quantidadeDisponivel = cardapio.get(opcaoRefeicao - 1).getQuantidade();
                            
                            if(quantidadeDisponivel == 0) {
                                System.err.println("ERRO: Produto nao disponivel");
                                continue;
                            }
                            
                            //Faz a leitura da quantidade desejada
                            System.out.print("Digite a quantidade desejada (" + "disponivel: " + quantidadeDisponivel + "): ");
                            quantidade = Integer.parseInt(sc.nextLine());
                            
                            //Verifica se a quantidade desejada esta disponivel
                            if((quantidade <= quantidadeDisponivel) && (quantidade > 0)) {
                                ItemPedido item = new ItemPedido(cardapio.get(opcaoRefeicao - 1), quantidade);
                                
                                //Verifica se o item ja existe na lista de pedidos
                                if(listaDeItems.contains(item)) {
                                    System.err.println("ERRO: Esse item ja se encontra na lista de pedidos");
                                    continue;
                                }
                                
                                //Adiciona item na lista de pedidos
                                listaDeItems.add(item);
                            }
                            else {
                                System.err.println("ERRO: Nao ha disponibilidade do produto para a quantidade informada, tente novamente");
                            }

                        } catch(NumberFormatException e) {
                            System.err.println("Valor invalido, por favor tente novamente");
                            continue;
                        }
                            

                    } while(opcaoRefeicao != 0); //Fim Exibe cardapio


                    //Exibe a lista com os pedidos do cliente
                    System.out.println("=========SUA LISTA=========");

                    
                    pedido.limparItems();
                    
                    for(ItemPedido p : listaDeItems) {
                        System.out.println(p);
                        pedido.adicionarItem(p);
                    }
                    
                    System.out.println("Valor Total: R$" + pedido.getValorTotal());
                    System.out.print("Confirmar Pedido?(s/n): ");
                    String confirmaPedido = sc.nextLine();
                    
                    
                    //Se o cliente confirmar o pedido, grava no banco de dados
                    if(confirmaPedido.toLowerCase().equals("s")) {
                        PedidoDados pedidoDados = new PedidoDados();
                        
                        try {
                            pedidoDados.cadastrarPedido(pedido);
                            
                            
                            //Atualiza quantidade disponivel
                            for(ItemPedido p : listaDeItems) {
                                
                                RefeicaoC r = p.getRefeicao();
                                //Subtrai quantidade do pedido da quantidade disponivel
                                r.setQuantidade(r.getQuantidade() - p.getQuantidade());
                                
                                rDados.atualizarRefeicao(p.getRefeicao(), r);
                            }
                            
                        } catch(PedidoVazioException e) {
                            System.err.println("Erro: " + e.getMessage());
                        }
                        finally {
                            sc.nextLine();
                        }
                        
                    }
                    break;
                
                case "0":
                    return;
                    
                default:
                    return;
            }
        }
        
    }
}
