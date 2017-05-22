/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Estudios;
import facade.EstudiosFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RetailAdmin
 */
@WebServlet(name = "ActualizarEstudio", urlPatterns = {"/ActualizarEstudio"})
public class ActualizarEstudioServlet extends HttpServlet {

    @EJB
    private EstudiosFacade estudiosFacade;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String idEstudio = request.getParameter("idEstudio");
        String nombreCentro = request.getParameter("nombreCentro");
        String ubicacion = request.getParameter("ubicacionCentro");
        String descripcion = request.getParameter("descripcionCentro");
        
        int idEstudioint = new Integer(idEstudio);
        //Date fechaInicioEstudio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaInicioEstudio"));
        //Date fechaFinEstudio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaFinEstudio"));
        
        Estudios est = this.estudiosFacade.find(idEstudioint);
        
        est.setNombreCentro(nombreCentro);
        est.setUbicacionCentro(ubicacion);        
        //est.setFechaInicioEstudios(fechaInicioEstudio);
        //est.setFechaFinEstudios(fechaFinEstudio);
        est.setDescripcionCentro(descripcion);
        
        this.estudiosFacade.edit(est);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/PerfilServlet");
        rd.forward(request, response);
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
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ActualizarEstudioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ActualizarEstudioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
