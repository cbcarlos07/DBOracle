/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;


import beans.Paciente;
import beans.SituacaoPaciente;
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
public class SituacaoPaciente_DAO {
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private final List list = null;
    
    public List<SituacaoPaciente> listar(){
       List lista = new ArrayList<>();
       sql = "SELECT  "+
      " SIT.ATENDIMENTO "+         
      ",SIT.PACIENTE "+
       ",SIT.CIRURGIA CIRURGIA_PRINCIPAL "+
       ",SIT.PRESTADOR "+
       ",SIT.SITUACAO "+
       ",MSG.MENSAGEM "+
  "FROM  (      "+

              "SELECT  P.NM_PACIENTE     PACIENTE "+
                    " ,CIR.DS_CIRURGIA   CIRURGIA "+
                    " ,PR.NM_PRESTADOR   PRESTADOR "+
                    " ,A.CD_ATENDIMENTO  ATENDIMENTO "+

                    " ,CASE "+
                    "    WHEN (MOV.DT_CENTRO_CIRURGICO) IS NULL AND (MOV.DT_ENTRADA_RPA)IS NULL AND (MOV.DT_CHAMADA_TRANSF) IS NOT NULL "+
                    "       THEN 'SALA PRÉ-CIRÚRGICA' "+
                    "    WHEN (MOV.DT_CENTRO_CIRURGICO) IS NOT NULL AND (MOV.DT_ENTRADA_RPA) IS NULL "+
                    "       THEN 'SALA DE CIRURGIA' "+
                    "    WHEN (MOV.DT_ENTRADA_RPA)      IS NOT NULL AND (MOV.DT_SAIDA_RPA)   IS NULL "+
                    "       THEN 'SALA PÓS-CIRÚRGICA' "+
                    "   WHEN (MOV.DT_SAIDA_RPA)        IS NOT NULL "+
                    "       THEN 'TRANSFERIDO PARA APARTAMENTO/ENFERMARIA' "+
                    " END SITUACAO                     "+
                    ",SYSDATE "+
                    " ,MOV.DT_SAIDA_RPA "+
                    ",(SYSDATE-MOV.DT_SAIDA_RPA)  "+
                "FROM DBAMV.MOV_CC_RPA MOV "+
                "    ,DBAMV.CIRURGIA_AVISO CA "+
                "    ,DBAMV.CIRURGIA   CIR "+
                "    ,DBAMV.ATENDIME   A "+
                "    ,DBAMV.PACIENTE   P "+
                "    ,DBAMV.PRESTADOR_AVISO PREST "+
                "   ,DBAMV.PRESTADOR  PR "+
               "WHERE CA.CD_AVISO_CIRURGIA    =     MOV.CD_AVISO_CIRURGIA "+
               "  AND CIR.CD_CIRURGIA         =     CA.CD_CIRURGIA "+
               "  AND PR.CD_PRESTADOR         =     PREST.CD_PRESTADOR "+
               "  AND MOV.CD_AVISO_CIRURGIA   =     PREST.CD_AVISO_CIRURGIA "+
               "  AND CA.CD_CIRURGIA_AVISO    =     PREST.CD_CIRURGIA_AVISO "+
               "  AND MOV.CD_ATENDIMENTO      =     A.CD_ATENDIMENTO "+
               "  AND P.CD_PACIENTE           =     A.CD_PACIENTE "+
               "  AND CA.SN_PRINCIPAL         =    'S' "+
               "  AND PREST.CD_ATI_MED        =    '01' "+
               "  AND MOV.DT_CHAMADA_TRANSF         IS NOT NULL "+
               "  AND A.DT_ALTA                     IS NULL "+
               "  AND   SYSDATE-MOV.DT_CHAMADA_TRANSF < 1  "+
               "  AND ((SYSDATE-MOV.DT_SAIDA_RPA) < 0.125 OR MOV.DT_SAIDA_RPA IS NULL) "+
             " ) SIT "+
            " ,( "+
             "   SELECT  MAX(DBMS_LOB.substr(lo_valor)) KEEP (DENSE_RANK LAST ORDER BY E.DH_CRIACAO) MENSAGEM "+
             "          ,e.cd_atendimento         ATENDIMENTO " +
             "     FROM  pw_editor_clinico a "+
             "          ,dbamv.editor_documento b  "+
             "          ,editor_registro_campo c "+
             "          ,editor_campo d "+
             "          ,dbamv.pw_documento_clinico e "+
             "    WHERE a.cd_documento = b.cd_documento "+
             "      AND a.cd_editor_registro = c.cd_registro(+) "+
             "      AND c.cd_campo = d.cd_campo(+) "+
             "      AND a.cd_documento_clinico = e.cd_documento_clinico "+
             "      and a.cd_documento = 198 "+
             "      AND d.cd_metadado  = 74124 "+
             "      group by e.cd_atendimento "+
             " ) MSG "+
  " WHERE SIT.ATENDIMENTO = MSG.ATENDIMENTO(+)      "+
  " ORDER BY 1 ";
           
           
       conn = ConnectionFactory.getConnection();
       try{
            
               stmt = conn.prepareStatement(sql);
               rs = stmt.executeQuery();
               while(rs.next()){
                   SituacaoPaciente sp = new SituacaoPaciente();
                                      
                   sp.setPaciente(new Paciente());
                   sp.setAtendimento(rs.getLong("ATENDIMENTO"));
                   sp.getPaciente().setNome(rs.getString("PACIENTE"));
                   sp.setCirugiaPrincipal(rs.getString("CIRURGIA_PRINCIPAL"));
                   sp.setPrestador(rs.getString("PRESTADOR"));
                   sp.setSituacao(rs.getString("SITUACAO"));
                   sp.setMensagem(rs.getString("MENSAGEM"));
                   lista.add(sp);
               
               }
       }catch (SQLException ex) {
               Logger.getLogger(SituacaoPaciente_DAO.class.getName()).log(Level.SEVERE, null, ex);
           }
          
       
       return lista;
    }
}
