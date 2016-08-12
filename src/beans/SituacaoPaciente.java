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
public class SituacaoPaciente {
    private long atendimento;
     private Paciente paciente;
     private String cirugiaPrincipal;
     private String prestador;
     private String situacao;
     private String mensagem;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getCirugiaPrincipal() {
        return cirugiaPrincipal;
    }

    public void setCirugiaPrincipal(String cirugiaPrincipal) {
        this.cirugiaPrincipal = cirugiaPrincipal;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public long getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(long atendimento) {
        this.atendimento = atendimento;
    }

   
}
