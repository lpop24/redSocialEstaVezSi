/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Login;
import facade.LoginFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
 * @author DaniUni
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    @EJB
    private LoginFacade loginFacade;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Login> listaLogin;
        
        int idUser = -1; //Si no consigue el ID, devuelve -1 como error
        
        String nombreUsuario = request.getParameter("nombreUsuario");
        String pass = request.getParameter("passUsuario");
        
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/loginFallido.jsp");
            rd.forward(request, response);
        }else{
            listaLogin = this.loginFacade.encontrarUsuario(nombreUsuario, pass); //Debería recibir 1 solo resultado
            if(listaLogin.isEmpty()){
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/loginFallido.jsp");
                rd.forward(request, response);
            }else{
               idUser = listaLogin.get(0).getIdLogin();
               
               HttpSession session = request.getSession();

               session.setAttribute("id", idUser);
               
               RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/PerfilServlet");
               rd.forward(request, response);
                
                //response.sendRedirect(request.getContextPath() + "/Perfilservlet");
            }   
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
        processRequest(request, response);
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
        processRequest(request, response);
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
