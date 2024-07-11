/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import ModeloDAO.BitlyURLShortener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author dales
 */
@WebServlet(name = "ControladorURL", urlPatterns = {"/ControladorURL"})
public class ControladorURL extends HttpServlet {
    BitlyURLShortener dao=new BitlyURLShortener();

    private static final String ACCESS_TOKEN = "be48b09bd24a5910d499925e1fba533c8f0cf07b";
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
            out.println("<title>Servlet ControladorURL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorURL at " + request.getContextPath() + "</h1>");
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
        String longUrl = request.getParameter("txturlOriginal");
        String shortUrl = "";
        int idUsuario = (int) request.getSession().getAttribute("idUsuario");
        
        if (longUrl != null && !longUrl.isEmpty()) {
            try {
                shortUrl = BitlyURLShortener.shortenUrl(longUrl); // Método para acortar URL
                boolean guardado = dao.guardarURLs(longUrl, shortUrl, idUsuario); // Método para guardar en la base de datos

                if (guardado) {
                    request.setAttribute("shortUrl", shortUrl);
                    request.getRequestDispatcher("Vista_usuario/resultado.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "Error al guardar la URL en la base de datos.");
                    request.getRequestDispatcher("Vista_usuario/eror.jsp").forward(request, response);
                }
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("mensajeError", "Error al acortar la URL. Inténtelo de nuevo.");
                request.getRequestDispatcher("Vista_mensajes/error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mensajeError", "La URL original está vacía.");
            request.getRequestDispatcher("Vista_usuario/error.jsp").forward(request, response);
        }
    }

    private String shortenUrl(String longUrl) throws IOException {
        String apiUrl = "https://api-ssl.bitly.com/v4/shorten";
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("long_url", longUrl);

        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(jsonBody.toString().getBytes());
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            return jsonResponse.getString("link");
        } else {
            throw new IOException("Error al acortar la URL. Código de respuesta: " + responseCode);
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
