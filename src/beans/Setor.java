/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author linux
 */
public class Setor {
    private int codigo;
    private String nome;
    private int qtde;
    private Date dataAtend;
    
          

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getDataAtend() {
        return dataAtend;
    }

    public void setDataAtend(Date dataAtend) {
        this.dataAtend = dataAtend;
    }

    
    
   
}
