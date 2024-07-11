/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author dales
 */
public class Suscripciones {
    private int id_suscripcion;
    private int id_usuario;
    private String tipo_suscripcion;
    private Timestamp fecha_inicio;
    private Timestamp fecha_fin;

    public Suscripciones() {
    }

    public Suscripciones(int id_suscripcion, int id_usuario, String tipo_suscripcion, Timestamp fecha_inicio, Timestamp fecha_fin) {
        this.id_suscripcion = id_suscripcion;
        this.id_usuario = id_usuario;
        this.tipo_suscripcion = tipo_suscripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId_suscripcion() {
        return id_suscripcion;
    }

    public void setId_suscripcion(int id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_suscripcion() {
        return tipo_suscripcion;
    }

    public void setTipo_suscripcion(String tipo_suscripcion) {
        this.tipo_suscripcion = tipo_suscripcion;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Timestamp getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    
}
