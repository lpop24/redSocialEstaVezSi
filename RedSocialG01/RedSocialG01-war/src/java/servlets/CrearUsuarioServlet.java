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
    private ExperiencialaboralFacade experiencialaboralFacade;

    @EJB
    private LoginFacade loginFacade;

    @EJB
    private EstudiosFacade estudiosFacade;

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
        
        /**
         * EXPERIENCIA LABORAL
         **/
        
//        Collection<Experiencialaboral> experienciaLaboral;
//        Experiencialaboral explaboral = new Experiencialaboral();
//        
//        String nombreEmpresa = request.getParameter("nombreEmpresa");
//        java.util.Date fechaInicioLaboral = new SimpleDateFormat("dd-MM-yyy").parse(request.getParameter("fechaInicioLaboral"));
//        java.util.Date fechaFinLaboral = new SimpleDateFormat("dd-MM-yyy").parse(request.getParameter("fechaFinLaboral"));
//        String ubicacionEmpresa = request.getParameter("ubicacionEmpresa");
//        String paginaWebEmpresa = request.getParameter("paginaWebEmpresa");
//        String descripcionEmpresa = request.getParameter("descripcionEmpresa");
//        String puesto = request.getParameter("puesto");
//        
//        
//        explaboral.setNombreEmpresa(nombreEmpresa);
//        explaboral.setFechaInicioLaboral(fechaInicioLaboral);
//        explaboral.setFechaFinLaboral(fechaFinLaboral);
//        explaboral.setUbicacionEmpresa(ubicacionEmpresa);
//        explaboral.setPaginaWebEmpresa(paginaWebEmpresa);
//        explaboral.setDescripcionEmpresa(descripcionEmpresa);
//        explaboral.setPuesto(puesto);
//        explaboral.setExpLaboralUsuarioFK(usuario);
//        
//        this.experiencialaboralFacade.create(explaboral);
//        usuario.getExperiencialaboralCollection().add(explaboral);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/usuarioCreado.jsp");
        rd.forward(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearUsuarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearUsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
