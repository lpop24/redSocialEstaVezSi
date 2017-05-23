/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Experiencialaboral;
import facade.ExperiencialaboralFacade;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
 * @author DaniUni
 */
@WebServlet(name = "ActualizarExperiencia", urlPatterns = {"/ActualizarExperiencia"})
public class ActualizarExperienciaLaboralServlet extends HttpServlet {

    @EJB
    private ExperiencialaboralFacade experiencialaboralFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String idExperiencia = request.getParameter("idExperienciaLaboral");
        String nombreEmpresa = request.getParameter("nombreEmpresa");
        String puesto = request.getParameter("puesto");
        String ubicacion = request.getParameter("ubicacionEmpresa");
        String descripcion = request.getParameter("descripcionEmpresa");
        String web = request.getParameter("web");
        
        int idExpint = new Integer(idExperiencia);
        
        Date fechaInicioExp = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzzz yyyy", Locale.ENGLISH).parse(request.getParameter("fechaInicioExp"));
        Date fechaFinExp = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzzz yyyy", Locale.ENGLISH).parse(request.getParameter("fechaFinExp"));
        
        Experiencialaboral exp = this.experiencialaboralFacade.find(idExpint);
        
        exp.setNombreEmpresa(nombreEmpresa);
        exp.setUbicacionEmpresa(ubicacion);  
        exp.setPuesto(puesto); 
        exp.setPaginaWebEmpresa(web);
        exp.setFechaInicioLaboral(fechaInicioExp);
        exp.setFechaFinLaboral(fechaFinExp);
        exp.setDescripcionEmpresa(descripcion);
        
        this.experiencialaboralFacade.edit(exp);
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
            Logger.getLogger(ActualizarExperienciaLaboralServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ActualizarExperienciaLaboralServlet.class.getName()).log(Level.SEVERE, null, ex);
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
