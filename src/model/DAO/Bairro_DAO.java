package model.DAO;

/*package DAO;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Bairro;
import model.conexao.ConnectionFactory;
import servicos.MensagensAviso;

public class Bairro_DAO {
    
    private String sql;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private List list = null;
    
    public boolean inserir(Bairro bairro){
         boolean teste = false;
        conn = ConnectionFactory.getConnection();
        sql = "INSERT INTO bairros values(NULL,?)";
       // sql = "{call sp_cargo_inserir(?,?,?,?)}";
        try {
            
            stmt = conn.prepareStatement(sql);
            //stmt = connection.prepareStatement(sql);
            stmt.setString(1, bairro.getDescricao());
            
            stmt.execute();
            teste = true;
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Cargo_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    public boolean compararSeBairroExiste(String nome){
        boolean teste = true;
        conn = ConnectionFactory.getConnection();
        sql ="SELECT * FROM bairros WHERE bai_nome = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            if(rs.next()){
                teste = false;
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(Cargo_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    public boolean alterar(Bairro bairro){
        
        boolean status = false;
        
        try 
        {
            
	        sql = " update bairros "+
	              " set bai_nome = ?"+
	              " where bai_id = ?";
	                
	        conn = ConnectionFactory.getConnection();
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, bairro.getDescricao());
                stmt.setInt(2, bairro.getCodigo());
	         stmt.execute();
	              status = true;
	              
              
        }catch (Exception e){
            
            Logger.getLogger(Cargo_DAO.class.getName()).log(Level.SEVERE, null, e);
            status = false;
        }
     
       return status;
    }
    
    public boolean excluir(int codigo){
          boolean teste = false;     
          
           try
           {
             sql = " delete from bairros "+
                   " where bai_id = ?";
           
             conn = ConnectionFactory.getConnection();             
             stmt = conn.prepareStatement(sql);
             stmt.setInt(1, codigo);
             stmt.execute();
            teste = true; 
           }catch(Exception e){
               MensagensAviso.erro(" O bairro não pode ser excluído \n " +
               						" Existe endereços registrados !", "Erro ao excluir");
           }
           return teste;
    }
    
    public List<Bairro> pesquisar_nome(String nome){
        Bairro bairro;
        List listar = new ArrayList();
        conn = ConnectionFactory.getConnection();
        try {
            if(nome.equals("")){
                sql = " select * from bairros  ";
                stmt = conn.prepareStatement(sql);
            }
            else{
                sql = " select * from bairros "+
	                      " where bai_nome LIKE ?";
                stmt = conn.prepareStatement(sql); 
                stmt.setString(1, "%" + nome + "%");
            }
            
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                bairro = new Bairro();
                bairro.setCodigo(rs.getInt("bai_id"));
                bairro.setDescricao(rs.getString("bai_nome"));
                
                listar.add(bairro);

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cargo_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listar;
    }//fim do metodo pesquisarPorNome
    
    
    public List listar_bairros(){
        
        try
        {
            
            list = new ArrayList();
            
           sql = (" select * from bairros order by bai_id");

            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
                
            while(rs.next()){
                
                Bairro bairro = new Bairro();
                
                bairro.setCodigo(rs.getInt("bai_id"));
                bairro.setDescricao(rs.getString("bai_nome"));
                
                list.add(bairro);
            }
                
        } catch (SQLException e){
            Logger.getLogger(Cargo_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return list;
    }
    
    
    public Integer gerar_codigo(){
        
        int aux = 0;
        
          sql = " select " +
		  		" coalesce(max(bai_id), 0) + 1 as codigo " +
		  		" from bairros ";
          
          try
          {            
              conn = ConnectionFactory.getConnection();
              stmt = conn.prepareStatement(sql);
              rs = stmt.executeQuery(sql);

               while (rs.next()){
            
                    aux = Integer.parseInt(rs.getString("codigo"));

               }
           
         
       }catch(Exception e){
            e.printStackTrace();
       }
        
       return aux;
    }
    
    
    public Bairro procurar_codigo(int codigo){
       
       boolean encontrou = false;
       Bairro bairro = new Bairro();
       
       sql = " select * "+
             " from bairros " +
             " where bai_id = ?";
                     
       try
       {            
           	conn = ConnectionFactory.getConnection();
           	stmt = conn.prepareStatement(sql);
                stmt.setInt(1, codigo);
           	rs = stmt.executeQuery(sql);  

	        while (rs.next())
	        {
	          encontrou = true;
	          
	          bairro.setCodigo(rs.getInt("bai_id"));
	          bairro.setDescricao(rs.getString("bai_nome"));
	        }

            if (!encontrou)
            {
                bairro = null;
                System.out.println("não encontrou");
            } 
            
            else 
            {
                System.out.println("encontrou");
            }
         
       }catch(Exception e){
            e.printStackTrace();
            
       }

       return bairro;
    }
    
    public Bairro procurar_descricao(String descricao){
       
       boolean encontrou = false;
       Bairro bairro = new Bairro();
       
       sql = " select * "+
             " from bairros " +
             " where bai_nome = ?";
                     
       try
       {            
           
           conn = ConnectionFactory.getConnection();
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, descricao);
           rs = stmt.executeQuery(sql);  

            while (rs.next())
            {
              encontrou = true;
              
              bairro.setCodigo(rs.getInt("bai_id"));
              bairro.setDescricao(rs.getString("bai_nome"));
            }

            if (!encontrou)
            {
                bairro = null;
                System.out.println("não encontrou");
            } 
            
            else 
            {
                System.out.println("encontrou");
            }
         
       }catch(Exception e){
            e.printStackTrace();
       }

       return bairro;
    }
    
}
*/