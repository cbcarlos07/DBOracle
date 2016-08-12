/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*package servicos;


import controller.ControllerBairro;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.beans.Bairro;
import view.TelaGerenciarBairros;



/**
 *
 * @author Brito
 */
/*public class FuncoesBairro {
    
    static Bairro  bairro;
    private static List list = null;
    private static Iterator iterator = null;
    static ControllerBairro controllerBairro = new ControllerBairro();
    
    public static void preencherTabela(){
      try{  
        DefaultTableModel linha = (DefaultTableModel)TelaGerenciarBairros.JTB_Bairros.getModel();
        linha.setNumRows(0);
         iterator = list.iterator();

            while (iterator.hasNext()){

                  bairro = (Bairro) iterator.next();
                  
                  String codigo = String.valueOf(bairro.getCodigo());
                  String nomeBairro = bairro.getDescricao();
                  
                  linha.addRow(new String []{
                          codigo,
                          nomeBairro,
                         
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
    public static void pesquisar_bairro_nome(String name){

        limpaJTable(TelaGerenciarBairros.JTB_Bairros, true);
            
         list = (List) controllerBairro.pesquisaarBairro(name);
         preencherTabela();
    }
    
    public static void listaTodos(){
       
            list = (List) controllerBairro.listarTodos();
            preencherTabela();
    }
    
}
*/