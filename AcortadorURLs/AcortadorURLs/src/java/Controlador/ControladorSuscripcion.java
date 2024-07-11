/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.URLS;
import Modelo.Usuarioss;
import ModeloDAO.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dales
 */
@WebServlet(name = "ControladorSuscripcion", urlPatterns = {"/ControladorSuscripcion"})
public class ControladorSuscripcion extends HttpServlet {
    UsuariosDAO daoUsuarios = new UsuariosDAO();
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorSuscripcion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorSuscripcion at " + request.getContextPath() + "</h1>");
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
        String accion = request.getParameter("accion");
    
        if (accion != null && accion.equals("suscribir")) {
            int idUsuario = (int) request.getSession().getAttribute("idUsuario");
            int idSuscripcion = Integer.parseInt(request.getParameter("idSuscripcion"));

            boolean actualizado = daoUsuarios.actualizarSuscripcion(idUsuario, idSuscripcion);

            if (actualizado) {
                request.getSession().setAttribute("mensaje", "Suscripción actualizada correctamente.");
            } else {
                request.getSession().setAttribute("mensaje", "Error al actualizar la suscripción.");
            }

            response.sendRedirect("ControladorMenu?accion=suscripciones");
        } else {
            response.sendRedirect("ControladorMenu?accion=inicio");
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
