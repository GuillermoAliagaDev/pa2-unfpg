package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "detallematricula")
public class DetalleMatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coddet", nullable = false)
    private Integer coddet;

    @Column(name = "estdet", nullable = false)
    private Boolean estdet;

    @Column(name = "nummat", nullable = false)
    private Integer nummat;

    @Column(name = "codsec", nullable = false)
    private Integer codsec;

    public DetalleMatriculaEntity() {}

    public Integer getCoddet() { return coddet; }
    public void setCoddet(Integer coddet) { this.coddet = coddet; }

    public Boolean getEstdet() { return estdet; }
    public void setEstdet(Boolean estdet) { this.estdet = estdet; }

    public Integer getNummat() { return nummat; }
    public void setNummat(Integer nummat) { this.nummat = nummat; }

    public Integer getCodsec() { return codsec; }
    public void setCodsec(Integer codsec) { this.codsec = codsec; }

}
