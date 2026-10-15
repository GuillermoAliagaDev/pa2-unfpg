package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "diasemana")
public class DiaSemanaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coddias", nullable = false)
    private Integer coddias;

    @Column(name = "nomdias", nullable = false, length = 20)
    private String nomdias;

    @Column(name = "estdias", nullable = false)
    private Boolean estdias;

    public DiaSemanaEntity() {}

    public Integer getCoddias() { return coddias; }
    public void setCoddias(Integer coddias) { this.coddias = coddias; }

    public String getNomdias() { return nomdias; }
    public void setNomdias(String nomdias) { this.nomdias = nomdias; }

    public Boolean getEstdias() { return estdias; }
    public void setEstdias(Boolean estdias) { this.estdias = estdias; }

}
