package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tipocalificacion")
public class TipoCalificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codtipc", nullable = false)
    private Integer codtipc;

    @Column(name = "nomtipc", nullable = false, length = 50)
    private String nomtipc;

    @Column(name = "esttipc", nullable = false)
    private Boolean esttipc;

    public TipoCalificacionEntity() {}

    public Integer getCodtipc() { return codtipc; }
    public void setCodtipc(Integer codtipc) { this.codtipc = codtipc; }

    public String getNomtipc() { return nomtipc; }
    public void setNomtipc(String nomtipc) { this.nomtipc = nomtipc; }

    public Boolean getEsttipc() { return esttipc; }
    public void setEsttipc(Boolean esttipc) { this.esttipc = esttipc; }

}
