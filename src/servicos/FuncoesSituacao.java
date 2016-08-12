/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;



import beans.SituacaoPaciente;
import controller.Situacao_Controller;

import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import view.TelaSituacaoCirurgia;





/**
 *
 * @author Brito
 */
public class FuncoesSituacao {
    
    static SituacaoPaciente situacao;
    private static List list = null;
    private static Iterator iterator = null;
    static Situacao_Controller situacao_Controller = new Situacao_Controller();
    
    public static void preencherTabela(){
      try{  
        DefaultTableModel linha = (DefaultTableModel)TelaSituacaoCirurgia.tabela.getModel();
        TableColumnModel columnModel = TelaSituacaoCirurgia.tabela.getColumnModel(); // obtém o modelo da minha tabela  
        TableRenderer_Imagem rendererImagem = new TableRenderer_Imagem();  
        columnModel.getColumn(0).setCellRenderer(rendererImagem);
        linha.setNumRows(0);
         iterator = list.iterator();

            while (iterator.hasNext()){

                  situacao = (SituacaoPaciente) iterator.next();
                    ImageIcon foto = null;  
                 // try {  
            //           dados = new byte[bInputStream.available()];  
            //          bInputStream.read(dados, 0, dados.length);  
                      
                  //} catch (IOException ex) {  
                 //     System.out.println(ex.getMessage());  
                  //}  

                  
                  String text = situacao.getSituacao();
                  if(text.equals("TRANSFERIDO PARA APARTAMENTO/ENFERMARIA"))
                  {
                      foto = new ImageIcon("src/image/incluir.png"); // cria a imagem  
                  }
                  else if(text.equals("SALA DE CIRURGIA")){
                      foto = new ImageIcon("src/image/selecionar.png"); // cria a imagem  
                  }
                  else {
                      foto = new ImageIcon("src/image/alterar.png"); // cria a imagem  
                  }
                  linha.addRow(new Object []{
                      foto,    
                      situacao.getAtendimento(),
                      situacao.getPaciente().getNome(),
                      situacao.getPrestador(),
                      situacao.getSituacao(),
                      situacao.getMensagem()
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

        limpaJTable(TelaSituacaoCirurgia.tabela, true);
            
         list = (List) situacao_Controller.lista();
         preencherTabela();
    }
    
    
    
}
