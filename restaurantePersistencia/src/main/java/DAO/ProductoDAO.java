package DAO;

import entidades.Producto;
import enums.Disponibilidad;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author ErnestoLpz_252663
 */
public class ProductoDAO {
    private EntityManager entityManager;

    public ProductoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ProductoDAO() {
    }

    public void agregarProducto(Producto producto) throws PersistenciaException {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(producto);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) 
                tx.rollback();
            throw new PersistenciaException("Error al agregar el producto", e);
        }
    }

    public Producto consultarProducto(int id) throws PersistenciaException {
        try {
            return entityManager.find(Producto.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el producto", e);
        }
    }
    
    public void deshabilitarProducto(int id) throws PersistenciaException {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Producto producto = entityManager.find(Producto.class, id);
            if (producto != null) {
                producto.setDisponibilidad(Disponibilidad.DESHABILITADO);
                entityManager.merge(producto);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) 
                tx.rollback();
            throw new PersistenciaException("Error al deshabilitar el producto", e);
        }
    }
    
    public void actualizarPrecio(int idProducto, double nuevoPrecio) throws PersistenciaException {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Producto producto = entityManager.find(Producto.class, idProducto);
            if (producto != null) {
                producto.setPrecio(nuevoPrecio);
                entityManager.merge(producto);
            }
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) 
                tx.rollback();
            throw new PersistenciaException("Error al actualizar el precio", e);
        }
    }
    
    public List<Producto> listarProductos() throws PersistenciaException {
        try {
            TypedQuery<Producto> query = entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar productos", e);
        }
    }
}