package entidades;

import enums.UnidadMedida;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Entidad Ingrediente que representa los elementos que contienen los productos.
 * Mantiene una relación con ProductoIngrediente.
 * 
 * @author Alejandra García Preciado - 252444
 * Responsable de módulo: Ingredientes
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable { 
    
    /**
     * Identificador único del ingrediente. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del ingrediente. No puede ser nulo y tiene un máximo de 100
     * caracteres.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    /**
     * Unidad de medida del ingrediente (piezas, gramos o mililitros). 
     * Es de tipo enum y no puede ser nulo.
     */
    @Column(name = "unidad_medida", nullable = false)
    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;

    /**
     * Cantidad disponible del ingrediente en stock. No puede ser nulo.
     */
    @Column(name = "stock", nullable = false)
    private Double stock;
    
    /**
     * Lista de productos que contienen este ingrediente.
     * Relación bidireccional con ProductoIngrediente y casacadas PERSIST y MERGE.
     */
    @OneToMany(mappedBy = "ingrediente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 
    private List<ProductoIngrediente> productos = new ArrayList<>();

    /**
     * Constructor vacío por defecto.
     */
    public Ingrediente() {
    }

    /**
     * Constructor que inicializa todos los campos.
     *
     * @param id Identificador del ingrediente.
     * @param nombre Nombre del ingrediente.
     * @param unidadMedida Unidad de medida del ingrediente.
     * @param stock Stock del ingrediente.
     */
    public Ingrediente(Long id, String nombre, UnidadMedida unidadMedida, Double stock) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    /**
     * Constructor que inicializa todos los campos menos el ID.
     *
     * @param nombre Nombre del ingrediente.
     * @param unidadMedida Unidad de medida del ingrediente.
     * @param stock Stock del ingrediente.
     */
    public Ingrediente(String nombre, UnidadMedida unidadMedida, Double stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }
    
    /**
     * Obtiene el ID del ingrediente.
     *
     * @return ID del ingrediente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del ingrediente.
     *
     * @param id ID a asignar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del ingrediente.
     *
     * @return Nombre del ingrediente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del ingrediente.
     *
     * @param nombre Nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la unidad de medida del ingrediente.
     *
     * @return Unidad de medida.
     */
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Establece la unidad de medida del ingrediente.
     *
     * @param unidadMedida Unidad de medida a asignar.
     */
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     * Obtiene la cantidad en stock del ingrediente.
     *
     * @return Stock disponible.
     */
    public Double getStock() {
        return stock;
    }

    /**
     * Establece la cantidad en stock del ingrediente.
     *
     * @param stock Cantidad a asignar.
     */
    public void setStock(Double stock) {
        this.stock = stock;
    }

    /**
     * Obtiene la lista de productos que contienen este ingrediente.
     *
     * @return Lista de ProductoIngrediente.
     */
    public List<ProductoIngrediente> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos relacionados con este ingrediente.
     *
     * @param productos Lista de ProductoIngrediente.
     */
    public void setProductos(List<ProductoIngrediente> productos) {
        this.productos = productos;
    }
    
    /**
     * Agrega un ProductoIngrediente a la lista de productos que utilizan este
     * ingrediente. 
     * 
     * Además, se asegura de establecer correctamente la relación
     * bidireccional, asignando este ingrediente como el dueño del
     * ProductoIngrediente.
     *
     * Este método es útil para mantener sincronizada la relación entre ambas
     * entidades.
     *
     * @param productoIngrediente El objeto ProductoIngrediente que se quiere agregar a la lista.
     */
    public void agregarProductoIngrediente(ProductoIngrediente productoIngrediente) {
        productos.add(productoIngrediente);
        productoIngrediente.setIngrediente(this);
    }

    /**
     * Elimina una instancia de ProductoIngrediente de la lista de productos
     * relacionados con este ingrediente. 
     * 
     * También elimina la referencia a este
     * ingrediente en la instancia de ProductoIngrediente.
     *
     * @param productoIngrediente La instancia de ProductoIngrediente a eliminar.
     */
    public void eliminarProductoIngrediente(ProductoIngrediente productoIngrediente) {
        productos.remove(productoIngrediente);
        productoIngrediente.setIngrediente(null);
    }
    
    /**
     * Representación en forma de cadena del objeto Ingrediente.
     *
     * @return Cadena con los atributos del ingrediente.
     */
    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", stock=" + stock + ", productos=" + productos + '}';
    }
    
}