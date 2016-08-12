/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import beans.Convenio;
import beans.Guia;
import beans.Paciente;
import beans.Tipo_Acompanhamento;
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
public class Guia_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    
    public Guia pesquisa(String numero, String tipo){
        
        Guia guia = null;
        conn = ConnectionFactory.getConnection();
        try {
           
                sql = "SELECT "+
                      "     G.CD_GUIA "+
                      "    ,G.NR_GUIA "+ 
                      "    ,PP.NM_PACIENTE "+
                      "    ,CC.NM_CONVENIO "+
                      "    ,T.DS_TIP_ACOM "+
                      "    ,G.NR_DIAS_SOLICITADOS "+
                      "     ,G.NR_DIAS_AUTORIZADOS "+

                       " FROM "+
                         "    DBAMV.ATENDIME ATE "+
                         "    ,DBAMV.PACIENTE PP "+
                         "    ,DBAMV.TIP_ACOM T "+
                         "    ,DBAMV.CONVENIO CC "+
                         "    ,DBAMV.GUIA G "+
                     "  WHERE "+

                         "    PP.CD_PACIENTE     = G.CD_PACIENTE "+
                         " AND T.CD_TIP_ACOM      = G.CD_TIP_ACOM "+
                         " AND ATE.CD_ATENDIMENTO = G.CD_ATENDIMENTO       "+
                         " AND G.CD_CONVENIO      = CC.CD_CONVENIO "+
                         " AND G.CD_ATENDIMENTO   = ? " +
                         " AND G.TP_GUIA = 'I'";
                stmt = conn.prepareStatement(sql); 
                stmt.setString(1, numero);
              
            rs = stmt.executeQuery();
        
            if (rs.next()) {
            //    System.out.println("encontrou aqui");
                guia = new Guia();
                guia.setCodigo(rs.getInt("CD_GUIA"));
                guia.setNumero(rs.getInt("NR_GUIA"));
                guia.setPaciente(new Paciente());
                guia.getPaciente().setNome(rs.getString("NM_PACIENTE"));
                guia.setConvenio(new Convenio());
                guia.getConvenio().setNome(rs.getString("NM_CONVENIO"));
                guia.setTipo_Acompanhamento(new Tipo_Acompanhamento());
                guia.getTipo_Acompanhamento().setTipo_Acompanhamento(rs.getString("DS_TIP_ACOM"));
                guia.setDias_Solicitados(rs.getInt("NR_DIAS_SOLICITADOS"));
                guia.setDias_Autorizados(rs.getInt("NR_DIAS_AUTORIZADOS"));

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return guia;
    }
    
    
    
    public boolean alterar (int solicitado, int autorizado, int atendimento, String tipo, int guia){
        boolean teste = false;
        conn = ConnectionFactory.getConnection();
            try {
                sql = "UPDATE GUIA G SET G.NR_DIAS_SOLICITADOS = ?, G.NR_DIAS_AUTORIZADOS = ? WHERE G.CD_ATENDIMENTO = ?" +                        
                        " AND G.TP_GUIA = 'I' "+
                        " AND G.CD_GUIA = ?";
                stmt = conn.prepareStatement(sql); 
                stmt.setInt(1, solicitado);
                stmt.setInt(2, autorizado);
                stmt.setInt(3, atendimento);                
                stmt.setInt(4, guia);
                stmt.execute();
                teste = true;

           } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return teste;
    }
}
