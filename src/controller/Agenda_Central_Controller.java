/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Agenda_Central;
import beans.Item_Agendamento;
import java.util.List;
import model.DAO.Agenda_Central_DAO;

/**
 *
 * @author administrador
 */
public class Agenda_Central_Controller {
    Agenda_Central_DAO ad = new Agenda_Central_DAO();
    Agenda_Central ac = new Agenda_Central();
    Item_Agendamento ia = new Item_Agendamento();
    List lista;
    public Agenda_Central busca(int codigo){
        ac = ad.pesquisa(codigo);
        return ac;
    }
    
    public boolean alterar(int qtde, int encaixe, int codigo, int servico, int tipo){
        boolean teste = ad.alterar(qtde, encaixe, codigo, servico, tipo);
        return teste;
    }
    public int qtdeAgenda(int codigo, int servico, int marc){
        int qtde = ad.qtdeAgenda(codigo, servico, marc);
        return qtde;
    }
    
     public int qtdeEncaixe(int codigo, int servico, int marc){
        int qtde = ad.qtdeEncaixe(codigo, servico, marc);
        return qtde;
    }
     
     public Item_Agendamento rec_item(long numero){
         ia = ad.rec_item(numero);
         return ia;
     }
     
      public List<Item_Agendamento> lista_item(int numero){
         lista = ad.lista_item(numero);
         return lista;
      }
      
      public int qtdeItem(long agenda, long item){
          int  a = ad.qtdeItem(agenda, item);
          return a;
      }
      
      public boolean alterarMax (int qtde,  long agenda, long item){
          boolean teste = ad.alterarMax(qtde, agenda, item);
          return teste;
      }
}
