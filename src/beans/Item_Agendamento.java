/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author carlos.bruno
 */
public class Item_Agendamento {
    private long cdItem;
    private String ds_Item;
    private String hrRealizacao;
    private String snAtivo;

    public long getCdItem() {
        return cdItem;
    }

    public void setCdItem(long cdItem) {
        this.cdItem = cdItem;
    }

    public String getDs_Item() {
        return ds_Item;
    }

    public void setDs_Item(String ds_Item) {
        this.ds_Item = ds_Item;
    }

    public String getHrRealizacao() {
        return hrRealizacao;
    }

    public void setHrRealizacao(String hrRealizacao) {
        this.hrRealizacao = hrRealizacao;
    }

    public String getSnAtivo() {
        return snAtivo;
    }

    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }
    
    public String toString(){
        return ds_Item;
    }
}
