package uaemex.ia.control;

import jade.content.Concept;

import java.io.Serializable;

public class Boletos implements Concept {
    private String nombre;
    private String asiento;
    private String tipoSala;
    private String salaAsignada;
    private float  precio;
    private String fecha;
    private int cantidad;

    public Boletos(String nombre, String asiento, String tipoSala, String salaAsignada, float precio, String fecha, int cantidad) {
        this.nombre = nombre;
        this.asiento = asiento;
        this.tipoSala = tipoSala;
        this.salaAsignada = salaAsignada;
        this.precio = precio;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Boletos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public String getSalaAsignada() {
        return salaAsignada;
    }

    public void setSalaAsignada(String salaAsignada) {
        this.salaAsignada = salaAsignada;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Boletos{" +
                "nombre='" + nombre + '\'' +
                ", asiento='" + asiento + '\'' +
                ", tipoSala='" + tipoSala + '\'' +
                ", salaAsignada='" + salaAsignada + '\'' +
                ", precio=" + precio +
                ", fecha='" + fecha + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
