/*
* Exception lançada quando se detecta um cpf invalido no programa
*/

package br.com.customfood.excecoes;


public class CpfInvalidoException extends Exception {

    public CpfInvalidoException(String msg) {
        super(msg);
    }
}
