/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author home
 */
public class Lente {
    private String id;
    private String color;
    private String tipo;
    private String marca;
    private String material;
    private int flex;
    private int clasificacion;
    private String descripcion;
    private int precioRef;
    private int precioAct;
    private int stock;
    private int stockMin;
    private int estado;
    private String codigo;

    public Lente() {
    }

    public Lente(String id, String color,String tipo, String marca, String material, int flex, int clasificacion, String descripcion, int precioRef, int precioAct, int stock, int stockMin, int estado) {
        this.id = id;
        this.color = color;
        this.tipo = tipo;
        this.marca = marca;
        this.material = material;
        this.flex = flex;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
        this.precioRef = precioRef;
        this.precioAct = precioAct;
        this.stock = stock;
        this.stockMin = stockMin;
        this.estado = estado;
        setCodigo(id, marca, color);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setFlex(int flex) {
        this.flex = flex;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioRef(int precioRef) {
        this.precioRef = precioRef;
    }

    public void setPrecioAct(int precioAct) {
        this.precioAct = precioAct;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setCodigo(String id, String marca, String color) {
        this.codigo = id + "-" + marca + "-" + color;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getMaterial() {
        return material;
    }

    public int getFlex() {
        return flex;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecioRef() {
        return precioRef;
    }

    public int getPrecioAct() {
        return precioAct;
    }

    public int getStock() {
        return stock;
    }

    public int getStockMin() {
        return stockMin;
    }

    public int getEstado() {
        return estado;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
}
