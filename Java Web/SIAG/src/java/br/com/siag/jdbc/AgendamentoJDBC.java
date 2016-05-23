/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siag.jdbc;

import br.com.siag.beans.AgendaBean;
import br.com.siag.dao.AgendamentoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marcus
 */
public class AgendamentoJDBC implements AgendamentoDAO {

    private final Connection conexao;

    public AgendamentoJDBC(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public boolean agendarAula(AgendaBean agendamento) {
        PreparedStatement pst;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tbl_agendamento (cod_aluno,cod_dia,cod_servico) VALUES(?,?,?)");
        boolean b;
        try {
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, agendamento.getId_usuario());
            pst.setInt(2, agendamento.getId_dia());
            pst.setInt(3, agendamento.getServico());
            pst.execute();
            b = true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO MARCAR AGENDAMENTO --- ERRO || " + ex);
            b = false;
        }

        return b;
    }
}
