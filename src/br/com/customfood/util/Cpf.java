/*
* Classe que armazena Cpf
*
* Ao chamar o construtor da classe verifica se o cpf é valido
* caso nao for lança exceção CpfInvalidoException
*/
package br.com.customfood.util;

import br.com.customfood.excecoes.CpfInvalidoException;
import java.io.Serializable;

/**
 *
 * @author DeadRoolz
 */
public class Cpf implements Serializable {
    
    String cpf;
    
    public Cpf(String cpf) throws CpfInvalidoException {
        if(ValidaCpf.isCPF(cpf) == false) {
            throw new CpfInvalidoException("CPF Invalido");
        }
        else {
            this.cpf = cpf;
        }
            
    }
    
    //Retorna apenas os numeros do cpf sem formatação
    public String getNumeros() {
        return cpf;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        
        Cpf outro = (Cpf)o;
        
        if(cpf.equals(outro.getNumeros()))
            return true;
        
        return false;
    }
    
    @Override
    public String toString() {
        return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
    }
    
}
