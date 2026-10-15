package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "gradoinstruccion")
public class GradoInstruccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codgrai", nullable = false)
    private Integer codgrai;

    @Column(name = "nomgrai", nullable = false, length = 50)
    private String nomgrai;

    @Column(name = "estgrai", nullable = false)
    private Boolean estgrai;

    public GradoInstruccionEntity() {}

    public Integer getCodgrai() { return codgrai; }
    public void setCodgrai(Integer codgrai) { this.codgrai = codgrai; }

    public String getNomgrai() { return nomgrai; }
    public void setNomgrai(String nomgrai) { this.nomgrai = nomgrai; }

    public Boolean getEstgrai() { return estgrai; }
    public void setEstgrai(Boolean estgrai) { this.estgrai = estgrai; }

}
