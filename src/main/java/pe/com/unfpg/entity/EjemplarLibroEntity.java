package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "ejemplarlibro")
public class EjemplarLibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeje", nullable = false)
    private Integer codeje;

    @Column(name = "codlib", nullable = false)
    private Integer codlib;

    @Column(name = "codejemplar", nullable = false, length = 50)
    private String codejemplar;

    @Column(name = "estadoeje", nullable = false, length = 30)
    private String estadoeje;

    @Column(name = "esteje", nullable = false)
    private Boolean esteje;

    public EjemplarLibroEntity() {}

    public Integer getCodeje() { return codeje; }
    public void setCodeje(Integer codeje) { this.codeje = codeje; }

    public Integer getCodlib() { return codlib; }
    public void setCodlib(Integer codlib) { this.codlib = codlib; }

    public String getCodejemplar() { return codejemplar; }
    public void setCodejemplar(String codejemplar) { this.codejemplar = codejemplar; }

    public String getEstadoeje() { return estadoeje; }
    public void setEstadoeje(String estadoeje) { this.estadoeje = estadoeje; }

    public Boolean getEsteje() { return esteje; }
    public void setEsteje(Boolean esteje) { this.esteje = esteje; }

}
