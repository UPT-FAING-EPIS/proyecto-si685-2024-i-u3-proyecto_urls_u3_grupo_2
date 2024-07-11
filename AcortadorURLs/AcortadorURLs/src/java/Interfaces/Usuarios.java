/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.URLS;
import Modelo.Usuarioss;
import java.util.List;

/**
 *
 * @author dales
 */
public interface Usuarios {
    public Usuarioss validarUsuario(String correo, String contraseña);
    public boolean registrarUsuario(Usuarioss u);
    public Usuarioss obtenerUsuarioPorId(int idUsuario);
    public List<URLS> listarURLS(int idUsuario);
    public boolean actualizarSuscripcion(int idUsuario, int idSuscripcion);
    public int contarURLSCreadas(int idUsuario);
}
