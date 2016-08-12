/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Ordem_Servico;
import model.DAO.Ordem_Servico_DAO;

/**
 *
 * @author carlos.bruno
 */
public class Ordem_Servico_Controller {
    Ordem_Servico_DAO osd = new Ordem_Servico_DAO();
    Ordem_Servico os = new Ordem_Servico();
    public Ordem_Servico pesquisa(String numero){
        os = osd.pesquisa(numero);
        return os;
    }
    
    public boolean alterar (String numero){
        boolean teste = osd.alterar(numero);
        return teste;
    }
    
}
