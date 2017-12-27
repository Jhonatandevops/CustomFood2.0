/*
* Armazena informações dos pedidos
*/

package br.com.customfood.entidade;

import br.com.customfood.entidade.usuario.Cliente;
import java.io.Serializable;
import java.util.ArrayList;


public class Pedido implements Serializable {
    private Cliente cliente;
    private ArrayList<ItemPedido> itens = new ArrayList(); //Lista de itens do pedido
    private String data;
    private double desconto;

    public Pedido(Cliente c, String data, double desconto) {
        this.cliente = c;
        this.data = data;
        this.desconto = desconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getData() {
        return this.data;
    }

    public ArrayList<ItemPedido> getItens() {
        return this.itens;
    }
    
    public void adicionarItem(ItemPedido i) {
        this.itens.add(i);
    }
    
    public void limparItems() {
        this.itens.clear();
    }
    
    //Calcula valor total, somando o preço de todos os itens do pedido
    public double getValorTotal() {
        double valorTotal = 0;
        int quantidade_itens = 0;
        
        for(ItemPedido item : itens) {
            valorTotal += item.getValorTotal();
            quantidade_itens += item.getQuantidade();
        }
        
        //Aplica desconto
        if(quantidade_itens > 2)
            return valorTotal - ((desconto/100) * valorTotal);
        else
            return valorTotal;
    }
    

    
    @Override
    public String toString() {
        return "Cliente: " 
                + getCliente().getNome() 
                + " | " + "CPF:" 
                + getCliente().getCpf() 
                + " | " + "Data: "
                + getData()
                + "\n" + itens.toString()
                + "\nValor Total Com Desconto: " + getValorTotal()
                + "\n===================================================\n";
    }
}
