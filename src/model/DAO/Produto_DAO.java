/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;


import beans.Estoque;
import beans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conexao.ConnectionFactory;

/**
 *
 * @author administrador
 */
public class Produto_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    
    public Produto pesquisaProduto(int est, int prod, String lote){
        
        Produto produto = null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = " SELECT "
                        + "  p.cd_produto "
                        + " ,p.ds_produto "
                        + " ,e.cd_estoque "
                        + " ,e.ds_estoque "
                        + " ,a.qt_estoque_atual "
                        + " ,a.qt_orcamentario "
                        + " ,a.qt_kit "
                        +" FROM "  
                        +"     dbamv.lot_pro a "
                        +"    ,dbamv.produto p "
                        +"    ,dbamv.estoque e "
                      +" WHERE "
                      +"      a.cd_estoque = ?     "
                      +"AND   a.cd_Produto = ?     "  
                      +"AND   a.cd_lote = ?        "
                      +"AND   p.cd_produto = a.cd_produto " 
                      +"AND   a.cd_estoque = e.cd_estoque ";
                stmt = conn.prepareStatement(sql); 
                stmt.setInt(1, est);
                stmt.setInt(2, prod);
                stmt.setString(3, lote);
            
            
            rs = stmt.executeQuery();
        
            if (rs.next()) {
                produto = new Produto();
                produto.setCodigo(rs.getInt("CD_PRODUTO"));
                produto.setDescricao(rs.getString("DS_PRODUTO"));
                Estoque esto = new Estoque();
                esto.setCodigo(rs.getInt("CD_ESTOQUE"));
                esto.setDescricao(rs.getString("DS_ESTOQUE"));
                produto.setEstoque(esto);
                produto.setQt_estoque_atual(rs.getInt("QT_ESTOQUE_ATUAL"));
                produto.setOrcamentario(rs.getInt("QT_ORCAMENTARIO"));
                produto.setKit(rs.getInt("QT_KIT"));
                
                

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return produto;
    }
    
    public boolean alterar(int est, int prod, String lote){
        
        boolean teste = false;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = " UPDATE dbamv.lot_pro l SET l.qt_orcamentario = 0, l.qt_kit  = 0 " +
                        "WHERE l.cd_estoque = ? AND l.cd_produto = ? AND l.cd_lote = ?";
                stmt = conn.prepareStatement(sql); 
                stmt.setInt(1, est);
                stmt.setInt(2, prod);
                stmt.setString(3, lote);
            
            
            stmt.execute();
            teste = true;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return teste;
    }
    
    public void desativarTrigger(){
        
        conn = ConnectionFactory.getConnection();
         try {
             
            sql = "ALTER TRIGGER TRG_LOT_PRO DISABLE";
            stmt = conn.prepareStatement(sql);
            stmt.execute();
            //JOptionPane.showMessageDialog(null, "Trigger desativada com sucesso!");
             System.out.println("Trigger TRG_LOT_PRO desativada com sucesso!");
            conn.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }
    
    public void ativarTrigger(){
        
        conn = ConnectionFactory.getConnection();
         try {
             
            sql = "ALTER TRIGGER TRG_LOT_PRO ENABLE";
            stmt = conn.prepareStatement(sql);
            stmt.execute();
           //  JOptionPane.showMessageDialog(null, "Trigger ativada com sucesso!");
               System.out.println("Trigger TRG_LOT_PRO ativada com sucesso!");    
            conn.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
       
    }
}
