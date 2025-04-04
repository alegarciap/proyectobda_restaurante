package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Entidad que representa a los clientes de tipo frecuente.
 * @author Leonardo Flores Leyva - 252390 - Responsable de módulo: Clientes
 */
@Entity
@DiscriminatorValue("frecuente")
public class ClienteFrecuente extends Cliente implements Serializable{
    /**
     * Puntos de fidelidad del cliente frecuente.
     */
    @Column(name = "puntos_fidelidad", nullable = false)
    private Integer puntosFidelidad;
    /**
     * Gasto total acumulado del cliente frecuente.
     */
    @Column(name = "gasto_total_acumulado", nullable = false)
    private Double gastoTotalAcumulado;
    /**
     * Conteo de visitas al restaurante del cliente frecuente.
     */
    @Column(name = "conteo_visitas", nullable = false)
    private Integer conteoVisitas;
    /**
     * Constructor por defecto.
     */
    public ClienteFrecuente() {}
    /**
     * Constructor con todos los atributos menos el ID.
     * Establece los atributos únicos a 0.
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param correo Correo electrónico del cliente.
     * @param fechaRegistro Fecha de registro del cliente.
     * @param telefono Teléfono del cliente. 
     */
    public ClienteFrecuente(
            String nombre, 
            String apellidoPaterno, 
            String apellidoMaterno, 
            String correo, 
            LocalDate fechaRegistro, 
            String telefono
    ) {
        super(nombre, apellidoPaterno, apellidoMaterno, correo, fechaRegistro, telefono);
        this.conteoVisitas = 0;
        this.gastoTotalAcumulado = 0.0;
        this.puntosFidelidad = 0;
    }

    public ClienteFrecuente(
            Long id, 
            String nombre, 
            String apellidoPaterno, 
            String apellidoMaterno, 
            String correo, 
            LocalDate fechaRegistro, 
            String telefono
    ) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, correo, fechaRegistro, telefono);
        this.conteoVisitas = 0;
        this.gastoTotalAcumulado = 0.0;
        this.puntosFidelidad = 0;
    }
    
    /**
     * Obtiene los puntos de fidelidad del cliente frecuente.
     * @return Puntos de fidelidad del cliente frecuente.
     */
    public Integer getPuntosFidelidad() {return puntosFidelidad;}
    /**
     * Obtiene el gasto total acumulado del cliente frecuente.
     * @return Gasto total acumulado del cliente frecuente.
     */
    public Double getGastoTotalAcumulado() {return gastoTotalAcumulado;}
    /**
     * Obtiene el conteo de visitas del cliente frecuente.
     * @return Conteo de visitas del cliente frecuente.
     */
    public Integer getConteoVisitas() {return conteoVisitas;}
    /**
     * Suma una nueva visita del cliente al restaurante,
     * recibiendo como evidencia el pago de su comanda
     * asociada, a partir de la cual se actualiza el 
     * gasto total acumulado y los puntos de fidelidad.
     * @param pagoComanda 
     */
    public void sumarVisita(Double pagoComanda){
        this.conteoVisitas++; // Incrementa el conteo de visitas en 1.
        this.gastoTotalAcumulado += pagoComanda; // Suma el pago de la nueva comanda al gasto total acumulado
        this.puntosFidelidad = (int) this.gastoTotalAcumulado.doubleValue() / 20;
    }
}