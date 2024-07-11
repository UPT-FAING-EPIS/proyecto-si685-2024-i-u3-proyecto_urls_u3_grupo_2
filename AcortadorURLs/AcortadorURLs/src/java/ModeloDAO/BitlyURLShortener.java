/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

/**
 *
 * @author dales
 */

import Config.Conexion;
import Interfaces.URLs;
import Modelo.URLS;
import Modelo.Usuarioss;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONObject;

public class BitlyURLShortener implements URLs{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Usuarioss u =new Usuarioss();

    
    
    private static final String ACCESS_TOKEN = "be48b09bd24a5910d499925e1fba533c8f0cf07b"; // Reemplaza con tu token de acceso

    public static String shortenUrl(String longUrl) throws IOException {
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
    
    
    public BitlyURLShortener() {
        this.con = new Conexion().getConnection();
    }
    @Override
    public boolean guardarURLs(String urlOriginal, String shortUrl, int idUsuario) {
        boolean guardado = false;
        PreparedStatement ps = null;

        try {
            // Obtener la fecha actual y sumar una semana
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.WEEK_OF_YEAR, 1); // Sumar una semana

            Timestamp fechaValida = new Timestamp(cal.getTimeInMillis());

            String sql = "INSERT INTO urls (url_original, url_acortada, id_usuario, estado_validez) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, urlOriginal);
            ps.setString(2, shortUrl);
            ps.setInt(3, idUsuario);
            ps.setTimestamp(4, fechaValida); // Establecer la fecha válida

            int filasInsertadas = ps.executeUpdate();
            guardado = filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return guardado;
    }
}
