/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author alega
 */
@Entity
public class ProductoComanda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name = "importe_total", nullable = false)
    private Double importeTotal;
    
    @Column(name = "notas", length = 200)
    private String notas;
    
    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;
    
    @ManyToOne
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    public ProductoComanda() {
    }

    public ProductoComanda(Long id, Integer cantidad, Double importeTotal, String notas, Double precioUnitario, Comanda comanda, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
        this.notas = notas;
        this.precioUnitario = precioUnitario;
        this.comanda = comanda;
        this.producto = producto;
    }

    public ProductoComanda(Integer cantidad, Double importeTotal, String notas, Double precioUnitario, Comanda comanda, Producto producto) {
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
        this.notas = notas;
        this.precioUnitario = precioUnitario;
        this.comanda = comanda;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.cantidad);
        hash = 67 * hash + Objects.hashCode(this.importeTotal);
        hash = 67 * hash + Objects.hashCode(this.notas);
        hash = 67 * hash + Objects.hashCode(this.precioUnitario);
        hash = 67 * hash + Objects.hashCode(this.comanda);
        hash = 67 * hash + Objects.hashCode(this.producto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoComanda other = (ProductoComanda) obj;
        if (!Objects.equals(this.notas, other.notas)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.importeTotal, other.importeTotal)) {
            return false;
        }
        if (!Objects.equals(this.precioUnitario, other.precioUnitario)) {
            return false;
        }
        if (!Objects.equals(this.comanda, other.comanda)) {
            return false;
        }
        return Objects.equals(this.producto, other.producto);
    }

    @Override
    public String toString() {
        return "ProductoComanda{" + "id=" + id + ", cantidad=" + cantidad + ", importeTotal=" + importeTotal + ", notas=" + notas + ", precioUnitario=" + precioUnitario + ", comanda=" + comanda + ", producto=" + producto + '}';
    }
    
}
