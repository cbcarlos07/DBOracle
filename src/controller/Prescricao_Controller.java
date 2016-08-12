/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Item_Prescricao;
import beans.Prescricao;
import java.util.List;
import model.DAO.Prescricao_DAO;

/**
 *
 * @author administrador
 */
public class Prescricao_Controller {
      Prescricao_DAO  pd = new Prescricao_DAO();
      Prescricao p = new Prescricao();
      public Prescricao busca (int codigo){
          p = pd.buscar(codigo);
          return p;
      }
      
      public boolean deletar(int codigo){
          boolean teste = pd.excluir(codigo);
          return teste;
      }
      
       public List<Item_Prescricao> buscarItens(long codigo){
           List list = pd.buscarItens(codigo);
           return list;
       }
       
       public boolean excluir_itens (long codigo){
           boolean teste = pd.excluir_itens(codigo);
           return teste;
       }
       
       public boolean assinar_prescricao(long codigo){
           boolean teste = pd.assinar_prescricao(codigo);
           return teste;
       }
}
