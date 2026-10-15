package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "ordenpago")
public class OrdenPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codordpag", nullable = false)
    private Integer codordpag;

    @Column(name = "fecordpag", nullable = false)
    private LocalDateTime fecordpag;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "estordpag", nullable = false)
    private Boolean estordpag;

    @Column(name = "nummat", nullable = false)
    private Integer nummat;

    @Column(name = "codconp", nullable = false)
    private Integer codconp;

    @Column(name = "codmetp", nullable = false)
    private Integer codmetp;

    @Column(name = "codestp", nullable = false)
    private Integer codestp;

    public OrdenPagoEntity() {}

    public Integer getCodordpag() { return codordpag; }
    public void setCodordpag(Integer codordpag) { this.codordpag = codordpag; }

    public LocalDateTime getFecordpag() { return fecordpag; }
    public void setFecordpag(LocalDateTime fecordpag) { this.fecordpag = fecordpag; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public Boolean getEstordpag() { return estordpag; }
    public void setEstordpag(Boolean estordpag) { this.estordpag = estordpag; }

    public Integer getNummat() { return nummat; }
    public void setNummat(Integer nummat) { this.nummat = nummat; }

    public Integer getCodconp() { return codconp; }
    public void setCodconp(Integer codconp) { this.codconp = codconp; }

    public Integer getCodmetp() { return codmetp; }
    public void setCodmetp(Integer codmetp) { this.codmetp = codmetp; }

    public Integer getCodestp() { return codestp; }
    public void setCodestp(Integer codestp) { this.codestp = codestp; }

}
