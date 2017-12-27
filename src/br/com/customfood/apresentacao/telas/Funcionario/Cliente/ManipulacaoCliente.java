package br.com.customfood.apresentacao.telas.Funcionario.Cliente;

import br.com.customfood.dados.ClienteDados;
import br.com.customfood.entidade.usuario.Cliente;
import br.com.customfood.entidade.usuario.Endereco;
import br.com.customfood.excecoes.CpfInvalidoException;
import br.com.customfood.util.Cpf;

import java.util.Scanner;

public class ManipulacaoCliente {
    Scanner sc = new Scanner(System.in);
    ClienteDados clienteDados = new ClienteDados();

    public Cliente preencher(){

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        
        Cpf cpf;
        
        while(true){
            
            try {
                System.out.print("CPF: ");
                String cpf_num = sc.nextLine();
                
                cpf = new Cpf(cpf_num);
                
                Endereco endereco = new Endereco();
                System.out.print("Rua: ");
                endereco.setRua(sc.nextLine());
                System.out.print("Cidade: ");
                endereco.setCidade(sc.nextLine());
                System.out.print("Digite o telefone com DDD: ");
                String telefone = sc.nextLine();
                return new Cliente(nome, endereco, cpf, telefone);
                
            }catch(CpfInvalidoException e) {
                System.err.println("CPF inválido, não utilize pontos nem traços.");
                continue;
            }  
        }//fim while
    }

    public Cliente consultarCliente(){
        
        Cpf cpf;
        
        while(true){
            
            try {
                System.out.print("CPF: ");
                String cpf_num = sc.nextLine();
                
                cpf = new Cpf(cpf_num);
                return new Cliente(cpf);
                
            }catch(CpfInvalidoException e) {
                System.err.println("CPF inválido, não utilize pontos nem traços.");
                continue;
            }  
        }//fim while
    }

    public Cliente removerCliente(){

        Cpf cpf;
        
        while(true){
            
            try {
                System.out.print("CPF: ");
                String cpf_num = sc.nextLine();
                
                cpf = new Cpf(cpf_num);
                return new Cliente(cpf);
                
            }catch(CpfInvalidoException e) {
                System.err.println("CPF inválido, não utilize pontos nem traços.");
                continue;
            }  
        }//fim while
    }

    public Cliente atualizarCliente(){
        
        Cpf cpf;
        
        while(true){
            
            try {
                System.out.print("CPF do cliente que será atualizado: ");
                String cpf_num = sc.nextLine();
                
                cpf = new Cpf(cpf_num);
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                Endereco endereco = new Endereco();
                System.out.print("Rua: ");
                endereco.setRua(sc.nextLine());
                System.out.print("Cidade: ");
                endereco.setCidade(sc.nextLine());
                System.out.print("Digite o telefone com DDD: ");
                String telefone = sc.nextLine();
                return new Cliente(nome, endereco, cpf, telefone);
                
            }catch(CpfInvalidoException e) {
                System.err.println("CPF inválido, não utilize pontos nem traços.");
                continue;
            }  
        }//fim while
        
    }
}
