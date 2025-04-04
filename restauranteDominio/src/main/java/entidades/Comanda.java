/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.EstadoComanda;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author alega
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "folio", nullable = false, unique = true)
    private String folio;
    
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;
    
    @Column(name = "estado_comanda", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoComanda estado;
    
    @Column(name = "tota_venta", nullable = false)
    private Double totalVenta;
    
    // relación many to one con cliente
    
    @ManyToOne(fetch = FetchType.LAZY) // lazy para que no esté cargando la mesa cada que se quiera consultar una comanda
    @JoinColumn(name = "mesa_id") 
    private Mesa mesa;
    
    // cascade type all porque producto comanda no existe sin comanda, por lo mismo se usa orphan removal para eliminar los producto comanda
    // fetch type eager para siempre cargar los productos al solicitar una comanda
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ProductoComanda> productosComanda = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = true)
    private Cliente cliente;

    public Comanda() {
    }

    public Comanda(Long id, String folio, LocalDateTime fechaHora, EstadoComanda estado, Double totalVenta, Mesa mesa) {
        this.id = id;
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.totalVenta = totalVenta;
        this.mesa = mesa;
    }

    public Comanda(String folio, LocalDateTime fechaHora, EstadoComanda estado, Double totalVenta, Mesa mesa) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.totalVenta = totalVenta;
        this.mesa = mesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<ProductoComanda> getProductosComanda() {
        return productosComanda;
    }

    public void setProductosComanda(List<ProductoComanda> productosComanda) {
        this.productosComanda = productosComanda;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", fechaHora=" + fechaHora + ", estado=" + estado + ", totalVenta=" + totalVenta + ", mesa=" + mesa + ", productosComanda=" + productosComanda + '}';
    }
    
}
