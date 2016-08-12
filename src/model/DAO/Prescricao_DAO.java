/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;


import beans.Item_Prescricao;
import beans.Paciente;
import beans.Prescricao;
import beans.Prestador;
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
import model.conexao.FabricaDeConexao1;

/**
 *
 * @author administrador
 */
public class Prescricao_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    String mensagem; 
    
    public Prescricao buscar(int codigo){
        Prescricao p = null;
        
        try{
            sql = "SELECT "+
                  "  e.cd_pre_med   "  +
                  " ,c.nm_paciente  "+
                  " ,b.nm_prestador   "+
                  " ,e.dt_pre_med     "+
                  " ,e.sn_fechado "+                  
                  " ,d.ds_unid_int  "+
                  " ,NVL(d.ds_unid_int,s.nm_setor) LOCAL_PESCR "+
                   " ,f.ds_especialid  "+
                    " FROM "+
                    "     dbamv.atendime a "+
                    "    ,dbamv.prestador b "+
                    "    ,dbamv.paciente c "+
                    "    ,dbamv.unid_int d "+
                    "    ,dbamv.pre_med e "+
                    "    ,dbamv.especialid f "+
                    "    ,dbamv.esp_med g "+
                    "    ,dbamv.setor s "+
                    " WHERE  "+
                    "        e.cd_atendimento = a.cd_atendimento "+
                    "    AND  a.cd_paciente = c.cd_paciente "+
                    "    AND  e.cd_prestador = b.cd_prestador  "+
                    "    AND  e.cd_unid_int = d.cd_unid_int(+) "+
                    "    AND  e.cd_pre_med = ? "+
                    "    AND  b.cd_prestador = g.cd_prestador "+
                    "    AND  e.cd_setor     = s.cd_setor "+
                    "    AND  g.cd_especialid = f.cd_especialid ";
                  conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql); 
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                p = new Prescricao();
                p.setCodigo(rs.getInt("cd_pre_med"));
                Paciente pa = new Paciente();
                pa.setNome(rs.getString("nm_paciente"));
                p.setPaciente(pa);
                Prestador prest = new Prestador();
                prest.setPrestador(rs.getString("nm_prestador"));
                p.setPrestador(prest);
                p.setData(rs.getDate("dt_pre_med"));
                p.setFechado(rs.getString("sn_fechado"));
                p.setLocal(rs.getString("LOCAL_PESCR"));
                p.setEspecialidade(rs.getString("ds_especialid"));
            }
             conn.close();
          }
        catch (SQLException ex) {
            
           Logger.getLogger(Prescricao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }
    
    
    public List<Item_Prescricao> buscarItens(long codigo){
        
        list = new ArrayList();
        try{
            sql = "SELECT "+
                  "  PRE.CD_PRE_MED     PRESCRICAO"+
                  "  ,IT.CD_ITPRE_MED   ITEM "+
                  "  ,TP.CD_TIP_PRESC   CODIGO_DO_ITEM "+
                  "  ,TP.DS_TIP_PRESC   ITEM_DE_PRESCRICAO "+
                  "  ,PRE.SN_FECHADO    FECHADO"+
                  "  ,PRE.DT_PRE_MED "+
                  "  ,PRE.CD_PRESTADOR "+
                  "  ,PRE.CD_ATENDIMENTO "+
                  "  ,PRE.DH_IMPRESSAO "+
                  "  FROM "+
                  "  DBAMV.ITPRE_MED IT "+
                  "  ,DBAMV.PRE_MED PRE "+
                  "  ,DBAMV.TIP_PRESC TP "+
                  "  WHERE "+
                  "  IT.CD_PRE_MED = ?"+
                  "  AND IT.CD_PRE_MED = PRE.CD_PRE_MED "+
                  "  AND TP.CD_TIP_PRESC = IT.CD_TIP_PRESC";
                  conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql); 
            stmt.setLong(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Item_Prescricao itens = new Item_Prescricao();
                itens.setCodigo(rs.getLong(3));
                itens.setDs_item(rs.getString(4));
                list.add(itens);
            }
             conn.close();
          }
        
        catch (SQLException ex) {
            
           Logger.getLogger(Prescricao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public boolean excluir (int codigo){
        boolean teste = false;
        
       
                    try{
                    sql = "DELETE FROM pre_med WHERE cd_pre_med = ?";
                    conn = ConnectionFactory.getConnection();
                    stmt = conn.prepareStatement(sql); 
                    stmt.setInt(1, codigo);
                    stmt.execute();
                    teste = true;
                     conn.close();
                }catch (SQLException ex) {
                    //Logger.getLogger(Prescricao_DAO.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao excluir\n"+ex.getMessage());
                }
        
                
        
        
        return teste;       
    }
    
    public boolean excluir_itens (long codigo){
        boolean teste = false;
        System.out.println("Excluindo itens");
        try{
            sql = "DELETE FROM DBAMV.ITPRE_MED ITP WHERE ITP.cd_pre_med = ?";
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql); 
            stmt.setLong(1, codigo);
            stmt.execute();
            teste = true;
             conn.close();
        }catch (SQLException ex) {
            //Logger.getLogger(Prescricao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não é possível excluir, verifique se essa prescricao nao possui itens\n"+ex.getMessage());
          //  mensagem = ex.getMessage();
        }
        
        return teste;       
    }
    
    
    public boolean assinar_prescricao(long codigo){
        boolean teste = false;
        Connection con1;
        System.out.println("Codigo da prescricao: "+codigo);
        String local = "ADVENTISTA_FECHA_PRESC_"+codigo;
        sql = "BEGIN" +
                "  EXECUTE IMMEDIATE 'ALTER SESSION SET sql_trace = true';" +
                "  EXECUTE IMMEDIATE 'ALTER SESSION SET tracefile_identifier = ''"+local+"''';" +
                "  dbamv.pkg_mv2000.atribui_empresa(1);" +
                "  dbamv.prc_pagu_fechar_prescricao("+codigo+"); " +
                "  EXECUTE IMMEDIATE 'ALTER SESSION SET sql_trace = false';" +
                "END;";
        
          con1 = FabricaDeConexao1.getConnection();
        try {
            stmt = con1.prepareStatement(sql);
            //stmt.setString(1, local);
            //stmt.setLong(2, codigo);
            stmt.execute();
            teste=true;
            con1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Prescricao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
}
