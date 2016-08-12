/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;


import beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.conexao.ConnectionFactory;

/**
 *
 * @author administrador
 */
public class Usuario_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    
    public List<Usuario> listar(String nome){
        Usuario usuario;
        List listar = new ArrayList();
        conn = ConnectionFactory.getConnection();
         try {
            if(nome.equals("")){
                sql = " select * from dbasgu.usuarios  ";
                stmt = conn.prepareStatement(sql);
            }
            else{
                sql = " select * from dbasgu.usuarios "+
	                      " where nm_usuario LIKE ?";
                stmt = conn.prepareStatement(sql); 
                stmt.setString(1, "%" + nome + "%");
            }
            
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getString("CD_USUARIO"));
                usuario.setNome(rs.getString("NM_USUARIO"));
                
                listar.add(usuario);

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listar;
    }
    
    public void desativarTrigger(){
        
        conn = ConnectionFactory.getConnection();
         try {
             
            sql = "ALTER TRIGGER TESTE_JAVA DISABLE";
            stmt = conn.prepareStatement(sql);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Trigger desativada com sucesso!");
            conn.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }
    
    public void ativarTrigger(){
        
        conn = ConnectionFactory.getConnection();
         try {
             
            sql = "ALTER TRIGGER TESTE_JAVA ENABLE";
            stmt = conn.prepareStatement(sql);
            stmt.execute();
             JOptionPane.showMessageDialog(null, "Trigger ativada com sucesso!");
                   
            conn.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
       
    }
    
}
