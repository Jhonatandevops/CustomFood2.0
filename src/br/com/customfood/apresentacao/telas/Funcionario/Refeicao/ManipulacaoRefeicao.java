package br.com.customfood.apresentacao.telas.Funcionario.Refeicao;


import br.com.customfood.entidade.Refeicao.RefeicaoC;
import java.util.Scanner;

public class ManipulacaoRefeicao {
    Scanner sc = new Scanner(System.in);



    public RefeicaoC preencherRefeicao(String tipo){
        System.out.println();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.println("Tipo: " + tipo.toUpperCase());
        System.out.print("Observação: ");
        String obs = sc.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(sc.nextLine());
        System.out.print("Preço: ");
        double preco = Double.parseDouble(sc.nextLine());

        return new RefeicaoC(id,nome,tipo,obs,quantidade,preco);
    }

    public String consultarRefeicao(){
        System.out.println();
        System.out.print("Digite o ID: ");
        return sc.nextLine();
    }

    public String removerRefeicao(){
        System.out.println();
        System.out.print("Digite o ID: ");
        return sc.nextLine();

    }

    public RefeicaoC atualizarRefeicao(){
        System.out.println();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("ID da Refeição que será atualizada: ");
        String id = sc.nextLine();
        
        String opcao = "";
        
        do {
            System.out.print("Tipo (1 - Ingrediente | 2 - Prato): ");
            opcao = sc.nextLine();
        }while(!opcao.equals("1") && !opcao.equals("2"));
        
        String tipo = opcao.equals("1") ? "ingrediente" : "Prato";
        
        
        System.out.print("Observação: ");
        String obs = sc.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(sc.nextLine());
        System.out.print("Preço: ");
        double preco = Double.parseDouble(sc.nextLine());

        return new RefeicaoC(id,nome,tipo,obs,quantidade,preco);
    }
}
