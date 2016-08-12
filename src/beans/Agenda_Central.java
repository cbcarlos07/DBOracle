/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author administrador
 */
public class Agenda_Central {
    private int codigo;
    private Servico_Disc servico;
    private Tipo_Marc tipo;
    private int qtde;
    private int qtde_encaixe;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Servico_Disc getServico() {
        return servico;
    }

    public void setServico(Servico_Disc servico) {
        this.servico = servico;
    }

    public Tipo_Marc getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_Marc tipo) {
        this.tipo = tipo;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
     @Override
    public String toString() {
        return tipo.getDescricao(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getQtde_encaixe() {
        return qtde_encaixe;
    }

    public void setQtde_encaixe(int qtde_encaixe) {
        this.qtde_encaixe = qtde_encaixe;
    }
}
