package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tipodocumento")
public class TipoDocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codtipd", nullable = false)
    private Integer codtipd;

    @Column(name = "nomtipd", nullable = false, length = 30)
    private String nomtipd;

    @Column(name = "esttipd", nullable = false)
    private Boolean esttipd;

    public TipoDocumentoEntity() {}

    public Integer getCodtipd() { return codtipd; }
    public void setCodtipd(Integer codtipd) { this.codtipd = codtipd; }

    public String getNomtipd() { return nomtipd; }
    public void setNomtipd(String nomtipd) { this.nomtipd = nomtipd; }

    public Boolean getEsttipd() { return esttipd; }
    public void setEsttipd(Boolean esttipd) { this.esttipd = esttipd; }

}
