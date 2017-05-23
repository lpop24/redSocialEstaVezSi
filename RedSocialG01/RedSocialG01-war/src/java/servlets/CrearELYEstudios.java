/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Experiencialaboral;
import entity.Usuario;
import facade.EstudiosFacade;
import facade.ExperiencialaboralFacade;
import facade.UsuarioFacade;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Loubna Channouf Cherradi
 */
@WebServlet(name = "CrearExperienciaLaboralYEstudios", urlPatterns = {"/CrearExperienciaLaboralYEstudios"})
public class CrearELYEstudios extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;
    
     @EJB
    private EstudiosFacade estudiosFacade;

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
        
        HttpSession session = request.getSession();        
        int idUsuario = (int) session.getAttribute("id");
        
        List<Usuario> usuarios;
        
        usuarios = usuarioFacade.encontrarPorId(idUsuario);
        
        Usuario usuario = usuarios.get(0);
        
        Experiencialaboral explaboral = new Experiencialaboral();
        
        String nombreEmpresa = request.getParameter("nombreEmpresa");
        java.util.Date fechaInicioLaboral = new SimpleDateFormat("dd-MM-yyy").parse(request.getParameter("fechaInicioLaboral"));
        java.util.Date fechaFinLaboral = new SimpleDateFormat("dd-MM-yyy").parse(request.getParameter("fechaFinLaboral"));
        String ubicacionEmpresa = request.getParameter("ubicacionEmpresa");
        String paginaWebEmpresa = request.getParameter("paginaWebEmpresa");
        String descripcionEmpresa = request.getParameter("descripcionEmpresa");
        String puesto = request.getParameter("puesto");
        
  
        explaboral.setNombreEmpresa(nombreEmpresa);
        explaboral.setFechaInicioLaboral(fechaInicioLaboral);
        explaboral.setFechaFinLaboral(fechaFinLaboral);
        explaboral.setUbicacionEmpresa(ubicacionEmpresa);
        explaboral.setPaginaWebEmpresa(paginaWebEmpresa);
        explaboral.setDescripcionEmpresa(descripcionEmpresa);
        explaboral.setPuesto(puesto);
        explaboral.setExpLaboralUsuarioFK(usuario);
        
        this.experiencialaboralFacade.create(explaboral);
        
//        Collection<Experiencialaboral> expLaboral = usuario.getExperiencialaboralCollection();
//        expLaboral.add(explaboral);
//        usuario.setExperiencialaboralCollection(expLaboral);
        
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
             Logger.getLogger(CrearELYEstudios.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(CrearELYEstudios.class.getName()).log(Level.SEVERE, null, ex);
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
