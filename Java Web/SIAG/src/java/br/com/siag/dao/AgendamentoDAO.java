/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siag.dao;

import br.com.siag.beans.AgendaBean;

/**
 *
 * @author marcus
 */
public interface AgendamentoDAO {
    /**
     * 
     * @param agendamento
     * @return Insere agendamento no banco de dados
     */
    boolean agendarAula(AgendaBean agendamento);
}
