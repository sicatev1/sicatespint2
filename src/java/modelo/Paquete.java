/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

public class Paquete implements Serializable {

    private String guia;
    private String fecha_entrega;
    private String fecha_salida;
    private String remitente;
    private String destinatario;
    private String ruta;

    public Paquete() {
    }

    public Paquete(String guia, String fecha_entrega, String fecha_salida, String remitente, String destinatario, String ruta) {
        this.guia = guia;
        this.fecha_entrega = fecha_entrega;
        this.fecha_salida = fecha_salida;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.ruta = ruta;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
