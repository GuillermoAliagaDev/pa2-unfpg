package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "distrito")
public class DistritoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coddis", nullable = false)
    private Integer coddis;

    @Column(name = "nomdis", nullable = false, length = 50)
    private String nomdis;

    @Column(name = "estdis", nullable = false)
    private Boolean estdis;

    public DistritoEntity() {}

    public Integer getCoddis() { return coddis; }
    public void setCoddis(Integer coddis) { this.coddis = coddis; }

    public String getNomdis() { return nomdis; }
    public void setNomdis(String nomdis) { this.nomdis = nomdis; }

    public Boolean getEstdis() { return estdis; }
    public void setEstdis(Boolean estdis) { this.estdis = estdis; }

}
