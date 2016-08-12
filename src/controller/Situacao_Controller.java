/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import beans.SituacaoPaciente;
import java.util.List;
import model.DAO.SituacaoPaciente_DAO;

/**
 *
 * @author administrador
 */
public class Situacao_Controller {
    SituacaoPaciente_DAO sd = new SituacaoPaciente_DAO();
    SituacaoPaciente sp = new SituacaoPaciente();
    public List<SituacaoPaciente> lista (){
        List lista = sd.listar();
        return lista;
    }
         
}
