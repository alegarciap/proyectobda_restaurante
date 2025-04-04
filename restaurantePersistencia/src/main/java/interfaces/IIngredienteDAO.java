/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Ingrediente;
import javax.persistence.PersistenceException;

/**
 *
 * @author Alejandra García Preciado - 252444
 * Responsable de módulo: Ingredientes
 */
public interface IIngredienteDAO {
    
    public void agregarIngrediente(Ingrediente ingrediente) throws PersistenceException;
    
}
