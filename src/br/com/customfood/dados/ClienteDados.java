package br.com.customfood.dados;

import br.com.customfood.entidade.usuario.Cliente;
import br.com.customfood.util.Cpf;

import java.io.*;
import java.util.HashSet;

public class ClienteDados {

    HashSet<Cliente> clientes;//HashSet implementa Set

    File arquivo = new File("clientes.ser");

    public void recuperaDados() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(arquivo);
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            clientes = (HashSet<Cliente>) ois.readObject();
        }
    }

    public void gravarDados() throws IOException {
        FileOutputStream fos = new FileOutputStream(arquivo);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(clientes);
        }

    }


    public void removerCliente(Cliente c) throws IOException, ClassNotFoundException {
        recuperaDados();
        if(clientes.contains(c)) {
            clientes.remove(c);
            gravarDados();
        }
    }
    //Adaptado para realizar a busca usando Set
    public Cliente consulta(Cpf cpf) throws IOException, ClassNotFoundException {
        
        //Verifica se arquivo existe antes de fazer a consulta
        if(!arquivo.exists())
            return null;
        
        recuperaDados();
        for(Cliente c : clientes){
            if(c.getCpf().equals(cpf))
                return c;
        }
        return null;
    }
    public void mostrarClientes(Cpf cpf) throws IOException, ClassNotFoundException {
        //Funcao alterada para buscar cliente pelo cpf e mostrar o resultado
        
        Cliente c = consulta(cpf);
        if(c != null)
            System.out.println(c);
        else
            System.out.println("Cliente nao encontrado");
    }


    public void atualizarCliente(Cliente c) throws IOException, ClassNotFoundException {
        recuperaDados();
        
        
        if(clientes.contains(c)) {
            clientes.remove(c);
            clientes.add(c);
        }
        
        gravarDados();
    }

    public void cadastrarCliente(Cliente c) throws IOException, ClassNotFoundException {
        if(arquivo.exists()){
            recuperaDados();
        }else{
            arquivo.createNewFile();
            clientes = new HashSet<>();
        }
        clientes.add(c);
        gravarDados();
        System.out.println(clientes);
    }

    public HashSet<Cliente> exibirClientes() throws IOException, ClassNotFoundException {
        if(arquivo.exists()){
            recuperaDados();
        }else{
            clientes = new HashSet<>();
        }
        return clientes;
    }

    //Alterada para remover redundancia de codigo
    public boolean verificaSeClienteExiste(Cliente c) throws IOException, ClassNotFoundException {
        if(!arquivo.exists())
            return false;
        
        recuperaDados();
        return clientes.contains(c);
    }

}
