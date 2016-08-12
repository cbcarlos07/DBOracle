/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;



import beans.Usuario;
import controller.Usuario_Controller;

import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.TelaUsuarios;





/**
 *
 * @author Brito
 */
public class FuncoesUsuarios {
    
    static Usuario  usuario;
    private static List list = null;
    private static Iterator iterator = null;
    static Usuario_Controller controllerUsuario = new Usuario_Controller();
    
    public static void preencherTabela(){
      try{  
        DefaultTableModel linha = (DefaultTableModel)TelaUsuarios.tabela.getModel();
        linha.setNumRows(0);
         iterator = list.iterator();

            while (iterator.hasNext()){

                  usuario = (Usuario) iterator.next();
                  
                  String codigo = String.valueOf(usuario.getCodigo());
                  String nome = usuario.getNome();
                  
                  linha.addRow(new String []{
                          codigo,
                          nome,
                         
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
    public static void pesquisar_usuario(String name){

        limpaJTable(TelaUsuarios.tabela, true);
            
         list = (List) controllerUsuario.lista(name);
         preencherTabela();
    }
    
    
    
}
