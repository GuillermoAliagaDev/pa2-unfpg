package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "metodopago")
public class MetodoPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codmetp", nullable = false)
    private Integer codmetp;

    @Column(name = "nommetp", nullable = false, length = 40)
    private String nommetp;

    @Column(name = "estmetp", nullable = false)
    private Boolean estmetp;

    public MetodoPagoEntity() {}

    public Integer getCodmetp() { return codmetp; }
    public void setCodmetp(Integer codmetp) { this.codmetp = codmetp; }

    public String getNommetp() { return nommetp; }
    public void setNommetp(String nommetp) { this.nommetp = nommetp; }

    public Boolean getEstmetp() { return estmetp; }
    public void setEstmetp(Boolean estmetp) { this.estmetp = estmetp; }

}
