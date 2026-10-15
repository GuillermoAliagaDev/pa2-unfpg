package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "rollms")
public class RolLmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codroll", nullable = false)
    private Integer codroll;

    @Column(name = "nomroll", nullable = false, length = 40)
    private String nomroll;

    @Column(name = "estroll", nullable = false)
    private Boolean estroll;

    public RolLmsEntity() {}

    public Integer getCodroll() { return codroll; }
    public void setCodroll(Integer codroll) { this.codroll = codroll; }

    public String getNomroll() { return nomroll; }
    public void setNomroll(String nomroll) { this.nomroll = nomroll; }

    public Boolean getEstroll() { return estroll; }
    public void setEstroll(Boolean estroll) { this.estroll = estroll; }

}
