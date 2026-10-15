package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "conceptopago")
public class ConceptoPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codconp", nullable = false)
    private Integer codconp;

    @Column(name = "nomconp", nullable = false, length = 100)
    private String nomconp;

    @Column(name = "desconp", nullable = true, columnDefinition = "TEXT")
    private String desconp;

    @Column(name = "estconp", nullable = false)
    private Boolean estconp;

    public ConceptoPagoEntity() {}

    public Integer getCodconp() { return codconp; }
    public void setCodconp(Integer codconp) { this.codconp = codconp; }

    public String getNomconp() { return nomconp; }
    public void setNomconp(String nomconp) { this.nomconp = nomconp; }

    public String getDesconp() { return desconp; }
    public void setDesconp(String desconp) { this.desconp = desconp; }

    public Boolean getEstconp() { return estconp; }
    public void setEstconp(Boolean estconp) { this.estconp = estconp; }

}
