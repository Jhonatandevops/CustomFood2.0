package br.com.customfood.apresentacao.telas.Funcionario;


public class TelaFuncionario {

    protected static void telaFuncionario(){
        System.out.println();
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println();
        System.out.println("1 - CLIENTE");
        System.out.println("2 - REFEIÇÕES");
        System.out.println("3 - GERAR RELATÓRIO");
        System.out.println("0 - SAIR");
        System.out.println("===========================");
    }

    protected static void opcaoCliente(){
        System.out.println();
        System.out.println("CLIENTES");
        System.out.println();
        System.out.println("1 - CADASTRAR CLIENTES");
        System.out.println("2 - CONSULTAR CLIENTES");
        System.out.println("3 - ATUALIZAR CLIENTES");
        System.out.println("4 - REMOVER CLIENTES");
        System.out.println("5 - MOSTRAR CLIENTES");
        System.out.println("6 - VOLTAR");
        System.out.println("===========================");
    }

    
    protected static void opcaoRefeicao(){
        System.out.println();
        System.out.println("ESCOLHA O TIPO");
        System.out.println();
        System.out.println("1 - INGREDIENTE");
        System.out.println("2 - PRATOS PRONTOS");
        System.out.println("===========================");
    } 
    
    protected static void opcaoRelatorio(){
        System.out.println();
        System.out.println("ESCOLHA O TIPO");
        System.out.println();
        System.out.println("1 - POR CLIENTE");
        System.out.println("2 - POR DATA");
        System.out.println("3 - TODOS OS PEDIDOS");
        System.out.println("===========================");
    }
    
    protected static void opcaoGenerica() {
        System.out.println("1 - CADASTRAR REFEICAO");
        System.out.println("2 - CONSULTAR REFEICAO");
        System.out.println("3 - ATUALIZAR REFEICAO");
        System.out.println("4 - REMOVER REFEICAO");
        System.out.println("5 - MOSTRAR REFEICAO");
        System.out.println("6 - VOLTAR");
        System.out.println("===========================");
    }
}
