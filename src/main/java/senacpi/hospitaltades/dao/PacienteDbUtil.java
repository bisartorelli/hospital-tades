/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacpi.hospitaltades.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.sql.DataSource;
import senacpi.hospitaltades.model.Paciente;

/**
 *
 * @author Yury Cavalcante
 */
public class PacienteDbUtil {

    private DataSource dataSource;

    public PacienteDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Paciente> getPacientes() throws Exception {

        List<Paciente> pacientes = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = dataSource.getConnection();

            String sql = "select * from paciente order by nome";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {

                int id = myRs.getInt("id");
                String nome = myRs.getString("nome");
                String dataNasc = myRs.getString("dataNasc");
                String rg = myRs.getString("rg");
                String cpf = myRs.getString("cpf");
                String sexo = myRs.getString("sexo");
                String contato = myRs.getString("contato");
                String email = myRs.getString("email");
                String cep = myRs.getString("cep");
                String endereco = myRs.getString("endereco");
                String bairro = myRs.getString("bairro");
                String cidade = myRs.getString("cidade");
                String estado = myRs.getString("estado");
                boolean ativo = myRs.getBoolean("ativo");
                int codigoEmpresa = myRs.getInt("codigoempresa");
                
                Paciente paciente = new Paciente(id, nome, dataNasc, rg, cpf, sexo, contato, email, cep, endereco, bairro, cidade, estado, ativo, codigoEmpresa);
            }

            return pacientes;
            
        } finally {            
            close(myConn, myStmt, myRs);
        }
    }
    
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }
            
            if (myStmt != null) {
                myStmt.close();
            }
            
            if (myConn != null) {
                myConn.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();            
        }
    }

}
