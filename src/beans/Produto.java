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
public class Produto {
    private int codigo;
    private String descricao;    
    private int orcamentario;
    private int kit;
    private Estoque estoque;
    private int qt_estoque_atual;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrcamentario() {
        return orcamentario;
    }

    public void setOrcamentario(int orcamentario) {
        this.orcamentario = orcamentario;
    }

    public int getKit() {
        return kit;
    }

    public void setKit(int kit) {
        this.kit = kit;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public int getQt_estoque_atual() {
        return qt_estoque_atual;
    }

    public void setQt_estoque_atual(int qt_estoque_atual) {
        this.qt_estoque_atual = qt_estoque_atual;
    }

   

            
            
}
