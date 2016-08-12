/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import beans.Ordem_Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conexao.ConnectionFactory;

/**
 *
 * @author carlos.bruno
 */
public class Ordem_Servico_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
   
    
    public Ordem_Servico pesquisa(String numero){
        
        Ordem_Servico os =  null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = "SELECT " +
                        "OS.DS_SERVICO, " +
                        "OS.NM_USUARIO, " +
                        "OS.TP_SITUACAO " +
                        "FROM DBAMV.SOLICITACAO_OS OS " +
                        "WHERE OS.CD_OS = ?";
                stmt = conn.prepareStatement(sql); 
                stmt.setString(1, numero);
              
            rs = stmt.executeQuery();
        
            if (rs.next()) {
            //    System.out.println("encontrou aqui");
                os = new Ordem_Servico();
                os.setNmResponsavel(rs.getString("NM_USUARIO"));
                os.setDescricao(rs.getString("DS_SERVICO"));
                os.setSituacao(rs.getString("TP_SITUACAO"));
                

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return os;
    }
    
    public boolean alterar (String numero){
        boolean teste =  false;
        conn = ConnectionFactory.getConnection();
        sql = "UPDATE DBAMV.SOLICITACAO_OS " +
                "SET TP_SITUACAO = 'A' " +
                "WHERE CD_OS = ?";
        try { 
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, numero);
            stmt.execute();
            teste = true;
        } catch (SQLException ex) {
            Logger.getLogger(Ordem_Servico_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        

        return teste;
    }
}
