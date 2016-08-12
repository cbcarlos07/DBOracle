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
public class Guia {
    private int codigo;
    private int numero;
    private Paciente paciente;
    private Convenio convenio;
    private Tipo_Acompanhamento tipo_Acompanhamento;
    private int dias_Solicitados;
    private int dias_Autorizados;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Tipo_Acompanhamento getTipo_Acompanhamento() {
        return tipo_Acompanhamento;
    }

    public void setTipo_Acompanhamento(Tipo_Acompanhamento tipo_Acompanhamento) {
        this.tipo_Acompanhamento = tipo_Acompanhamento;
    }

    public int getDias_Solicitados() {
        return dias_Solicitados;
    }

    public void setDias_Solicitados(int dias_Solicitados) {
        this.dias_Solicitados = dias_Solicitados;
    }

    public int getDias_Autorizados() {
        return dias_Autorizados;
    }

    public void setDias_Autorizados(int dias_Autorizados) {
        this.dias_Autorizados = dias_Autorizados;
    }
    
}
