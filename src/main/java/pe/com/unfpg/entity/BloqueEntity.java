package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "bloque")
public class BloqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codblo", nullable = false)
    private Integer codblo;

    @Column(name = "nomblo", nullable = false, length = 20)
    private String nomblo;

    @Column(name = "iniblo", nullable = false)
    private LocalTime iniblo;

    @Column(name = "finblo", nullable = false)
    private LocalTime finblo;

    @Column(name = "estblo", nullable = false)
    private Boolean estblo;

    public BloqueEntity() {}

    public Integer getCodblo() { return codblo; }
    public void setCodblo(Integer codblo) { this.codblo = codblo; }

    public String getNomblo() { return nomblo; }
    public void setNomblo(String nomblo) { this.nomblo = nomblo; }

    public LocalTime getIniblo() { return iniblo; }
    public void setIniblo(LocalTime iniblo) { this.iniblo = iniblo; }

    public LocalTime getFinblo() { return finblo; }
    public void setFinblo(LocalTime finblo) { this.finblo = finblo; }

    public Boolean getEstblo() { return estblo; }
    public void setEstblo(Boolean estblo) { this.estblo = estblo; }

}
