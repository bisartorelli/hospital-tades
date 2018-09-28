/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacpi.hospitaltades.dao;

import senacpi.hospitaltades.utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void inserirCliente(Paciente paciente) {

        String query = "INSERT INTO paciente(nome, dataNasc, rg, cpf, sexo, contato, email,"
                + "cep, endereco, bairro, cidade, estado, ativo, codigoEmpresa) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getDataNasc());
            preparedStatement.setString(3, paciente.getRg());
            preparedStatement.setString(4, paciente.getCpf());
            preparedStatement.setString(5, paciente.getSexo());
            preparedStatement.setString(6, paciente.getContato());
            preparedStatement.setString(7, paciente.getEmail());
            preparedStatement.setString(8, paciente.getCep());
            preparedStatement.setString(9, paciente.getEndereco());
            preparedStatement.setString(10, paciente.getBairro());
            preparedStatement.setString(11, paciente.getCidade());
            preparedStatement.setString(12, paciente.getEstado());
            preparedStatement.setBoolean(13, true);
            preparedStatement.setInt(14, paciente.getCodigoempresa());
            System.out.println("Inserido");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente" + e);
        }
    }
}
