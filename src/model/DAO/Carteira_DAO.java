/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;


import beans.Carteira;
import beans.Convenio;
import beans.Paciente;
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
public class Carteira_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    
    public Carteira pesquisaCarteira(String numero){
        
        Carteira carteira = null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = " SELECT  "+
                      "          c.nm_titular "+
                      "         ,p.nm_paciente "+
                      "         ,d.nm_convenio "+
                      "         ,c.dt_validade "+
                        
                       "     FROM  carteira c "+
                       "    ,paciente p "+
                       "    ,convenio d "+
                       "     WHERE "+

                       "           c.nr_carteira = ? "+                        
                        "   AND    c.cd_paciente = p.cd_paciente "+
                        "   AND    D.CD_CONVENIO = C.CD_CONVENIO";
                
                stmt = conn.prepareStatement(sql); 
                stmt.setString(1, numero);
                
            
            
            rs = stmt.executeQuery();
        
            if (rs.next()) {
                System.out.println("encontrou aqui");
                carteira = new Carteira();
                carteira.setTitular(rs.getString("nm_titular"));
                System.out.println("Titular: "+carteira.getTitular());
                Paciente p = new Paciente();
                p.setNome(rs.getString("nm_paciente"));
                Convenio c = new Convenio();
                c.setNome(rs.getString("nm_convenio"));
                carteira.setPaciente(p);
                carteira.setConvenio(c);
                carteira.setData(rs.getDate("dt_validade"));
                
                

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return carteira;
    }
    public boolean alterar(String numero){
        
        boolean teste = false;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = "UPDATE carteira c SET c.sn_carteira_ativo = ? "+
                      "WHERE c.nr_carteira = ? ";
                     
                stmt = conn.prepareStatement(sql); 
                stmt.setString(1, "S");
                stmt.setString(2, numero);
                stmt.execute();
            teste = true;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return teste;
    }
}
