/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacpi.hospitaltades.dao;

import senacpi.hospitaltades.utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import senacpi.hospitaltades.model.Paciente;

/**
 *
 * @author Yury Cavalcante
 */
public class PacienteDAO {

    ConexaoBanco conexaoBanco = new ConexaoBanco();

    Connection conn;

    public PacienteDAO() {
        this.conn = ConexaoBanco.createConnection();
    }

    public List<Paciente> listarPacientes() throws Exception {
        System.out.println("Listagem de pacientes...");
        List<Paciente> lista = new ArrayList<>();
        String query = "";

        boolean vazio = true;

        query = "SELECT * FROM clientes";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();

                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setDataNasc(rs.getString("dataNasc"));
                paciente.setRg(rs.getString("rg"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setContato(rs.getString("contato"));
                paciente.setEmail(rs.getString("email"));
                paciente.setCep(rs.getString("cep"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setBairro(rs.getString("bairro"));
                paciente.setCidade(rs.getString("cidade"));
                paciente.setEstado(rs.getString("estado"));
                paciente.setAtivo(true);
                paciente.setCodigoempresa(rs.getInt("codigoempresa"));
                lista.add(paciente);
            }

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar cliente", ex);
        }

        return lista;

    }
}
