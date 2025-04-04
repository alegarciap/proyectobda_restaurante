/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entidades.Ingrediente;
import interfaces.IIngredienteDAO;
import javax.persistence.PersistenceException;

/**
 *
 * @author Alejandra García Preciado - 252444
 * Responsable de módulo: Ingredientes
 */
public class IngredienteDAO implements IIngredienteDAO {
    
    private static IngredienteDAO instanceIngredienteDAO;

    public IngredienteDAO() {
    }
    
    public static IngredienteDAO getInstanceDAO() {
        if (instanceIngredienteDAO == null) {
            instanceIngredienteDAO = new IngredienteDAO();
        }
        return instanceIngredienteDAO;
    }

    @Override
    public void agregarIngrediente(Ingrediente ingrediente) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
