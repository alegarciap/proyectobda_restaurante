package DTOs;

/**
 * Clase de Transferencia de Datos (DTO) para representar la relación entre un
 * Producto y un Ingrediente, incluyendo la cantidad requerida de dicho ingrediente
 * para ese producto específico
 *
 * @author ErnestoLpz_252663
 */
public class ProductoIngredienteDTO {
    private Long id;
    private Double cantidadRequerida;
    private IngredienteDTO ingrediente;
    private ProductoDTO producto;

    /**
     * Obtiene el ID único de esta relación Producto-Ingrediente
     *
     * @return El ID de la relación
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID único de esta relación Producto-Ingrediente
     *
     * @param id El ID de la relación a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la cantidad requerida del ingrediente para este producto
     *
     * @return La cantidad requerida del ingrediente
     */
    public Double getCantidadRequerida() {
        return cantidadRequerida;
    }

    /**
     * Establece la cantidad requerida del ingrediente para este producto
     *
     * @param cantidadRequerida La cantidad requerida del ingrediente a establecer
     */
    public void setCantidadRequerida(Double cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    /**
     * Obtiene el DTO del ingrediente asociado a este producto
     *
     * @return El DTO del ingrediente
     */
    public IngredienteDTO getIngrediente() {
        return ingrediente;
    }

    /**
     * Establece el DTO del ingrediente asociado a este producto
     *
     * @param ingrediente El DTO del ingrediente a establecer
     */
    public void setIngrediente(IngredienteDTO ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * Obtiene el DTO del producto al que pertenece este ingrediente
     *
     * @return El DTO del producto
     */
    public ProductoDTO getProducto() {
        return producto;
    }

    /**
     * Establece el DTO del producto al que pertenece este ingrediente
     *
     * @param producto El DTO del producto a establecer
     */
    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    /**
     * Constructor por defecto de la clase ProductoIngredienteDTO
     */
    public ProductoIngredienteDTO() {
    }

    /**
     * Constructor de la clase ProductoIngredienteDTO que inicializa todos los atributos.
     *
     * @param id El id de la relación Producto-Ingrediente
     * @param cantidadRequerida La cantidad requerida del ingrediente
     * @param ingrediente El DTO del ingrediente asociado
     * @param producto El DTO del producto asociado
     */
    public ProductoIngredienteDTO(Long id, Double cantidadRequerida, IngredienteDTO ingrediente, ProductoDTO producto) {
        this.id = id;
        this.cantidadRequerida = cantidadRequerida;
        this.ingrediente = ingrediente;
        this.producto = producto;
    }

    /**
     * Constructor de la clase ProductoIngredienteDTO que inicializa los atributos principales (sin ID).
     *
     * @param cantidadRequerida La cantidad requerida del ingrediente
     * @param ingrediente El DTO del ingrediente asociado
     * @param producto El DTO del producto asociado
     */
    public ProductoIngredienteDTO(Double cantidadRequerida, IngredienteDTO ingrediente, ProductoDTO producto) {
        this.cantidadRequerida = cantidadRequerida;
        this.ingrediente = ingrediente;
        this.producto = producto;
    }

    /**
     * Devuelve una representación en cadena del objeto ProductoIngredienteDTO
     *
     * @return Una cadena que representa el objeto ProductoIngredienteDTO, incluyendo sus atributos
     */
    @Override
    public String toString() {
        return "ProductoIngredienteDTO{" + "id=" + id + ", cantidadRequerida=" + cantidadRequerida + ", ingrediente=" + ingrediente + ", producto=" + producto + '}';
    }
}