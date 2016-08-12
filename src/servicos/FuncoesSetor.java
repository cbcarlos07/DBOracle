/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;



import beans.Setor;
import controller.Setor_Controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.TelaLista_Setor;
import view.TelaRelatorioAtendimento;






/**
 *
 * @author Brito
 */
public class FuncoesSetor {
    
    static Setor  setor;
    private static List list = null;
    private static Iterator iterator = null;
    static Setor_Controller controllerSetor = new Setor_Controller();
    private static SimpleDateFormat formata_br = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public static void preencherTabela(){
      try{  
        DefaultTableModel linha = (DefaultTableModel)TelaLista_Setor.tabela_setor.getModel();
        linha.setNumRows(0);
         iterator = list.iterator();

            while (iterator.hasNext()){

                  setor = (Setor) iterator.next();
                  
                  String codigo = String.valueOf(setor.getCodigo());
                  String nome = setor.getNome();
                  
                  linha.addRow(new String []{
                          codigo,
                          nome,
                          });
            } // fim while

        }catch (Exception e){
            e.printStackTrace();
        }
      
        
    }
    public static void preencherTabelaData(){
      try{  
        DefaultTableModel linha = (DefaultTableModel)TelaRelatorioAtendimento.tabela_relatorio.getModel();
        linha.setNumRows(0);
         iterator = list.iterator();

            while (iterator.hasNext()){

                  setor = (Setor) iterator.next();
                  
                  String codigo = String.valueOf(setor.getCodigo());
                  String nome = setor.getNome();
                  
                  String qtde = String.valueOf(setor.getQtde());
                  
                  linha.addRow(new String []{
                          codigo,
                          nome,
                          formata_br.format(setor.getDataAtend().getTime()),
                          qtde,
                          });
            } // fim while

        }catch (Exception e){
            e.printStackTrace();
        }
      
        
    }
    
    public static void limpaJTable(JTable tbl, boolean todos){
        
        DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tbl.getModel();
            
        int linhas = tbl.getRowCount();
            
            if(linhas > 0){
                for(int i = linhas-1; i >= 0; --i){
                    dtm.removeRow(i);
                }
            }
        
    }
    
    public static void removerLinha(JTable tbl, boolean todos){
        
        
        
        int[] linha = tbl.getSelectedRows();
        javax.swing.table.DefaultTableModel remover = (javax.swing.table.DefaultTableModel)tbl.getModel();
        
        for(int i = (linha.length - 1); i>=0; --i)
        {
            remover.removeRow(linha[i]);            
        }        
    }
    public static void pesquisar_setor(String name){

        limpaJTable(TelaLista_Setor.tabela_setor, true);
            
         list = (List) controllerSetor.lista(name);
         preencherTabela();
    }
    
    public static void pesquisarPorData(Date data1, Date data2){

        limpaJTable(TelaRelatorioAtendimento.tabela_relatorio, true);
            
         list = (List) controllerSetor.listaPorData(data1, data2);
         preencherTabelaData();
    }
    
    
}
