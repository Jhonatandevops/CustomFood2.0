package br.com.customfood.entidade.Refeicao;

import java.io.Serializable;
import java.util.Objects;

public class RefeicaoC implements Serializable {
    private String idRefeicao;
    private String nome;
    private String tipo;
    private String obs;
    private int quantidade;
    private double preco;

    public RefeicaoC(){

    }



    public RefeicaoC(String idRefeicao, String nome, String tipo, String obs, int quantidade, double preco) {
        this.idRefeicao = idRefeicao;
        this.nome = nome;
        this.tipo = tipo;
        this.obs = obs;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public RefeicaoC(String nome){
        this.nome = nome;
    }

    public String getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(String idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        obs = obs;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Double calcPrecoTotal(){
        Double result = getPreco() * getQuantidade();
        return result;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        
        RefeicaoC outro = (RefeicaoC) o;
        
        
        //Verifica se os valores do id sao iguais
        
        if(this.getIdRefeicao().equals(outro.getIdRefeicao()))
            return true;
        
        if(outro.getIdRefeicao() == null)
            if(this.getIdRefeicao() != null)
                return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idRefeicao);
        return hash;
    }
    
    @Override
    public String toString() {
        return "\nID: " + idRefeicao + " | Nome: " + nome +
                " | Tipo: " + tipo + " | Observação: " + obs +
                " | Quantidade: " + quantidade + " | Preço: " + preco +
                "]"
                + "\n---------------------------------------------------------------------------------------------------------------\n";
    }
}
