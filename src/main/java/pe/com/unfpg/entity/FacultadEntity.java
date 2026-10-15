package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "facultad")
public class FacultadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codfac", nullable = false)
    private Integer codfac;

    @Column(name = "nomfac", nullable = false, length = 50)
    private String nomfac;

    @Column(name = "desfac", nullable = false, columnDefinition = "TEXT")
    private String desfac;

    @Column(name = "estfac", nullable = false)
    private Boolean estfac;

    public FacultadEntity() {}

    public Integer getCodfac() { return codfac; }
    public void setCodfac(Integer codfac) { this.codfac = codfac; }

    public String getNomfac() { return nomfac; }
    public void setNomfac(String nomfac) { this.nomfac = nomfac; }

    public String getDesfac() { return desfac; }
    public void setDesfac(String desfac) { this.desfac = desfac; }

    public Boolean getEstfac() { return estfac; }
    public void setEstfac(Boolean estfac) { this.estfac = estfac; }

}
