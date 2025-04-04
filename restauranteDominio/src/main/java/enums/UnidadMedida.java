/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 * Clase enum que representa las diferentes unidades de medida que 
 * tienen los ingrediente.
 *
 * Se utiliza para establecer la unidad en la que se mide el stock 
 * de un ingrediente.
 *
 * @author Alejandra García Preciado - 252444
 * Responsable de módulo: Ingredientes
 */
public enum UnidadMedida {
    
    /**
     * Unidad para contar ingredientes individuales o enteros.
     */
    PIEZAS, 
    
    /**
     * Unidad para ingredientes sólidos o en polvo.
     */
    GRAMOS, 
    
    /**
     * Unidad para ingredientes líquidos.
     */
    MILILITROS;   
}
