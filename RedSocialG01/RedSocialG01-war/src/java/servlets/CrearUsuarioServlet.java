/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Experiencialaboral;
import entity.Login;
import entity.Usuario;
import facade.EstudiosFacade;
import facade.ExperiencialaboralFacade;
import facade.LoginFacade;
import facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
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
 * @author Loubna Channouf Cherradi
 * 
 * 
 */
@WebServlet(name = "CrearUsuarioServlet", urlPatterns = {"/CrearUsuarioServlet"})
public class CrearUsuarioServlet extends HttpServlet {

   
    @EJB
    private LoginFacade loginFacade;

   
    @EJB
    private UsuarioFacade usuarioFacade;
    
    

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
        
        
        /**
         * LOGIN
         **/
        
        
        Login login = new Login();
        
        String usuarioLogin = request.getParameter("usuarioLogin");
        String contrasena = request.getParameter("contrasena");
                
        login.setUsuarioLogin(usuarioLogin);
        login.setPassword(contrasena);
        
        this.loginFacade.create(login);
        
        
        /**
         * USUARIO
         */
        
        Usuario usuario = new Usuario();
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        java.util.Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaNacimiento"));
        String instagram = request.getParameter("instagram");
        String correoElectronico = request.getParameter("correoElectronico");
        String twitter = request.getParameter("twitter");
        String telefono = request.getParameter("telefono");
        String paginaWebUsuario = request.getParameter("paginaWebUsuario");
        String aficiones = request.getParameter("aficiones");
        String ciudad = request.getParameter("ciudad");
        
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setInstagram(instagram);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setTwitter(twitter);
        usuario.setTelefono(telefono);
        usuario.setPaginaWebUsuario(paginaWebUsuario);
        usuario.setAficiones(aficiones);
        usuario.setCiudad(ciudad);
        usuario.setLoginFK(login);
        
        this.usuarioFacade.create(usuario);
                
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/usuarioCreado.jsp");
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
            Logger.getLogger(CrearUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CrearUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
