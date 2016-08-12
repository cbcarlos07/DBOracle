/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Setor;
import java.util.Date;
import java.util.List;
import model.DAO.Setor_DAO;

/**
 *
 * @author linux
 */
public class Setor_Controller {
    Setor_DAO sd = new Setor_DAO();
    Setor s = new Setor();
    
    public boolean inserir(Setor st){
       boolean teste = sd.inserir(st);
       return teste;
    }
    
    public boolean alterar (Setor st){
        boolean teste = sd.alterar(st);
        return teste;
    }
    
    public List<Setor> lista (String nome){
        List lista = sd.listar(nome);
        return lista;         
    }
    
    public List<Setor> listaPorData (Date data1, Date data2){
        List lista = sd.listarPorData(data1, data2);
        return lista;         
    }
    public Setor recuperarSetor (int setor){
        s = sd.recuperarSetor(setor);
        return s;
    }
    
    public int recuperarQtde(String data, int setor){
        int qtde = sd.recuperarQtde(data, setor);
        return qtde;
    }
    
    public boolean atender(Setor setor){
        boolean teste = sd.atender(setor);
        return teste;
    }
    
    public boolean atenderSomar(Setor setor){
        boolean teste = sd.atenderSomar(setor);
        return teste;
    }
    
    public boolean verificaNome(String nome){
        boolean teste = sd.verificarIgual(nome);
        return teste;
    }
    
    public boolean excluir(Setor setor){
        boolean teste = sd.excluir(setor);
        return teste;
    }
}
