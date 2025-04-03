/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author alega
 */
@Entity
@Table(name = "producto_ingrediente")
public class ProductoIngrediente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cantidad_requerida", nullable = false)
    private Double cantidadRequerida;

    @ManyToOne(fetch = FetchType.EAGER) // se usa fetch para cargar siempre el producto asociado
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER) // se usa fetch para cargar siempre el ingrediente asociado
    @JoinColumn(name = "ingrediente_id", nullable = false)
    private Ingrediente ingrediente;

    public ProductoIngrediente() {
    }

    public ProductoIngrediente(Long id, Double cantidadRequerida, Producto producto, Ingrediente ingrediente) {
        this.id = id;
        this.cantidadRequerida = cantidadRequerida;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }

    public ProductoIngrediente(Double cantidadRequerida, Producto producto, Ingrediente ingrediente) {
        this.cantidadRequerida = cantidadRequerida;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCantidadRequerida() {
        return cantidadRequerida;
    }

    public void setCantidadRequerida(Double cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "ProductoIngrediente{" + "id=" + id + ", cantidadRequerida=" + cantidadRequerida + ", producto=" + producto + ", ingrediente=" + ingrediente + '}';
    }
    
}
