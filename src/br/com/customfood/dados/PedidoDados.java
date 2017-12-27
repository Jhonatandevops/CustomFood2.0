package br.com.customfood.dados;


import br.com.customfood.entidade.Pedido;
import br.com.customfood.excecoes.PedidoVazioException;
import br.com.customfood.util.Cpf;
import java.io.*;
import java.util.HashSet;

public class PedidoDados {

    private HashSet<Pedido> pedidos = new HashSet();

    private final File arquivo = new File("pedidos.ser");

    private void recuperaDados() throws IOException, ClassNotFoundException {
        
        FileInputStream fis = new FileInputStream(arquivo);
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            pedidos = (HashSet<Pedido>) ois.readObject();
        }
    }

    private void gravarDados() throws IOException {
        FileOutputStream fos = new FileOutputStream(arquivo);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(pedidos);
        }

    }


    public void cadastrarPedido(Pedido p) throws IOException, ClassNotFoundException, PedidoVazioException {
        
        if(p.getItens().isEmpty()) {
            throw new PedidoVazioException("Nao ha itens no pedido");
        }
        
        if(arquivo.exists()){
            recuperaDados();
        }else{
            arquivo.createNewFile();
            pedidos = new HashSet<>();
        }
        pedidos.add(p);
        gravarDados();
        System.out.println("Pedido cadastrado com sucesso...");
    }

    
    
    //Retorna pedido apenas de um cliente especifico
    public HashSet<Pedido> obterPedidos(Cpf cpf) throws IOException, ClassNotFoundException {
        
        HashSet<Pedido> copia = new HashSet();
        
        if(arquivo.exists()){
            recuperaDados();
            
            for(Pedido p : pedidos) {
                if(p.getCliente().getCpf().equals(cpf))
                    copia.add(p);
            }
            
        }else{
            return copia;
        }
        return copia;
    }
    
    //Retorna pedido apenas de um cliente especifico
    public HashSet<Pedido> obterPedidos(String data) throws IOException, ClassNotFoundException {
        
        HashSet<Pedido> copia = new HashSet();
        
        if(arquivo.exists()){
            recuperaDados();
            
            for(Pedido p : pedidos) {
                if(p.getData().equals(data))
                    copia.add(p);
            }
            
        }else{
            return copia;
        }
        return copia;
    }
    
    //Retorna pedidos de todos os clientes
    public HashSet<Pedido> obterPedidos() throws IOException, ClassNotFoundException {
        if(!arquivo.exists())
            return new HashSet<Pedido>();
        
        recuperaDados();
        
        return pedidos;
    }
    
}
