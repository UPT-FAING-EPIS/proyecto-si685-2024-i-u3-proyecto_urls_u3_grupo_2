/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.URLS;
import Modelo.Usuarioss;
import ModeloDAO.BitlyURLShortener;
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
@WebServlet(name = "ControladorPerfil", urlPatterns = {"/ControladorPerfil"})
public class ControladorPerfil extends HttpServlet {
    String listar="Vista_usuario/Perfil.jsp";
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
            out.println("<title>Servlet ControladorPerfil</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPerfil at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("accion");
        String acceso = "";

        if ("listar".equalsIgnoreCase(action)) {
            // Obtener el ID de usuario desde la sesión o parámetro, asumiendo que se almacena como 'idUsuario'
            int idUsuario = (int) request.getSession().getAttribute("idUsuario");

            // Obtener datos del usuario por ID utilizando el DAO
            Usuarioss usuario = daoUsuarios.obtenerUsuarioPorId(idUsuario);

            // Establecer atributos en la solicitud para mostrar en la página JSP
            request.setAttribute("nombre", usuario.getNombre());
            request.setAttribute("correo", usuario.getCorreo());

            // Obtener lista de URLs del usuario
            List<URLS> listaURLS = daoUsuarios.listarURLS(idUsuario);

            // Establecer lista de URLs como atributo en la solicitud
            request.setAttribute("urls", listaURLS);

            // Obtener tipo de suscripción del usuario
            String tipoSuscripcion = daoUsuarios.obtenerTipoSuscripcion(idUsuario);
            request.setAttribute("suscripcion", tipoSuscripcion);
            System.out.println("Tipo de suscripción obtenido: " + tipoSuscripcion);

            // Obtener contador de URLs creadas
            int contadorURLs = daoUsuarios.contarURLSCreadas(idUsuario);
            request.setAttribute("contadorLinks", contadorURLs);

            // Establecer estado de suscripción en la sesión
            if (tipoSuscripcion != null && !tipoSuscripcion.isEmpty()) {
                request.getSession().setAttribute("tieneSuscripcion", true);
            } else {
                request.getSession().setAttribute("tieneSuscripcion", false);
            }

            acceso = listar; // Aquí 'perfilJSP' es la ruta a tu JSP de perfil
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
