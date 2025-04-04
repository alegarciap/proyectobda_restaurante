package entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author PC WHITE WOLF
 */
@Entity
@DiscriminatorValue("FRECUENTE")
public class ClienteFrecuente extends Cliente implements Serializable{
    
}