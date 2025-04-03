package DAO;

import entidades.Comanda;
import entidades.Mesa;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import exception.PersistenciaException;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author ErnestoLpz_252663
 */
public class ComandaDAO {
    private EntityManager entityManager;

    public ComandaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Pendiente a revision
    public Comanda crearNuevaComanda(Mesa mesa) {
        Comanda comanda = new Comanda();
        comanda.setFolio(generarFolio());
        comanda.setFechaHora(LocalDateTime.now());
        comanda.setEstado(EstadoComanda.ABIERTA);
        comanda.setMesa(mesa);
        comanda.setTotalVenta(0.0);
        return comanda;
    }
    
    //Pendiente
    public void agregarComanda(Comanda comanda) throws PersistenciaException {

    }

    //Pendiente a revision
    public Comanda consultarComanda(String folio) throws PersistenciaException {
        try {
            return entityManager.find(Comanda.class, folio);
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar la comanda", e);
        }
    }

    //Pendiente
    public void actualizarComanda(Comanda comanda) throws PersistenciaException {

    }

    //Pendiente a revision
    public void eliminarComanda(String folio) throws PersistenciaException {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Comanda comanda = entityManager.find(Comanda.class, folio);
            if (comanda != null) {
                entityManager.remove(comanda);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw new PersistenciaException("Error al eliminar la comanda", e);
        }
    }

    //Pendiente a revision
    public List<Comanda> listarComandas() throws PersistenciaException {
        try {
            TypedQuery<Comanda> query = entityManager.createQuery("SELECT c FROM Comanda c", Comanda.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar las comandas", e);
        }
    }

    //Pendiente a revision
    public void agregarProductoAComanda(String folioComanda, ProductoComanda productoComanda) throws PersistenciaException {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Comanda comanda = entityManager.find(Comanda.class, folioComanda);
            if (comanda != null) {
                productoComanda.setComanda(comanda);
                comanda.getProductosComanda().add(productoComanda);
                entityManager.merge(comanda);
            }
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) tx.rollback();
            throw new PersistenciaException("Error al agregar el producto a la comanda", e);
        }
    }

    //Pendiente a revision
    public void actualizarProductoDeComanda(String folioComanda, ProductoComanda productoComanda) throws PersistenciaException {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Comanda comanda = entityManager.find(Comanda.class, folioComanda);
            if (comanda != null) {
                for (ProductoComanda pc : comanda.getProductosComanda()) {
                    if (pc.getId().equals(productoComanda.getId())) {
                        pc.setCantidad(productoComanda.getCantidad());
                        pc.setImporteTotal(productoComanda.getImporteTotal());
                        pc.setNotas(productoComanda.getNotas());
                        pc.setPrecioUnitario(productoComanda.getPrecioUnitario());
                        pc.setProducto(productoComanda.getProducto());
                        break;
                    }
                }
                entityManager.merge(comanda);
            }
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) tx.rollback();
            throw new PersistenciaException("Error al actualizar el producto de la comanda", e);
        }
    }

    //Pendiente a revision
    public void eliminarProductoDeComanda(String folioComanda, ProductoComanda productoComanda) throws PersistenciaException {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Comanda comanda = entityManager.find(Comanda.class, folioComanda);
            if (comanda != null) {
                comanda.getProductosComanda().remove(productoComanda);
                entityManager.merge(comanda);
            }
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) tx.rollback();
            throw new PersistenciaException("Error al eliminar el producto de la comanda", e);
        }
    }

    //Pendiente a revision
    public double calcularTotalVenta(Comanda comanda) {
        double total = 0;
        for (ProductoComanda productoComanda : comanda.getProductosComanda()) {
            total += productoComanda.getImporteTotal();
        }
        return total;
    }

    //Pendiente
    public String generarFolio() {
        return "OB-20250408-001"; //puse el return para que no estuviera dando error
    }
}