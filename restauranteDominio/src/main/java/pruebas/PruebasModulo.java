package pruebas;

import enums.Disponibilidad;
import entidades.Producto;
import enums.TipoPlatillo;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ErnestoLpz_252663
 */
public class PruebasModulo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Crear ingredientes
//            Ingrediente Ing1 = new Ingrediente("Oregano", 50);
//            Ingrediente Ing2 = new Ingrediente("Pepperoni", 25);
//            em.persist(Ing1);
//            em.persist(Ing2);

            // Crear producto
            Producto pizza = new Producto("Pizza Pepperoni", 150.0, TipoPlatillo.PLATILLO, Disponibilidad.DISPONIBLE, new HashSet<>());
            em.persist(pizza);

            // Relacionar ingredientes con el producto
//            ProductoIngrediente pi1 = new ProductoIngrediente(pizza, Ing1, 100);
//            ProductoIngrediente pi2 = new ProductoIngrediente(pizza, Ing2, 50);
//            em.persist(pi1);
//            em.persist(pi2);
//            
//            pizza.getIngredientes().add(pi1);
//            pizza.getIngredientes().add(pi2);
//            em.merge(pizza);

            em.getTransaction().commit();
            System.out.println("Datos guardados exitosamente :)");

            // Consultar producto
            Producto resultado = em.find(Producto.class, pizza.getId());
            System.out.println(resultado);
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
