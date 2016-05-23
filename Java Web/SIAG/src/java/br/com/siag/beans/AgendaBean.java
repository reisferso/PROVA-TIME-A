/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siag.beans;

/**
 *
 * @author marcus
 */
public class AgendaBean {
    
    private Integer id_agenda;
    private Integer id_usuario;
    private Integer id_dia;
    private Integer id_atendente;
    private Integer cat_servico;
    private Integer servico;
    private Integer guiche;

    public Integer getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(Integer id_agenda) {
        this.id_agenda = id_agenda;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_dia() {
        return id_dia;
    }

    public void setId_dia(Integer id_dia) {
        this.id_dia = id_dia;
    }

    public Integer getId_atendente() {
        return id_atendente;
    }

    public void setId_atendente(Integer id_atendente) {
        this.id_atendente = id_atendente;
    }

    public Integer getCat_servico() {
        return cat_servico;
    }

    public void setCat_servico(Integer cat_servico) {
        this.cat_servico = cat_servico;
    }

    public Integer getServico() {
        return servico;
    }

    public void setServico(Integer servico) {
        this.servico = servico;
    }

    public Integer getGuiche() {
        return guiche;
    }

    public void setGuiche(Integer guiche) {
        this.guiche = guiche;
    }
    
    
}
