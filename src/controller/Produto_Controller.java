/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import beans.Produto;
import model.DAO.Produto_DAO;

/**
 *
 * @author administrador
 */
public class Produto_Controller {
       Produto_DAO pd = new Produto_DAO();
       Produto produto = null;
       public Produto pesquisarProduto(int est, int prod, String lote){
           produto = pd.pesquisaProduto(est, prod, lote);
           return produto;
       }
       
       public boolean alterar (int est, int prod, String lote){
           boolean teste = pd.alterar(est, prod, lote);
           return teste;
       }
       
       public void desativaTrigger(){
           pd.desativarTrigger();
       }
       
       public void ativaTrigger(){
           pd.ativarTrigger();
       }
}
