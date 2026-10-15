package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codrol", nullable = false)
    private Integer codrol;

    @Column(name = "nomrol", nullable = false, length = 40)
    private String nomrol;

    @Column(name = "estrol", nullable = false)
    private Boolean estrol;

    public RolEntity() {}

    public Integer getCodrol() { return codrol; }
    public void setCodrol(Integer codrol) { this.codrol = codrol; }

    public String getNomrol() { return nomrol; }
    public void setNomrol(String nomrol) { this.nomrol = nomrol; }

    public Boolean getEstrol() { return estrol; }
    public void setEstrol(Boolean estrol) { this.estrol = estrol; }

}
