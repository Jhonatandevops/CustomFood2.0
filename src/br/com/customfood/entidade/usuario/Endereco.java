package br.com.customfood.entidade.usuario;

import java.io.Serializable;

public class Endereco implements Serializable{
    private String rua;
    private String cidade;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }


    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
