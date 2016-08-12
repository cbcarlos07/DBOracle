/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conexao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import view.TelaLogin;
//import servicos.MensagensAviso;
/**
 *
 * @author Brito
 */
public final class FabricaDeConexao1 {
    
    
      static Properties confBanco = new Properties();
    public static Connection getConnection(){
		Connection connection = null;
                String url= null;
                String user = "dbamv";
                String senha = "#hosp#dvmns";
                String servico = FabricaDeConexao.servico;
                String host = FabricaDeConexao.host;
                
		try{
                        String arquivo = System.getProperty("user.dir") +
				"/Banco/oracle.properties";

                         confBanco.load(new FileInputStream(arquivo));
			//Class.forName("org.h2.Driver");
                        Class.forName(confBanco.getProperty("driver"));
                         url =confBanco.getProperty("url")+host+
                        (!confBanco.getProperty("porta").equals("")? ":" + confBanco.getProperty
                        ("porta") : confBanco.getProperty("porta"))+"/"
                        +servico;
                       
                        connection = DriverManager.getConnection(url,user,senha);
			//connection = DriverManager.getConnection("jdbc:h2:src/BDSistemaMusica/SistemaMusica","sa","");
                        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemamusica","root","123");
			System.out.println("FabricaDeConexao1 = Conectado com sucesso");
                        
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
                     //   JOptionPane.showMessageDialog(null, "Ja existe um Sistema em execução\nerro "+e.getMessage());
			System.out.println(e.getMessage());
                        
		}
                 catch (IOException e){
//                     MensagensAviso.erro("Arquivo de Configuração do Banco de Dados não encontrado !"+e.getMessage(),"Erro arquivo");
                    System.exit(0);
                 }
                System.out.println(url);
		return connection;
	}

    
    
}
