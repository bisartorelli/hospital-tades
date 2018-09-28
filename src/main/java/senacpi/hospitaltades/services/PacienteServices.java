/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacpi.hospitaltades.services;

import java.io.IOException;
import java.util.List;
import senacpi.hospitaltades.dao.PacienteDAO;
import senacpi.hospitaltades.model.Paciente;

/**
 *
 * @author Yury Cavalcante
 */
public class PacienteServices {
    PacienteDAO pacienteDAO = new PacienteDAO();
    
    public List<Paciente> listarPacientes() throws IOException, Exception {
        try {
            return pacienteDAO.listarPacientes();
            
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
        }
}
}
