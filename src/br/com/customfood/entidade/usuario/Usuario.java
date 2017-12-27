/*
 * Classe que armazena informações comuns de todos os usuarios
 */
package br.com.customfood.entidade.usuario;

import br.com.customfood.excecoes.CpfInvalidoException;
import br.com.customfood.util.Cpf;
import java.io.Serializable;

public abstract class Usuario implements Serializable {
    Cpf cpf;
    String tipo; //Cliente ou Funcionario
    
    public Usuario(Cpf c, String t) throws CpfInvalidoException {
        cpf = c;
        tipo = t;
    }
    
    public Cpf getCpf() {
        return cpf;
    }
    
    public void setCpf(Cpf c) {
        cpf = c;
    }

}