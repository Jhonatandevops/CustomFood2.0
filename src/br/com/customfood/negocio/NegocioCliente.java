package br.com.customfood.negocio;

import br.com.customfood.dados.ClienteDados;
import br.com.customfood.entidade.usuario.Cliente;

import java.io.IOException;
import java.util.HashSet;

public class NegocioCliente {
    private ClienteDados clienteDados = new ClienteDados();

    public String cadastrarCliente(Cliente cliente) throws IOException, ClassNotFoundException {
        if(this.clienteDados.verificaSeClienteExiste(cliente) == true){
            return "CPF "+cliente.getCpf()+" já cadastrado";
        }
        clienteDados.cadastrarCliente(cliente);
        return "Cliente cadastrado com sucesso!";
    }

    //Alterado tipo de retorno
    public HashSet<Cliente> exibir(ClienteDados c) throws IOException, ClassNotFoundException {
        return c.exibirClientes();
    }

    public String removerCliente(Cliente c) throws IOException, ClassNotFoundException {
        
        //Verifica se cliente existe
        if(this.clienteDados.verificaSeClienteExiste(c) != true){
            return "CPF "+c.getCpf()+" nao cadastrado";
        }
        
        clienteDados.removerCliente(c);
        return "Cliente removido com sucesso";
    }

    public String consultarCliente(Cliente c) throws IOException, ClassNotFoundException {
        
        //Verifica se cliente existe
        if(this.clienteDados.verificaSeClienteExiste(c) != true){
            return "CPF "+c.getCpf()+" nao cadastrado";
        }
        
        clienteDados.mostrarClientes(c.getCpf());
        return "Cliente consultado";
    }

    public String atualizarCliente(Cliente c) throws IOException, ClassNotFoundException {
        
        //Verifica se cliente existe antes de atualiza-lo
        if(this.clienteDados.verificaSeClienteExiste(c) != true){
            return "CPF "+c.getCpf()+" nao cadastrado";
        }
        
        clienteDados.atualizarCliente(c);
        return "Cliente atualizado";
    }


}
