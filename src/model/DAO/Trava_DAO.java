/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;


import beans.Trava;
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
public class Trava_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private final List list = null;
    
    public List<Trava> listar(String parametro){
       List lista = new ArrayList<>();
       sql = "select   " +
                            "  p.spid" +
                            "  ,s.SID" +
                            "  ,S.STATUS" +
                            "  ,s.SERIAL# serial" +
                            "  ,s.username" +
                            "  ,S.ACTION" +
                            "  ,s.osuser," +
                            "  s.machine," +
                            "  p.program," +
                            "  l.lmode," +
                            "  l.block  " +
                            "  ,S.ACTION" +
                            "  ,TO_CHAR(S.LOGON_TIME, 'dd/mm/yyyy hh24:mi:ss') LOGON_TIME" +
                            "  ,s.BLOCKING_SESSION " +
                            " from   v$session s," +
                            "  v$process p," +
                            "  v$lock l " +
                            " where  s.paddr = p.addr" +
                            " and  l.sid = s.sid " +
                            " and   s.username is not null" +
                            parametro +
                            " AND S.SID = L.SID " +
                            "group by  p.spid" +
                            "  ,s.SID" +
                            "  ,S.STATUS" +
                            "  ,s.SERIAL#" +
                            "  ,s.username" +
                            "  ,S.ACTION" +
                            "  ,s.osuser," +
                            "  s.machine," +
                            "  p.program," +
                            "  l.lmode," +
                            "  l.block  " +
                            "  ,S.ACTION" +
                            "  ,S.LOGON_TIME" +
                            "  ,s.BLOCKING_SESSION "+
                            "ORDER BY LOGON_TIME, BLOCK DESC   ";
                
           
           
       conn = ConnectionFactory.getConnection();
       try{
            
               stmt = conn.prepareStatement(sql);     
               System.out.println("SQL: "+sql);
               rs = stmt.executeQuery();
               while(rs.next()){
                   Trava trava = new Trava();
                                      
                   trava.setSpid(rs.getLong("spid"));
                   trava.setSid(rs.getLong("SID"));
                   trava.setSerial(rs.getLong("serial"));
                   trava.setUser(rs.getString("username"));
                   trava.setMaquina(rs.getString("machine"));
                   trava.setData(rs.getString("LOGON_TIME"));
                   trava.setActive(rs.getString("STATUS"));
                   trava.setOuser((rs.getString("osuser")));
                   trava.setAction(rs.getString("ACTION"));
                   lista.add(trava);
               
               }
       }catch (SQLException ex) {
               Logger.getLogger(SituacaoPaciente_DAO.class.getName()).log(Level.SEVERE, null, ex);
           }
       return lista;
    }
    
    public boolean matar_sessao(long sid, long serial){
        boolean teste = false;
        conn = ConnectionFactory.getConnection();
        sql = "ALTER SYSTEM KILL SESSION '"+sid+","+serial+"' IMMEDIATE";
        try {
            System.out.println("SID: "+sid);
            System.out.println("SERIAL: "+serial);
            stmt = conn.prepareStatement(sql);
           // stmt.setLong(1, sid);
            //stmt.setLong(2, serial);
            stmt.execute();
            teste = true;
        } catch (SQLException ex) {
            Logger.getLogger(Trava_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
        
    }
}
