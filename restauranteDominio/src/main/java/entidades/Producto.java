package entidades;

import enums.Disponibilidad;
import enums.TipoPlatillo;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * Representa un producto del menú en el sistema de administración del restaurante.
 * Un producto puede ser un platillo o bebida con un nombre, precio, tipo, disponibilidad 
 * y una lista de ingredientes asociados.
 * 
 * Esta clase está mapeada a la tabla "productos" en la base de datos mediante JPA.
 * 
 * @author ErnestoLpz_252663
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    /**
     * Identificador único del producto. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto, este debe ser único y no puede ser nulo
     */
    @Column(unique = true, nullable = false, length = 100)
    private String nombre;

    /**
     * Precio del producto este no puede ser nulo
     */
    @Column(nullable = false)
    private double precio;

    /**
     * Tipo del producto
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPlatillo tipo;

    /**
     * Disponibilidad del producto
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Disponibilidad disponibilidad;

    /**
     * Conjunto de ingredientes que componen este producto
     * La relación es uno a muchos con la entidad ProductoIngrediente
     * Se permite cascada en persistencia, actualización y eliminación
     */
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<ProductoIngrediente> ingredientes;

    /**
     * Constructor vacío
     */
    public Producto() {
    }

    /**
     * Constructor con todos los campos incluyendo el id
     * 
     * @param id Identificador del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param tipo Tipo de platillo
     * @param disponibilidad Disponibilidad del producto
     * @param ingredientes Conjunto de ingredientes
     */
    public Producto(Long id, String nombre, double precio, TipoPlatillo tipo, Disponibilidad disponibilidad, Set<ProductoIngrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.ingredientes = ingredientes;
    }

    /**
     * Constructor con todos los campos pero ahora sin el id
     * 
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param tipo Tipo de platillo
     * @param disponibilidad Disponibilidad del producto
     * @param ingredientes Conjunto de ingredientes
     */
    public Producto(String nombre, double precio, TipoPlatillo tipo, Disponibilidad disponibilidad, Set<ProductoIngrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.ingredientes = ingredientes;
    }

    // Getters y Setters
    /**
     * Obtiene el ID del producto
     * @return ID del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del producto
     * @param id Nuevo ID del producto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     * @param nombre Nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     * @param precio Nuevo precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el tipo de platillo
     * @return Tipo de platillo
     */
    public TipoPlatillo getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de platillo
     * @param tipo Nuevo tipo de platillo
     */
    public void setTipo(TipoPlatillo tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la disponibilidad del producto
     * @return Disponibilidad actual del producto
     */
    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece la disponibilidad del producto
     * @param disponibilidad Nueva disponibilidad
     */
    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * Obtiene el conjunto de ingredientes del producto
     * @return Conjunto de ingredientes
     */
    public Set<ProductoIngrediente> getIngredientes() {
        return ingredientes;
    }

    /**
     * Establece el conjunto de ingredientes del producto
     * @param ingredientes Nuevo conjunto de ingredientes
     */
    public void setIngredientes(Set<ProductoIngrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Representación en texto del producto para propósitos de depuración
     * @return Cadena que representa el producto
     */
    @Override
    public String toString() {
        return "Producto{nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", disponibilidad=" + disponibilidad + ", ingredientes=" + ingredientes + '}';
    }
}
