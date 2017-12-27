/*
 * Exception lançada quando o cliente envia um pedido sem itens
 */
package br.com.customfood.excecoes;


public class PedidoVazioException extends Exception {
        public PedidoVazioException(String msg) {
        super(msg);
    }
}
