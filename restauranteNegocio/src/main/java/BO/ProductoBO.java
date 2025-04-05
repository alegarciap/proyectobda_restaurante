package BO;

import DAO.ProductoDAO;
import DTOs.ProductoDTO;
import entidades.Producto;
import enums.Disponibilidad;
import exception.NegocioException;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ErnestoLpz_252663
 */
public class ProductoBO {
    private ProductoDAO productoDAO;

    public ProductoBO(EntityManager em) {
        this.productoDAO = new ProductoDAO(em);
    }

    /**
     * Conversión de DTO a Entidad
     */
    private Producto convertirDTOAEntidad(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setTipo(dto.getTipo());
        producto.setDisponibilidad(dto.getDisponibilidad() != null ? dto.getDisponibilidad() : Disponibilidad.HABILITADO);
        return producto;
    }

    /**
     * Conversión de Entidad a DTO
     */
    private ProductoDTO convertirEntidadADTO(Producto p) {
        ProductoDTO productodto = new ProductoDTO();
        productodto.setId(p.getId());
        productodto.setNombre(p.getNombre());
        productodto.setPrecio(p.getPrecio());
        productodto.setTipo(p.getTipo());
        productodto.setDisponibilidad(p.getDisponibilidad());
        return productodto;
    }
    
    /**
     * Registra un nuevo producto validando reglas de negocio
     */
    public void registrarProducto(ProductoDTO dto) throws NegocioException, PersistenciaException {
        validarProducto(dto);

        Producto producto = convertirDTOAEntidad(dto);
        productoDAO.agregarProducto(producto);
    }

    /**
     * Lista todos los productos
     */
    public List<ProductoDTO> listarProductos() throws PersistenciaException {
        List<Producto> productos = productoDAO.listarProductos();
        List<ProductoDTO> listaProductosDTO = new ArrayList<>();

        for (Producto p : productos) {
            listaProductosDTO.add(convertirEntidadADTO(p));
        }

        return listaProductosDTO;
    }

    /**
     * Deshabilita un producto
     */
    public void deshabilitarProducto(int id) throws PersistenciaException {
        productoDAO.deshabilitarProducto(id);
    }

    /**
     * Actualiza el precio de un producto
     */
    public void actualizarPrecio(int idProducto, double nuevoPrecio) throws PersistenciaException, NegocioException {
        if (nuevoPrecio < 0) {
            throw new NegocioException("El precio no puede ser negativo.");
        }

        productoDAO.actualizarPrecio(idProducto, nuevoPrecio);
    }

    /**
     * Validaciones de negocio
     */
    private void validarProducto(ProductoDTO dto) throws NegocioException {
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del producto es obligatorio.");
        }
        if (dto.getPrecio() < 0) {
            throw new NegocioException("El precio no puede ser negativo.");
        }
        if (dto.getTipo() == null) {
            throw new NegocioException("El tipo de platillo es obligatorio.");
        }
    }
}
