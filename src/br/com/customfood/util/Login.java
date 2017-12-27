package br.com.customfood.util;

import br.com.customfood.dados.ClienteDados;
import br.com.customfood.excecoes.CpfInvalidoException;

import java.io.IOException;

public class Login {
    ClienteDados clienteDados = new ClienteDados();


    public String validarSenha(String nome, Cpf cpf) throws IOException, ClassNotFoundException, CpfInvalidoException {

        Cpf adminCpf = new Cpf("11575369486");
        
        if (nome.equalsIgnoreCase("cliente") && (clienteDados.consulta(cpf) != null)) {
            
            //Guarda informacoes do usuario logado para serem usados em outras consultas
            UsuarioLogado.CPF = cpf;
            UsuarioLogado.TIPO = "cliente";
            UsuarioLogado.NOME = clienteDados.consulta(cpf).getNome();
            
            return "cliente";
            
        }else if (nome.equals("admin") && cpf.equals(adminCpf)) {
            
            //Guarda informacoes do usuario logado para serem usados em outras consultas
            UsuarioLogado.CPF = new Cpf("11575369486");
            UsuarioLogado.TIPO = "funcionario";
            UsuarioLogado.NOME = "Admin";
            
            return "admin";
        }else {
            return "error";
        }
    }
}
