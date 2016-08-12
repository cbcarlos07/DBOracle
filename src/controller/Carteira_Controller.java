/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Carteira;
import model.DAO.Carteira_DAO;

/**
 *
 * @author administrador
 */
public class Carteira_Controller {
    Carteira_DAO cd = new Carteira_DAO();
    Carteira c = new Carteira();
    public Carteira pesquisarCarteira (String numero){
        c = cd.pesquisaCarteira(numero);
        return c;
    }
    
    public boolean alterar (String carteira){
        boolean teste = cd.alterar(carteira);
        return teste;
    }
}
