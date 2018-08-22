package clases;

import java.util.Date;

public class Producto {

    private String categoria;
    private double precio;
    private String marca;
    private String tamanio;
    private Integer id;
    private Date fechaCaducidad;
    private int imagen;


    public Producto(String categoria, double precio, String marca, String tamanio, Integer id, Date fechaCaducidad, int imagen){
        this.setCategoria(categoria);
        this.setPrecio(precio);
        this.setMarca(marca);
        this.setTamanio(tamanio);
        this.setId(id);
        this.setFechaCaducidad(fechaCaducidad);
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


}
