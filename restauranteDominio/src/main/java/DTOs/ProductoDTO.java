/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enums.Disponibilidad;
import enums.TipoPlatillo;
import java.util.List;

/**
 * Clase de Transferencia de Datos (DTO) para la entidad Producto.
 * Esta clase se utiliza para transportar datos del producto entre diferentes capas
 * de la aplicación, como la capa de presentación y la capa de lógica de negocio
 *
 * @author ErnestoLpz_252663
 */
public class ProductoDTO {
    private Long id;
    private String nombre;
    private double precio;
    private TipoPlatillo tipo;
    private Disponibilidad disponibilidad;
    private List<ProductoIngredienteDTO> ingredientes;

    /**
     * Obtiene el id único del producto
     *
     * @return El id del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id único del producto
     *
     * @param id El id del producto a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto
     *
     * @return El nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     *
     * @param nombre El nombre del producto a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto
     *
     * @return El precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     *
     * @param precio El precio del producto a establecer
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el tipo de platillo del producto (definido por el enum TipoPlatillo)
     *
     * @return El tipo de platillo del producto
     */
    public TipoPlatillo getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de platillo del producto
     *
     * @param tipo El tipo de platillo del producto a establecer
     */
    public void setTipo(TipoPlatillo tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la disponibilidad del producto (definida por el enum Disponibilidad)
     *
     * @return La disponibilidad del producto
     */
    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece la disponibilidad del producto
     *
     * @param disponibilidad La disponibilidad del producto a establecer
     */
    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * Obtiene la lista de ingredientes del producto, representados por DTOs ProductoIngredienteDTO
     *
     * @return La lista de ingredientes del producto
     */
    public List<ProductoIngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    /**
     * Establece la lista de ingredientes del producto
     *
     * @param ingredientes La lista de ingredientes del producto a establecer
     */
    public void setIngredientes(List<ProductoIngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Constructor vacío
     */
    public ProductoDTO() {
    }

    /**
     * Constructor de la clase ProductoDTO que inicializa todos los atributos.
     *
     * @param id El id del producto
     * @param nombre El nombre del producto
     * @param precio El precio del producto
     * @param tipo El tipo de platillo del producto
     * @param disponibilidad La disponibilidad del producto
     * @param ingredientes La lista de ingredientes del producto
     */
    public ProductoDTO(Long id, String nombre, double precio, TipoPlatillo tipo, Disponibilidad disponibilidad, List<ProductoIngredienteDTO> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.ingredientes = ingredientes;
    }

    /**
     * Constructor de la clase ProductoDTO que inicializa todos los atributos.
     *
     * @param nombre El nombre del producto
     * @param precio El precio del producto
     * @param tipo El tipo de platillo del producto
     * @param disponibilidad La disponibilidad del producto
     * @param ingredientes La lista de ingredientes del producto
     */
    public ProductoDTO(String nombre, double precio, TipoPlatillo tipo, Disponibilidad disponibilidad, List<ProductoIngredienteDTO> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.ingredientes = ingredientes;
    }

    /**
     * Devuelve una representación en cadena del objeto ProductoDTO
     *
     * @return Una cadena que representa el objeto ProductoDTO, incluyendo sus atributos
     */
    @Override
    public String toString() {
        return "ProductoDTO{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", disponibilidad=" + disponibilidad + ", ingredientes=" + ingredientes + '}';
    }
}