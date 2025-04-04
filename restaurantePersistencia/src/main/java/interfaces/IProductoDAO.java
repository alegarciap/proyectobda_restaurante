package interfaces;

import entidades.Producto;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author ErnestoLpz_252663
 */
public interface IProductoDAO {
    public void agregarProducto(Producto producto) throws PersistenciaException;
    
    public Producto consultarProducto(int id) throws PersistenciaException;
    
    public void deshabilitarProducto(int id) throws PersistenciaException;
    
    public void actualizarPrecio(int idProducto, double nuevoPrecio) throws PersistenciaException;
    
    public List<Producto> listarProductos() throws PersistenciaException;
}
