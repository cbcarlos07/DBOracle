package model.conexao;

//package util;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class NovaConexao {  
      
    private String url = "ojdbc:oracle:thin:@10.51.26.60:1521:xe";  
    private String usr = "dbamv";  
    private String pwd = "hosp#dvmns";  
    private Connection con = null;  
      
    public NovaConexao(){}  
      
    public Connection conectaBanco() throws SQLException, ClassNotFoundException{  
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        con = DriverManager.getConnection(url,usr,pwd);  
        return con;  
    }  
      
    public Connection fechaConexaoBanco() throws SQLException, ClassNotFoundException{  
        if(con != null){  
           con.close();  
        }  
        return con;  
    }  
}  