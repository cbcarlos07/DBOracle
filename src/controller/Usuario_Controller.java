/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import beans.Usuario;
import java.util.List;
import model.DAO.Usuario_DAO;

/**
 *
 * @author administrador
 */
public class Usuario_Controller {
    Usuario_DAO ud = new Usuario_DAO();
    
    public List<Usuario> lista(String u){
        List lista = ud.listar(u);
        return lista;
    }
    
    public void desativar_trigger(){
        ud.desativarTrigger();
    }
    
     public void ativar_trigger(){
        ud.ativarTrigger();
    }
    
}
