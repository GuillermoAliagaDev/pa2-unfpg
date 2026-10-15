package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "areaempleo")
public class AreaEmpleoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codare", nullable = false)
    private Integer codare;

    @Column(name = "nomare", nullable = false, length = 50)
    private String nomare;

    @Column(name = "estare", nullable = false)
    private Boolean estare;

    public AreaEmpleoEntity() {}

    public Integer getCodare() { return codare; }
    public void setCodare(Integer codare) { this.codare = codare; }

    public String getNomare() { return nomare; }
    public void setNomare(String nomare) { this.nomare = nomare; }

    public Boolean getEstare() { return estare; }
    public void setEstare(Boolean estare) { this.estare = estare; }

}
