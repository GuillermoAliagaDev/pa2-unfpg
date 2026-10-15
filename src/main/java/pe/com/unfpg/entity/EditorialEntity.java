package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "editorial")
public class EditorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codedi", nullable = false)
    private Integer codedi;

    @Column(name = "nomedi", nullable = false, length = 100)
    private String nomedi;

    @Column(name = "estedi", nullable = false)
    private Boolean estedi;

    public EditorialEntity() {}

    public Integer getCodedi() { return codedi; }
    public void setCodedi(Integer codedi) { this.codedi = codedi; }

    public String getNomedi() { return nomedi; }
    public void setNomedi(String nomedi) { this.nomedi = nomedi; }

    public Boolean getEstedi() { return estedi; }
    public void setEstedi(Boolean estedi) { this.estedi = estedi; }

}
