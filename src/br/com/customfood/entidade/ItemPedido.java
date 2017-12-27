/*
*
* Classe que armazena informações de cada item do pedido
*/


package br.com.customfood.entidade;

import br.com.customfood.entidade.Refeicao.RefeicaoC;
import java.io.Serializable;


import java.util.Objects;

public class ItemPedido implements Serializable {
    private RefeicaoC refeicao;
    private int quantidade = 0;

    public ItemPedido(RefeicaoC refeicao, int quantidade) {
        this.refeicao = refeicao;
        this.quantidade = quantidade;
    }



    public RefeicaoC getRefeicao() {
        return this.refeicao;
    }
    
    public double getValorTotal() {
        return quantidade * refeicao.getPreco();
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setRefeicao(RefeicaoC refeicao) {
        this.refeicao = refeicao;
    }

    //O Equals deve ser:
    //Reflexivo = x.equals(x) deve retornar true para tudo que for diferente de null.
    //Simétrico = para x e y diferentes de null, se x.equals(y) == true, logo y.equals(x) tem que ser true
    //transitividade = para x, y, z diferentes de null, se x.equals(y) == true, logo y.equals(x) == true, e x.equals(y) == true,
    // logo y.equals(z) também tem que ser true.
    //Consistente = x.equals(y) deve sempre retornar o mesmo valor.
    //Para x diferente de null x.equals(null) tem que retornar false;

    @Override
    public boolean equals(Object o) {
        
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        
        ItemPedido outro = (ItemPedido)o;
        
        if(this.getRefeicao().equals(outro.getRefeicao()))
            return true;
        
        return false;
    }

    //Utilizado pelo HashSet para armazenar um 'id' para cada item
    //

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.refeicao);
        return hash;
    }
    
    @Override
    public String toString() {
        return "nome: " + getRefeicao().getNome() 
                        + "\t|\tvalor unitario: R$" + getRefeicao().getPreco()
                        + "\t|\tquantidade: " + getQuantidade()
                        + "\t|\ttotal: R$" + getValorTotal();
    }
}
