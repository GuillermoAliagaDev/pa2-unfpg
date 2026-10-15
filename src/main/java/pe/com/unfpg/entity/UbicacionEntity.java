package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "ubicacion")
public class UbicacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codubi", nullable = false)
    private Integer codubi;

    @Column(name = "nomubi", nullable = false, length = 100)
    private String nomubi;

    @Column(name = "desubi", nullable = true, columnDefinition = "TEXT")
    private String desubi;

    @Column(name = "estubi", nullable = false)
    private Boolean estubi;

    public UbicacionEntity() {}

    public Integer getCodubi() { return codubi; }
    public void setCodubi(Integer codubi) { this.codubi = codubi; }

    public String getNomubi() { return nomubi; }
    public void setNomubi(String nomubi) { this.nomubi = nomubi; }

    public String getDesubi() { return desubi; }
    public void setDesubi(String desubi) { this.desubi = desubi; }

    public Boolean getEstubi() { return estubi; }
    public void setEstubi(Boolean estubi) { this.estubi = estubi; }

}
