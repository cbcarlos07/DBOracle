/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Trava;
import java.util.ArrayList;
import java.util.List;
import model.DAO.Trava_DAO;

/**
 *
 * @author CARLOS
 */
public class Trava_Controller {
    Trava_DAO td = new Trava_DAO();
    List list = new ArrayList();
    
    public List<Trava> listar(String parametro){
        list =  td.listar(parametro);
        return list;
    }
    public boolean matar_sessao(long sid, long serial){
        boolean teste = td.matar_sessao(sid, serial);
        return teste;
    }
}
