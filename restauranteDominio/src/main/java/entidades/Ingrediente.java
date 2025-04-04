package entidades;

import enums.UnidadMedida;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 * Entidad Ingrediente que representa los elementos que contienen los productos.
 * Mantiene una relación con ProductoIngrediente.
 * 
 * @author alega
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable { 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "unidad_medida", nullable = false)
    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;

    @Column(name = "stock", nullable = false)
    private Double stock;
    
    @OneToMany(mappedBy = "ingrediente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // relación bidireccional, solo se utilizar las casacadas para persistir y actualizar
    private List<ProductoIngrediente> productos = new ArrayList<>();

    public Ingrediente() {
    }

    public Ingrediente(Long id, String nombre, UnidadMedida unidadMedida, Double stock) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    public Ingrediente(String nombre, UnidadMedida unidadMedida, Double stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public List<ProductoIngrediente> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoIngrediente> productos) {
        this.productos = productos;
    }
    
    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", stock=" + stock + ", productos=" + productos + '}';
    }
    
}