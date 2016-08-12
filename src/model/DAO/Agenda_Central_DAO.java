/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import beans.Agenda_Central;
import beans.Item_Agendamento;
import beans.Servico_Disc;
import beans.Tipo_Marc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conexao.ConnectionFactory;

/**
 *
 * @author administrador
 */
public class Agenda_Central_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    
    public Agenda_Central pesquisa(int numero){
        
        Agenda_Central agenda = null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = "SELECT "+
                      "  AC.CD_AGENDA_CENTRAL "+
                      " ,SD.CD_SER_DIS"+
                      " ,SD.DS_SER_DIS "+
                      " ,TM.CD_TIP_MAR "  +
                      " ,TM.DS_TIP_MAR "+
                      " ,AC.QT_ATENDIMENTO "+
                      " ,AC.QT_ATENDIMENTO_ENCAIXE" + 
                    " FROM "+
                    "  DBAMV.AGENDA_CENTRAL_SER_TIPO AC "+
                    "   ,DBAMV.TIP_MAR TM "+
                    "   ,DBAMV.SER_DIS SD "+
                 "  WHERE "+
                    "   AC.CD_AGENDA_CENTRAL = ? "+
                    "   AND SD.CD_SER_DIS  = AC.CD_SER_DIS "+
                    "   AND AC.CD_TIP_MAR = TM.CD_TIP_MAR    ";
                
                stmt = conn.prepareStatement(sql); 
                stmt.setInt(1, numero);
                
            
            
            rs = stmt.executeQuery();
        
            if (rs.next()) {
               agenda = new Agenda_Central();
               agenda.setCodigo(rs.getInt("CD_AGENDA_CENTRAL"));
               agenda.setQtde(rs.getInt("QT_ATENDIMENTO"));
               agenda.setServico(new Servico_Disc());
               agenda.getServico().setCodigo(rs.getInt("CD_SER_DIS"));
               agenda.getServico().setDescricao(rs.getString("DS_SER_DIS"));
               agenda.setTipo(new Tipo_Marc());
               agenda.getTipo().setCodigo(rs.getInt("CD_TIP_MAR"));
               agenda.getTipo().setDescricao(rs.getString("DS_TIP_MAR"));
               agenda.setQtde_encaixe(rs.getInt("QT_ATENDIMENTO_ENCAIXE"));
               

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return agenda;
    }
    public List<Tipo_Marc> tipo_Marc(int numero){
        List lista = new ArrayList();
        Tipo_Marc agenda = null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = "SELECT "+
                      " DISTINCT(TM.CD_TIP_MAR) "  +  
                      " ,AC.CD_AGENDA_CENTRAL "+                                                                 
                      " ,TM.DS_TIP_MAR "+
                      
                    " FROM "+
                    "  DBAMV.AGENDA_CENTRAL_SER_TIPO AC "+
                    "   ,DBAMV.TIP_MAR TM "+
                    "   ,DBAMV.SER_DIS SD "+
                 "  WHERE "+
                    "   AC.CD_AGENDA_CENTRAL = ? "+                    
                    "   AND AC.CD_TIP_MAR = TM.CD_TIP_MAR    ";
                
                stmt = conn.prepareStatement(sql); 
                stmt.setInt(1, numero);
                
            
            
            rs = stmt.executeQuery();
        
            while (rs.next()) {
               agenda = new Tipo_Marc();
               agenda.setCodigo(rs.getInt("CD_TIP_MAR"));
               agenda.setDescricao(rs.getString("DS_TIP_MAR"));
               lista.add(agenda);
               System.out.println("Tipo de marc: "+rs.getInt("CD_TIP_MAR"));

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return lista    ;
    }
    
    public List<Servico_Disc> lista_servico(int numero){
        List lista = new ArrayList();
        Servico_Disc agenda = null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = "SELECT "+
                      "  DISTINCT(SD.CD_SER_DIS)"+  
                      " ,AC.CD_AGENDA_CENTRAL "+
                      " ,SD.DS_SER_DIS "+
                      
                    " FROM "+
                    "  DBAMV.AGENDA_CENTRAL_SER_TIPO AC "+
                    "   ,DBAMV.TIP_MAR TM "+
                    "   ,DBAMV.SER_DIS SD "+
                 "  WHERE "+
                    "   AC.CD_AGENDA_CENTRAL = ? "+
                    "   AND SD.CD_SER_DIS  = AC.CD_SER_DIS ";
                
                stmt = conn.prepareStatement(sql); 
                stmt.setInt(1, numero);
                
            
            
            rs = stmt.executeQuery();
        
            while (rs.next()) {
               agenda = new Servico_Disc(); 
               agenda.setCodigo(rs.getInt("CD_SER_DIS"));
               agenda.setDescricao(rs.getString("DS_SER_DIS"));
               lista.add(agenda);

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return lista    ;
    }
    
  
    
    
    public boolean alterar(int qtde, int encaixe,  int codigo, int servico, int tipo){
        boolean teste =  false;
        conn = ConnectionFactory.getConnection();
        System.out.println("Qtde: "+qtde+"\n Codigo: "+codigo+" \n Servico: "+servico+"\n Tipo: "+tipo);
        try {
            sql = "UPDATE AGENDA_CENTRAL_SER_TIPO A SET A.QT_ATENDIMENTO = ?, "
                    + "QT_ATENDIMENTO_ENCAIXE = ? WHERE "
                    + "A.CD_AGENDA_CENTRAL = ? "
                    + "AND A.CD_SER_DIS = ? "
                    + "AND A.CD_TIP_MAR = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, qtde);
            stmt.setInt(2, encaixe);
            stmt.setInt(3, codigo);
            stmt.setInt(4, servico);
            stmt.setInt(5, tipo);
            stmt.execute();
            teste = true;
            conn.close();
            
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
       return teste;
    }
    
   
    
   
    
   public int qtdeAgenda(int codigo, int servico, int marc){
       int qtde = 0;
        conn = ConnectionFactory.getConnection();
        try {
          sql = "SELECT A.QT_ATENDIMENTO FROM DBAMV.AGENDA_CENTRAL_SER_TIPO A "
                  + "WHERE "
                  + "A.CD_AGENDA_CENTRAL = ? "
                  + "AND A.CD_SER_DIS = ? "
                  + "AND A.CD_TIP_MAR = ? ";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setInt(2, servico);
            stmt.setInt(3, marc);
            rs = stmt.executeQuery();
            if(rs.next()){
                qtde = rs.getInt("QT_ATENDIMENTO");
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       
       return qtde;
       
   }
   
   
   
   public int qtdeEncaixe(int codigo, int servico, int marc){
       int qtde = 0;
        conn = ConnectionFactory.getConnection();
        try {
          sql = "SELECT A.QT_ATENDIMENTO_ENCAIXE FROM DBAMV.AGENDA_CENTRAL_SER_TIPO A "
                  + "WHERE "
                  + "A.CD_AGENDA_CENTRAL = ? "
                  + "AND A.CD_SER_DIS = ? "
                  + "AND A.CD_TIP_MAR = ? ";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setInt(2, servico);
            stmt.setInt(3, marc);
            rs = stmt.executeQuery();
            if(rs.next()){
                qtde = rs.getInt("QT_ATENDIMENTO_ENCAIXE");
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       
       return qtde;
       
   }
        public List<Item_Agendamento> lista_item(int numero){
        List lista = new ArrayList();
        Item_Agendamento agenda = null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql =  "     SELECT I.CD_AGENDA_CENTRAL " +
                    "      ,I.CD_ITEM_AGENDAMENTO " +
                    "      ,AA.DS_ITEM_AGENDAMENTO " +
                    "      ,I.QT_MAX_ITEM_AGENDAMENTO " +
                    "       FROM " +
                    "       DBAMV.AGENDA_CENTRAL_ITEM_AGENDA I " +
                    "       ,DBAMV.ITEM_AGENDAMENTO AA " +
                    "       WHERE AA.CD_ITEM_AGENDAMENTO = I.CD_ITEM_AGENDAMENTO " +
                    "       AND I.CD_AGENDA_CENTRAL  = ? " +
                    "       ORDER BY 2 ";
                
                stmt = conn.prepareStatement(sql); 
                stmt.setInt(1, numero);
                
            
            
            rs = stmt.executeQuery();
        
            while (rs.next()) {
               agenda = new Item_Agendamento(); 
               agenda.setCdItem(rs.getInt("CD_ITEM_AGENDAMENTO"));
               agenda.setDs_Item(rs.getString("DS_ITEM_AGENDAMENTO"));
               
               lista.add(agenda);

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return lista    ;
    }
    
      
      public Item_Agendamento rec_item(long numero){
       System.out.println("Agenda_Central_DAO.Item_Agendamento: "+numero);
       
        Item_Agendamento item = null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql =  "      SELECT " +
                    "             IA.CD_ITEM_AGENDAMENTO " +
                    "             ,IA.DS_ITEM_AGENDAMENTO " +
                    "             ,IA.SN_ATIVO " +
                    "             ,TO_CHAR(IA.HR_REALIZACAO,'DD/MM/YYYY HH24:MI:SS') DATA" +
                    "            FROM DBAMV.ITEM_AGENDAMENTO IA  " +
                    "         WHERE IA.CD_ITEM_AGENDAMENTO = ?";
                
                stmt = conn.prepareStatement(sql); 
                stmt.setLong(1, numero);
                
            
            
            rs = stmt.executeQuery();
        
            if (rs.next()) {
                System.out.println("Encontrou");
               item = new Item_Agendamento(); 
               item.setCdItem(rs.getInt("CD_ITEM_AGENDAMENTO"));
               item.setDs_Item(rs.getString("DS_ITEM_AGENDAMENTO"));
               item.setHrRealizacao(rs.getString("DATA"));
                System.out.println("SN_ATIVO: "+rs.getString("SN_ATIVO"));
               item.setSnAtivo(rs.getString("SN_ATIVO"));

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return item    ;
    }
      
       public int qtdeItem(long agenda, long item){
       int qtde = 0;
        conn = ConnectionFactory.getConnection();
        try {
          sql = "SELECT AIC.QT_MAX_ITEM_AGENDAMENTO FROM  DBAMV.AGENDA_CENTRAL_ITEM_AGENDA AIC " +
                "         WHERE AIC.CD_AGENDA_CENTRAL = ?" +
                "         AND AIC.CD_ITEM_AGENDAMENTO = ? ";
            
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, agenda);
            stmt.setLong(2, item);
            rs = stmt.executeQuery();
            if(rs.next()){
                qtde = rs.getInt(1);
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       
       return qtde;
       
   }
    public boolean alterarMax (int qtde,  long agenda, long item){
        boolean teste =  false;
        conn = ConnectionFactory.getConnection();
        //System.out.println("Qtde: "+qtde+"\n Codigo: "+codigo+" \n Servico: "+servico+"\n Tipo: "+tipo);
        try {
            sql = "         UPDATE DBAMV.AGENDA_CENTRAL_ITEM_AGENDA AI " +
                    "         SET AI.QT_MAX_ITEM_AGENDAMENTO = ? " +
                    "         WHERE " +
                    "         AI.CD_AGENDA_CENTRAL = ? " +
                    "         AND AI.CD_ITEM_AGENDAMENTO = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, qtde);
            stmt.setLong(2, agenda);
            stmt.setLong(3, item);
            stmt.execute();
            teste = true;
            conn.close();
            
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Agenda_Central_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
       return teste;
    }
    
    
    //SELECT A.QT_ATENDIMENTO FROM DBAMV.AGENDA_CENTRAL_SER_TIPO A WHERE A.CD_AGENDA_CENTRAL = 1820 AND A.CD_TIP_MAR = 1    
}
