package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tipomatricula")
public class TipoMatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codtipm", nullable = false)
    private Integer codtipm;

    @Column(name = "nomtipm", nullable = false, length = 40)
    private String nomtipm;

    @Column(name = "destipm", nullable = false, length = 300)
    private String destipm;

    @Column(name = "esttipm", nullable = false)
    private Boolean esttipm;

    public TipoMatriculaEntity() {}

    public Integer getCodtipm() { return codtipm; }
    public void setCodtipm(Integer codtipm) { this.codtipm = codtipm; }

    public String getNomtipm() { return nomtipm; }
    public void setNomtipm(String nomtipm) { this.nomtipm = nomtipm; }

    public String getDestipm() { return destipm; }
    public void setDestipm(String destipm) { this.destipm = destipm; }

    public Boolean getEsttipm() { return esttipm; }
    public void setEsttipm(Boolean esttipm) { this.esttipm = esttipm; }

}
