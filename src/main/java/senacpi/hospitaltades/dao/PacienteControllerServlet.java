/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacpi.hospitaltades.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import senacpi.hospitaltades.model.Paciente;

/**
 *
 * @author Yury Cavalcante
 */
public class PacienteControllerServlet extends HttpServlet {

    private PacienteDbUtil pacienteDbUtil; 
    
    @Resource(name="jdbc/hospital_tades")
    private DataSource dataSource;
    
    @Override
    public void init() throws ServletException {
        
        super.init();
        
        try {
            pacienteDbUtil = new PacienteDbUtil(dataSource);
        }
        catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            listarPacientes(request, response);
        }
        catch (Exception e) {
            throw new ServletException(e);
        }
            
            
    }

    private void listarPacientes(HttpServletRequest request, HttpServletResponse response)
        throws Exception  {
        List<Paciente> pacientes = pacienteDbUtil.getPacientes();
        
        request.setAttribute("PACIENTES", pacientes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-pacientes.jsp");
        
        dispatcher.forward(request, response);
    }
}
