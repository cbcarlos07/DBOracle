    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Guia;
import model.DAO.Guia_DAO;

/**
 *
 * @author administrador
 */
public class Guia_Controller {
    Guia_DAO gd = new Guia_DAO();
    Guia g = new Guia();
    public Guia buscar(String numero, String tipo){
        g = gd.pesquisa(numero, tipo);
        return g;
    }
    
    public boolean alterar(int solicitado, int autorizado, int atendimento, String tipo, int guia){
        boolean teste = gd.alterar(solicitado, autorizado, atendimento, tipo, guia);
        return teste;
    }
            
  //  int qtde, int atendimento, String tipo, int guia
}
