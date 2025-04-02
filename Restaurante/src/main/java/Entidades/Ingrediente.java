package Entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author ErnestoLpz_252663
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private double cantidadDisponible;

    public Ingrediente() {
    }
    
    public Ingrediente(Long id, String nombre, double cantidadDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Ingrediente(String nombre, double cantidadDisponible) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
    }
    
    // Getters y Setters
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

    public double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", cantidadDisponible=" + cantidadDisponible + '}';
    }
}