/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Usuarioss;
import ModeloDAO.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {
    String logear="Vista_usuario/login.jsp";
    String registrar="Vista_usuario/Registro.jsp";
    UsuariosDAO dao=new UsuariosDAO();

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
            out.println("<title>Servlet ControladorUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuario at " + request.getContextPath() + "</h1>");
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
        String acceso = "";
        String action = request.getParameter("accion");

        if (action != null && !action.isEmpty()) {
            if (action.equalsIgnoreCase("logear")) {
                acceso = logear;
            } else if (action.equalsIgnoreCase("Ingresar")) {
                String correo = request.getParameter("txtcorreo");
                String contraseña = request.getParameter("txtcontraseña");

                if (correo != null && !correo.isEmpty() && 
                    contraseña != null && !contraseña.isEmpty()) {
                    Usuarioss usuario  = dao.validarUsuario(correo, contraseña);

                    if (usuario != null) {
                        request.getSession().setAttribute("idUsuario", usuario.getId_usuario());
                        request.getSession().setAttribute("correoUsuario", correo);
                        acceso = "Vista_usuario/Suscripciones.jsp";
                    } else {
                        request.setAttribute("mensajeError", "Correo o contraseña incorrectos.");
                        acceso = "Vista_usuario/login.jsp";
                    }
                } else {
                    request.setAttribute("mensajeError", "Todos los campos son obligatorios.");
                    acceso = "error.jsp";
                }
            } else if (action.equalsIgnoreCase("add")) {
                Usuarioss u = new Usuarioss();
                u.setNombre("");
                u.setCorreo("");
                u.setContraseña("");
                acceso = registrar;
            } else if (action.equalsIgnoreCase("Registrar")) {
                String uusuario = request.getParameter("txtnombre");
                String ucorreo = request.getParameter("txtcorreo");
                String ucontraseña = request.getParameter("txtcontraseña");

                if (uusuario != null && !uusuario.isEmpty() &&
                    ucorreo != null && !ucorreo.isEmpty() &&
                    ucontraseña != null && !ucontraseña.isEmpty()) {

                    Usuarioss u = new Usuarioss();
                    u.setNombre(uusuario);
                    u.setCorreo(ucorreo);
                    u.setContraseña(ucontraseña);

                    boolean registroExitoso = dao.registrarUsuario(u);

                    if (registroExitoso) {
                        acceso = logear;
                    } else {
                        request.setAttribute("mensajeError", "No se pudo registrar el usuario. Inténtelo de nuevo.");
                        acceso = "error.jsp";
                    }
                } else {
                    request.setAttribute("mensajeError", "Todos los campos son obligatorios.");
                    acceso = "error.jsp";
                }
            } else {
                acceso = "error.jsp";
            }
        } else {
            acceso = "error.jsp";
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
