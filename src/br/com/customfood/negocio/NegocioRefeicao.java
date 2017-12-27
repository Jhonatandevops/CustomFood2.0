package br.com.customfood.negocio;

import br.com.customfood.dados.RefeicaoDados;
import br.com.customfood.entidade.Refeicao.RefeicaoC;

import java.io.IOException;
import java.util.HashSet;

public class NegocioRefeicao {
    RefeicaoDados refeicaoDados = new RefeicaoDados();

    public String cadastrarRefeicao(RefeicaoC refeicaoC) throws IOException, ClassNotFoundException {
        
        if(this.refeicaoDados.verificaSeRefeicaoExiste(refeicaoC) == true){
            return "Esse id ja existe no banco de dados";
        }
        refeicaoDados.cadastrarRefeicao(refeicaoC);
        return "Refeição cadastrada com sucesso!";
    }

    public HashSet<RefeicaoC> exibirRefeicaoC(RefeicaoDados r) throws IOException, ClassNotFoundException {
        return r.exibirRefeicao();
    }

    public String removerRefeicaoC(String id) throws IOException, ClassNotFoundException {
        
        //Busca refeicao pelo nome
        RefeicaoC resultado = refeicaoDados.consultaRefeicaoPorId(id);
        
        if(resultado == null){
            return "Refeicao nao encontrada";
        }
        
        refeicaoDados.removerRefeicao(resultado);
        return "Refeição: removido com sucesso";
    }

    public String consultarRefeicaoC(String id) throws IOException, ClassNotFoundException {
        
        RefeicaoC resultado = refeicaoDados.consultaRefeicaoPorId(id);
        
        if(resultado == null){
            return "Refeicao nao encontrada";
        }
        
        System.out.println(resultado);
        return "Refeição: "+resultado.getNome()+" encontrado";
    }

    public String atualizarRefeicaoC(RefeicaoC r) throws IOException, ClassNotFoundException {
        
        
        RefeicaoC resultado = refeicaoDados.consultaRefeicaoPorId(r.getIdRefeicao());
        
        if(resultado == null){
            return "Refeicao nao encontrada";
        }
        
        refeicaoDados.atualizarRefeicao(resultado, r);
        return "Refeição: "+resultado.getNome()+" atualizado";
    }
}
