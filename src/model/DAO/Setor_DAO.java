/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import beans.Setor;
import java.sql.Connection;
import java.sql.Date;

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
 * @author linux
 */
public class Setor_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    
    public boolean inserir (Setor setor){
       boolean teste = false;
       conn = ConnectionFactory.getConnection();        
       sql = "INSERT INTO SETOR_HAM VALUES (NULL, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, setor.getNome());
           // stmt.setInt(2, setor.getQtde());
            stmt.execute();
            teste = true;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return teste;          
    }
   
    public boolean atender (Setor setor){
       boolean teste = false;
       conn = ConnectionFactory.getConnection();        
       sql = "INSERT INTO DBAMV.CT_ATEND VALUES (?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new Date(setor.getDataAtend().getTime()));
            stmt.setInt(2, setor.getCodigo());
            stmt.setInt(3, setor.getQtde());
            stmt.execute();
            teste = true;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return teste;          
    }
    
    public boolean atenderSomar (Setor setor){
       boolean teste = false;
       conn = ConnectionFactory.getConnection();        
       sql = "UPDATE DBAMV.CT_ATEND SET QT_ATEND = ? WHERE CD_SETOR = ? AND DT_ATENDIMENTO = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, setor.getQtde());
            stmt.setInt(2, setor.getCodigo());
            stmt.setDate(3, new Date(setor.getDataAtend().getTime()));
            
            stmt.execute();
            teste = true;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return teste;          
    }
    
    public boolean verificarIgual(String nome){
        Setor setor;
        boolean teste = false;
        conn = ConnectionFactory.getConnection();
         try {
           
                sql = " select * from setor_ham WHERE NM_SETOR = ? ";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
           
          
            
            rs = stmt.executeQuery();
        
            if (rs.next()) {
                setor = new Setor();
                setor.setCodigo(rs.getInt("CD_SETOR"));
                setor.setNome(rs.getString("NM_SETOR"));
//                setor.setQtde(rs.getInt("QT_ATEND"));
                teste = true;
               

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return teste;
    }
    
    
    public List<Setor> listar(String nome){
        Setor setor;
        List listar = new ArrayList();
        conn = ConnectionFactory.getConnection();
         try {
            if(nome.equals("")){
                sql = " select * from dbamv.setor_ham ORDER BY 2 ";
                stmt = conn.prepareStatement(sql);
            }
            else{
                sql = " select * from dbamv.setor_ham "+
	                      " where nm_setor LIKE ? ORDER BY 2";
                stmt = conn.prepareStatement(sql); 
                stmt.setString(1, "%" + nome + "%");
            }
            
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                setor = new Setor();
                setor.setCodigo(rs.getInt("CD_SETOR"));
                setor.setNome(rs.getString("NM_SETOR"));
//                setor.setQtde(rs.getInt("QT_ATEND"));
                
                listar.add(setor);

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listar;
    }
   
    
    public boolean alterar (Setor setor){
       boolean teste = false;
       conn = ConnectionFactory.getConnection();        
       sql = "UPDATE SETOR_HAM SET NM_SETOR = ? WHERE CD_SETOR = ?";
        try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, setor.getNome());
            stmt.setInt(2, setor.getCodigo());
            stmt.execute();
            teste = true;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return teste;          
    }
    
     public boolean excluir (Setor setor){
       boolean teste = false;
       conn = ConnectionFactory.getConnection();        
       sql = "DELETE FROM SETOR_HAM WHERE CD_SETOR = ?";
        try {
            stmt = conn.prepareStatement(sql);
            
            
            stmt.setInt(1, setor.getCodigo());
            stmt.execute();
            teste = true;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return teste;          
    }
    public List<Setor> listarPorData(java.util.Date data1, java.util.Date data2){
        Setor setor;
    //    System.out.println("data1: "+data1+" data2: "+data2);
        List listar = new ArrayList();
        conn = ConnectionFactory.getConnection();
        
         try {
            
                sql = " SELECT " +
                        "  C.CD_SETOR" +
                        " ,S.NM_SETOR" +
                        " ,C.DT_ATENDIMENTO" +
                        " ,C.QT_ATEND " +
                        "FROM " +
                        "    DBAMV.CT_ATEND C" +
                        "   ,DBAMV.SETOR_HAM S" +
                        " WHERE " +
                        "    C.DT_ATENDIMENTO BETWEEN ? AND ? "+
                        "    AND S.CD_SETOR = C.CD_SETOR "
                        + "ORDER BY C.DT_ATENDIMENTO";
                System.out.println(sql);
                stmt = conn.prepareStatement(sql); 
                stmt.setDate(1, new Date(data1.getTime()));
                stmt.setDate(2, new Date(data2.getTime()));
                
          
            
            
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                setor = new Setor();
                setor.setCodigo(rs.getInt("CD_SETOR"));
                setor.setNome(rs.getString("NM_SETOR"));
                setor.setQtde(rs.getInt("QT_ATEND"));
                setor.setDataAtend(rs.getDate("DT_ATENDIMENTO"));
                
                listar.add(setor);

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listar;
    }
    
    public Setor recuperarSetor(int codigoSetor){
        Setor setor = null;
        
        conn = ConnectionFactory.getConnection();
         try {
            
                sql = " SELECT * FROM SETOR_HAM WHERE CD_SETOR = ? ";
                stmt = conn.prepareStatement(sql); 
                stmt.setInt(1, codigoSetor );
             
            
            
            rs = stmt.executeQuery();
        
            if (rs.next()) {
                setor = new Setor();
                setor.setCodigo(rs.getInt("CD_SETOR"));
                setor.setNome(rs.getString("NM_SETOR"));
              //  setor.setQtde(rs.getInt("QT_ATEND"));
                
                

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return setor;
    }
    public int recuperarQtde(String data, int cd_setor){
        int qtde = 0;
        conn = ConnectionFactory.getConnection();
         try {
            
                sql = " SELECT C.QT_ATEND FROM DBAMV.CT_ATEND C WHERE C.DT_ATENDIMENTO = ?"
                        + "AND C.CD_SETOR = ? ";
                stmt = conn.prepareStatement(sql); 
                stmt.setString(1, data );
                stmt.setInt(2, cd_setor );
            
            
            rs = stmt.executeQuery();
        
            if (rs.next()) {
                qtde = rs.getInt(1);
                
                

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return qtde;
    }
    
   
}
