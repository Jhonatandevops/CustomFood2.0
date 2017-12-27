/*
* Classe que representa o cliente logado no sistema
*/

package br.com.customfood.entidade.usuario;

import br.com.customfood.excecoes.CpfInvalidoException;
import br.com.customfood.util.Cpf;

import java.io.Serializable;
import java.util.Objects;

public class Cliente extends Usuario implements Serializable {
    private String nome;
    private String telefone;
    private Endereco endereco;


    public Cliente(Cpf cpfCliente) throws CpfInvalidoException{
        super(cpfCliente, "cliente");
    }

    public Cliente(String nomePessoa, Endereco endereco, Cpf cpfCliente, String telefone) throws CpfInvalidoException {
        super(cpfCliente, "cliente");
        this.nome = nomePessoa;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public void setNome(String n) {
        nome = n;
    }
    
    public String getNome() {
        return nome;
    }
    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        
        Cliente outro = (Cliente)o;
        
        if(!this.getCpf().equals(outro.getCpf()))
            return false;
        
        if(outro.getCpf() == null)
            if(this.getCpf() != null)
                return false;
        
        return true;
    }

    
    //Utilizado pelo Set como um id para identificar um item
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.getCpf().getNumeros());
        return hash;
    }
    

    @Override
    public String toString() {
        return "\nNome: " + this.getNome() + " | CPF: " + this.getCpf() +
                " | Rua: " + this.getEndereco().getRua() + " | Cidade: " + this.getEndereco().getCidade() +
                " | Telefone: " + getTelefone() +
                "]"
                + "\n---------------------------------------------------------------------------------------------------------------\n";
    }
}