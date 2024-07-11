/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.Usuarios;
import Modelo.URLS;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Usuarioss;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dales
 */
public class UsuariosDAO implements Usuarios {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Usuarioss u =new Usuarioss();
    

    @Override
    public Usuarioss validarUsuario(String correo, String contraseña) {
        Usuarioss usuario = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = new Conexion().getConnection();
            String query = "SELECT id_usuario, correo, contraseña FROM usuarios WHERE correo = ? AND contraseña = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Usuario válido, crea instancia de Usuarioss y configura los datos
                usuario = new Usuarioss();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContraseña(rs.getString("contraseña"));
                // Puedes setear más atributos si es necesario

                // Aquí se podría llamar a obtenerUsuarioPorId para obtener el usuario completo
                Usuarioss usuarioCompleto = obtenerUsuarioPorId(usuario.getId_usuario());
                if (usuarioCompleto != null) {
                    usuario = usuarioCompleto; // Actualiza con los detalles completos
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        } finally {
            // Cerrar recursos (rs, ps y con) en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return usuario;
    }

    @Override
    public boolean registrarUsuario(Usuarioss u) {
        String sql = "INSERT INTO usuarios (nombre, correo, contraseña) VALUES (?, ?, ?)";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getContraseña());
            int rowsAffected = ps.executeUpdate();
            ps.close();
            con.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            e.printStackTrace(); // Añadir esta línea para obtener más detalles sobre el error
            return false;
        }
    }

    @Override
    public Usuarioss obtenerUsuarioPorId(int idUsuario) {
        Usuarioss usuario = null;
        try {
            con = new Conexion().getConnection();
            String query = "SELECT id_usuario, nombre, correo FROM usuarios WHERE id_usuario = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuarioss();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                // Puedes setear más atributos si es necesario
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario por ID: " + e.getMessage());
        } finally {
            // Cerrar recursos (rs, ps y con) en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return usuario;
    }

    @Override
    public List<URLS> listarURLS(int idUsuario) {
        List<URLS> urls = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = new Conexion().getConnection();
            String query = "SELECT * FROM urls WHERE id_usuario = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                URLS url = new URLS();
                url.setUrl_original(rs.getString("url_original"));
                url.setUrl_acortada(rs.getString("url_acortada"));
                url.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
                url.setEstado_validez(rs.getTimestamp("estado_validez"));
                urls.add(url);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener URLs por usuario: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return urls;
    }
    
    public String obtenerTipoSuscripcion(int idUsuario) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tipoSuscripcion = null;

        try {
            con = new Conexion().getConnection();
            String query = "SELECT s.tipo_suscripcion FROM suscripciones s " +
                           "INNER JOIN usuarios u ON s.id_suscripcion = u.id_suscripcion " +
                           "WHERE u.id_usuario = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoSuscripcion = rs.getString("tipo_suscripcion");
            } else {
                tipoSuscripcion = "Active su suscripcion en la seccion de suscripciones :)";
            }
        } catch (SQLException e) {
            tipoSuscripcion = "Error: " + e.getMessage();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                tipoSuscripcion = "Error al cerrar recursos: " + e.getMessage();
            }
        }

        return tipoSuscripcion;
    }

    @Override
    public boolean actualizarSuscripcion(int idUsuario, int idSuscripcion) {

        boolean actualizado = false;

        try {
            con = new Conexion().getConnection();
            String query = "UPDATE Usuarios SET id_suscripcion = ? WHERE id_usuario = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idSuscripcion);
            ps.setInt(2, idUsuario);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return actualizado;
    }
    
    @Override
    public int contarURLSCreadas(int idUsuario) {
        int count = 0;

        try {
            con = new Conexion().getConnection();
            String sql = "SELECT COUNT(*) AS total FROM urls WHERE id_usuario = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción apropiadamente
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Manejar la excepción apropiadamente
            }
        }

        return count;
    }
}
