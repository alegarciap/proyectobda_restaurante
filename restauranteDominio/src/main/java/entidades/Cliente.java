package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Entidad que representa a los clientes.
 * @author Leonardo Flores Leyva - 252390 - Responsable de módulo: Clientes
 */
@Entity()
@Table(name="clientes") // Nombre de la tabla en la BD
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia elegida para separar atributos únicos de clases hijas
@DiscriminatorColumn(name = "tipo_cliente", discriminatorType = DiscriminatorType.STRING) // Discriminador STRING para especificar bien cada tipo de cliente.
public abstract class Cliente implements Serializable {
    /**
        ID único de la entidad. Heredada a las clases hijas.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
        Nombre del cliente.
    */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    /**
        Apellido paterno del cliente
    */
    @Column(name = "apellido_paterno", nullable = false, length = 100)
    private String apellidoPaterno;
    /**
     * Apellido materno del cliente
     */
    @Column(name = "apellido_materno", nullable = false, length = 100)
    private String apellidoMaterno;
    /**
     * Correo electrónico del cliente. No es obligatorio.
     */
    @Column(name = "correo", nullable = true, length = 200, unique = true)
    private String correo;
    /**
     * Fecha de registro del cliente en el sistema.
     */
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;
    /**
     * Número de teléfono del cliente.
     */
    @Column(name = "telefono", nullable = false, length = 200, unique = true)
    private String telefono;
    /**
     * Constructor por defecto.
     */
    public Cliente() {}
    /**
     * Constructor con todos los atributos menos el ID.
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param correo Correo electrónico del cliente.
     * @param fechaRegistro Fecha de registro del cliente.
     * @param telefono Teléfono del cliente.
     */
    public Cliente(
            String nombre, 
            String apellidoPaterno, 
            String apellidoMaterno, 
            String correo, 
            LocalDate fechaRegistro, 
            String telefono
    ) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.telefono = telefono;
    }
    /**
     * Constructor con todos los atributos, incluído el ID.
     * @param id ID del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param correo Correo electrónico del cliente.
     * @param fechaRegistro Fecha de registro del cliente.
     * @param telefono Teléfono del cliente. 
     */
    public Cliente(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, LocalDate fechaRegistro, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.telefono = telefono;
    }
    /**
     * Obtiene el ID del cliente.
     * @return ID del cliente.
     */
    public Long getId() {return id;}
    /**
     * Obtiene el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String getNombre() {return nombre;}
    /**
     * Obtiene el apellido paterno del cliente.
     * @return Apellido paterno del cliente.
     */
    public String getApellidoPaterno() {return apellidoPaterno;}
    /**
     * Obtiene el apellido materno del cliente.
     * @return Apellido materno del cliente.
     */
    public String getApellidoMaterno() {return apellidoMaterno;}
    /**
     * Obtiene el correo electrónico del cliente.
     * @return Correo electrónico del cliente.
     */
    public String getCorreo() {return correo;}
    /**
     * Obtiene la fecha de registro del cliente.
     * @return Fecha de registro del cliente.
     */
    public LocalDate getFechaRegistro() {return fechaRegistro;}
    /**
     * Obtiene el número de teléfono del cliente.
     * @return Número de teléfono del cliente.
     */
    public String getTelefono() {return telefono;}
    /**
     * Obtiene el ID del cliente.
     * @param id ID del cliente.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Asigna el nombre del cliente.
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {this.nombre = nombre;}
    /**
     * Asigna el apellido paterno del cliente.
     * @param apellidoPaterno Nuevo apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {this.apellidoPaterno = apellidoPaterno;}
    /**
     * Asigna el apellido materno del cliente.
     * @param apellidoMaterno Nuevo apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {this.apellidoMaterno = apellidoMaterno;}
    /**
     * Asigna el correo electrónico del cliente.
     * @param correo Nuevo correo electrónico del cliente.
     */
    public void setCorreo(String correo) {this.correo = correo;}
    /**
     * Asigna la fecha de registro del cliente.
     * @param fechaRegistro Nueva fecha de registro del cliente.
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {this.fechaRegistro = fechaRegistro;}
    /**
     * Asigna el número de teléfono del cliente.
     * @param telefono Nuevo número de teléfono del cliente.
     */
    public void setTelefono(String telefono) {this.telefono = telefono;}
    /**
     * Devuelve una cadena con los datos relevantes del cliente,
     * con salida formateada.
     * @return Cadena con los datos relevantes de un cliente.
     */
    @Override
    public String toString() {
        return String.format("%s %s %s, %s, %d/%d/%d, %s", // formato de salida 
                this.nombre, 
                this.apellidoPaterno, 
                this.apellidoMaterno, 
                this.correo,
                this.fechaRegistro.getDayOfMonth(),
                this.fechaRegistro.getMonthValue(),
                this.fechaRegistro.getYear(),
                this.telefono);
    }
}