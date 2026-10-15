package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "pago")
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codpag", nullable = false)
    private Integer codpag;

    @Column(name = "fecpag", nullable = false)
    private LocalDateTime fecpag;

    @Column(name = "montopag", nullable = false, precision = 10, scale = 2)
    private BigDecimal montopag;

    @Column(name = "estpag", nullable = false)
    private Boolean estpag;

    @Column(name = "codordpag", nullable = false)
    private Integer codordpag;

    public PagoEntity() {}

    public Integer getCodpag() { return codpag; }
    public void setCodpag(Integer codpag) { this.codpag = codpag; }

    public LocalDateTime getFecpag() { return fecpag; }
    public void setFecpag(LocalDateTime fecpag) { this.fecpag = fecpag; }

    public BigDecimal getMontopag() { return montopag; }
    public void setMontopag(BigDecimal montopag) { this.montopag = montopag; }

    public Boolean getEstpag() { return estpag; }
    public void setEstpag(Boolean estpag) { this.estpag = estpag; }

    public Integer getCodordpag() { return codordpag; }
    public void setCodordpag(Integer codordpag) { this.codordpag = codordpag; }

}
