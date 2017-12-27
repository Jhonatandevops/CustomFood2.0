package br.com.customfood.dados;

import br.com.customfood.entidade.Refeicao.RefeicaoC;

import java.io.*;
import java.util.HashSet;

public class RefeicaoDados {

    private HashSet<RefeicaoC> refeicao = new HashSet();

    private final File arquivo = new File("refeicao.ser");

    private void recuperaDadosRefeicao() throws IOException, ClassNotFoundException {
        
        FileInputStream fis = new FileInputStream(arquivo);
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            refeicao = (HashSet<RefeicaoC>) ois.readObject();
        }
    }

    private void gravarDadosRefeicao() throws IOException {
        FileOutputStream fos = new FileOutputStream(arquivo);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(refeicao);
        }

    }


    public void removerRefeicao(RefeicaoC r) throws IOException, ClassNotFoundException {
        recuperaDadosRefeicao();
        
        if(refeicao.contains(r)) {
            refeicao.remove(r);
            gravarDadosRefeicao();
        }
        
    }
    public RefeicaoC consultaRefeicao(String nome) throws IOException, ClassNotFoundException {
        
        //Verifica se arquivo existe antes de fazer a consulta
        if(!arquivo.exists())
            return null;
        
        recuperaDadosRefeicao();
        
        for(RefeicaoC r : refeicao){
            if(r.getNome().toLowerCase().equals(nome.toLowerCase()))
                return r;
        }
        
        return null;
    }
    
    public RefeicaoC consultaRefeicaoPorId(String id) throws IOException, ClassNotFoundException {
        
        //Verifica se arquivo existe antes de fazer a consulta
        if(!arquivo.exists())
            return null;
        
        recuperaDadosRefeicao();
        
        for(RefeicaoC r : refeicao){
            if(r.getIdRefeicao().equals(id))
                return r;
        }
        
        return null;
    }
    
    
    public void mostrarRefeicao(String id) throws IOException, ClassNotFoundException {
        //Funcao alterada para buscar refeicao pelo id e mostrar o resultado
        
        RefeicaoC r = consultaRefeicao(id);
        if(r != null)
            System.out.println(r);
        else
            System.out.println("Refeicao nao encontrada");

    }



    public void atualizarRefeicao(RefeicaoC original, RefeicaoC r) throws IOException, ClassNotFoundException {
        
        recuperaDadosRefeicao();
        
        
        if(refeicao.contains(original)) {
            refeicao.remove(original);
            refeicao.add(r);
        }
        
        gravarDadosRefeicao();
        
    }

    public void cadastrarRefeicao(RefeicaoC r) throws IOException, ClassNotFoundException {
        if(arquivo.exists()){
            recuperaDadosRefeicao();
        }else{
            arquivo.createNewFile();
            refeicao = new HashSet<>();
        }
        refeicao.add(r);
        gravarDadosRefeicao();
        System.out.println(refeicao);
    }

    //Retorna refeicao apenas de um tipo especifico
    public HashSet<RefeicaoC> exibirRefeicao(String tipo) throws IOException, ClassNotFoundException {
        
        HashSet<RefeicaoC> copia = new HashSet();
        
        if(arquivo.exists()){
            recuperaDadosRefeicao();
            
            for(RefeicaoC r : refeicao) {
                if(r.getTipo().toLowerCase().equals(tipo.toLowerCase()))
                    copia.add(r);
            }
            
        }else{
            return copia;
        }
        return copia;
    }
    
    //Retorna refeicoes de ambos os tipos
    public HashSet<RefeicaoC> exibirRefeicao() throws IOException, ClassNotFoundException {
        if(!arquivo.exists())
            return new HashSet<RefeicaoC>();
        
        recuperaDadosRefeicao();
        
        return refeicao;
    }
    
    //Alterada para remover redundancia de codigo
    public boolean verificaSeRefeicaoExiste(RefeicaoC r) throws IOException, ClassNotFoundException {
        if(!arquivo.exists())
            return false;
        recuperaDadosRefeicao();
        
        return refeicao.contains(r);
    }
}
