/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import entity.Estudios;
import entity.Experiencialaboral;
import entity.Usuario;
import facade.EstudiosFacade;
import facade.ExperiencialaboralFacade;
import facade.UsuarioFacade;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author Alvaro Medina Martinez
 */
@WebServlet(name = "ActualizarPerfil", urlPatterns = {"/ActualizarPerfil"})
public class ActualizarPerfilServlet extends HttpServlet {

    @EJB
    private ExperiencialaboralFacade experiencialaboralFacade;

    @EJB
    private EstudiosFacade estudiosFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        
        
        HttpSession session = request.getSession();
        
        //Actualizar usuario
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        String nombreUsuario = request.getParameter("nombre");
        String apellidosUsuario = request.getParameter("apellidos");
        String instagramUsuario = request.getParameter("instagram");
        String emailUsuario = request.getParameter("email");
        String twitterUsuario = request.getParameter("twitter");
        String telefonoUsuario = request.getParameter("telefono");
        Date fecha_nacimientoUsuario = fecha_nacimientoUsuario = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fecha_nacimiento"));
        String pagina_webUsuario = request.getParameter("pagina_web");
        String aficionesUsuario = request.getParameter("aficiones");
        String ciudadUsuario = request.getParameter("ciudad");
        
        Usuario usuarioEditar;
        usuarioEditar = this.usuarioFacade.find(usuario.getIdUsuario());
        
        usuarioEditar.setNombre(nombreUsuario);
        usuarioEditar.setApellidos(apellidosUsuario);
        usuarioEditar.setInstagram(instagramUsuario);
        usuarioEditar.setCorreoElectronico(emailUsuario);
        usuarioEditar.setTwitter(twitterUsuario);
        usuarioEditar.setTelefono(telefonoUsuario);
        usuarioEditar.setFechaNacimiento(fecha_nacimientoUsuario);
        usuarioEditar.setPaginaWebUsuario(pagina_webUsuario);
        usuarioEditar.setAficiones(aficionesUsuario);
        usuarioEditar.setCiudad(ciudadUsuario);
        
        usuarioFacade.edit(usuarioEditar);
        
//        //Actualizar estudios
//        
//        List<Estudios> estudios = estudiosFacade.findEstudiosPoridUsuario(usuario.getIdUsuario());
//        String[] idEstudios = request.getParameterValues("idEstudio");
//        String[] nombresCentro = request.getParameterValues("nombreCentro");
//        String[] fechasInicioEstudio = request.getParameterValues("fechaInicioEstudio");
//        String[] fechasFinEstudio = request.getParameterValues("fechaFinEstudio");
//        
//        
//        Estudios estudioActualizar;
//        
//        for(Estudios est : estudios)
//        {
//            estudioActualizar = estudiosFacade.findEstudioPorIdEstudio(est.getIdEstudios());
//            estudioActualizar.setNombreCentro(request.getParameter("nombreCentro"));
//            estudioActualizar.setFechaInicioEstudios(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fechaInicioEstudio")));
//            estudioActualizar.setFechaFinEstudios(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fechaFinEstudio")));
//            estudioActualizar.setUbicacionCentro(request.getParameter("ubicacionCentro"));
//            estudioActualizar.setDescripcionCentro("descripcionCentro");
//            
//            estudiosFacade.edit(estudioActualizar);
//        }
//        
//        //Actualizar exp.laboral
//        
//        List<Experiencialaboral> experiencias = experiencialaboralFacade.findExperienciaslaboralesPoridUsuario(usuario.getIdUsuario());
//        
//        for(Experiencialaboral exp : experiencias)
//        {
//            exp.setNombreEmpresa(request.getParameter("nombreEmpresa"));
//            exp.setFechaInicioLaboral(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fechaInicioLaboral")));
//            exp.setFechaFinLaboral(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fechaFinLaboral")));
//            exp.setPaginaWebEmpresa(request.getParameter("paginaWebEmpresa"));
//            exp.setUbicacionEmpresa(request.getParameter("ubicacionEmpresa"));
//            exp.setDescripcionEmpresa("descripcionEmpresa");
//            
//            experiencialaboralFacade.edit(exp);
//        }
        
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
            Logger.getLogger(ActualizarPerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ActualizarPerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
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