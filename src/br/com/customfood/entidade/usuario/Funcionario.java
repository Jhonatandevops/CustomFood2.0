/*
 * Classe que representa o funcionario logado no sistema
 */
package br.com.customfood.entidade.usuario;

import br.com.customfood.excecoes.CpfInvalidoException;
import br.com.customfood.util.Cpf;

public class Funcionario extends Usuario {
    
    private String nivel = "admin";
    private String nome = "admin";
    
    public Funcionario(Cpf c, String nome) throws CpfInvalidoException {
        super(c, "funcionario");
        this.nome = nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNivel(String n) {
        nivel = n;
    }
    
    public String getNivel() {
        return this.nivel;
    }
    
}
