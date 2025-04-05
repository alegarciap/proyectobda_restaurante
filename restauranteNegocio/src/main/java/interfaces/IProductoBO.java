package interfaces;

import DTOs.ProductoDTO;
import exception.NegocioException;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author ErnestoLpz_252663
 */
public interface IProductoBO {

    /**
     * Registra un nuevo producto validando reglas de negocio.
     *
     * @param dto El DTO del producto a registrar.
     * @throws NegocioException Si se incumplen las reglas de negocio.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    void registrarProducto(ProductoDTO dto) throws NegocioException, PersistenciaException;

    /**
     * Lista todos los productos.
     *
     * @return Una lista de DTOs de todos los productos.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    List<ProductoDTO> listarProductos() throws PersistenciaException;

    /**
     * Deshabilita un producto por su ID.
     *
     * @param id El ID del producto a deshabilitar.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    void deshabilitarProducto(int id) throws PersistenciaException;

    /**
     * Actualiza el precio de un producto por su ID.
     *
     * @param idProducto  El ID del producto a actualizar.
     * @param nuevoPrecio El nuevo precio del producto.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     * @throws NegocioException    Si el nuevo precio no es válido.
     */
    void actualizarPrecio(int idProducto, double nuevoPrecio) throws PersistenciaException, NegocioException;
}
