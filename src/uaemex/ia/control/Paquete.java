package uaemex.ia.control;

import jade.content.Concept;

import java.io.Serializable;

public class Paquete  implements Concept {
    private String nombre;
    private int tipo;
    private float precio;
    private int cantidad;
    private String descripcion;

    public Paquete(String nombre, int tipo, float precio, int cantidad, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public Paquete() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
