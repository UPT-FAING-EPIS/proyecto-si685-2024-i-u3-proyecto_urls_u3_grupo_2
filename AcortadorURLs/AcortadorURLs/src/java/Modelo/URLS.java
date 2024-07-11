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
public class URLS {
    private int id_url;
    private String url_original;
    private String url_acortada;
    private Timestamp fecha_creacion;
    private Timestamp estado_validez;
    private int id_usuario;

    public URLS() {
    }

    public URLS(int id_url, String url_original, String url_acortada, Timestamp fecha_creacion, Timestamp estado_validez, int id_usuario) {
        this.id_url = id_url;
        this.url_original = url_original;
        this.url_acortada = url_acortada;
        this.fecha_creacion = fecha_creacion;
        this.estado_validez = estado_validez;
        this.id_usuario = id_usuario;
    }

    public int getId_url() {
        return id_url;
    }

    public void setId_url(int id_url) {
        this.id_url = id_url;
    }

    public String getUrl_original() {
        return url_original;
    }

    public void setUrl_original(String url_original) {
        this.url_original = url_original;
    }

    public String getUrl_acortada() {
        return url_acortada;
    }

    public void setUrl_acortada(String url_acortada) {
        this.url_acortada = url_acortada;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Timestamp getEstado_validez() {
        return estado_validez;
    }

    public void setEstado_validez(Timestamp estado_validez) {
        this.estado_validez = estado_validez;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
