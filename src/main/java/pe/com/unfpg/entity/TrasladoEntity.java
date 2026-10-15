package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "traslado")
public class TrasladoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codtra", nullable = false)
    private Integer codtra;

    @Column(name = "progori", nullable = true, length = 100)
    private String progori;

    @Column(name = "uniori", nullable = true, length = 100)
    private String uniori;

    @Column(name = "esttras", nullable = false)
    private Boolean esttras;

    @Column(name = "nummat", nullable = false)
    private Integer nummat;

    public TrasladoEntity() {}

    public Integer getCodtra() { return codtra; }
    public void setCodtra(Integer codtra) { this.codtra = codtra; }

    public String getProgori() { return progori; }
    public void setProgori(String progori) { this.progori = progori; }

    public String getUniori() { return uniori; }
    public void setUniori(String uniori) { this.uniori = uniori; }

    public Boolean getEsttras() { return esttras; }
    public void setEsttras(Boolean esttras) { this.esttras = esttras; }

    public Integer getNummat() { return nummat; }
    public void setNummat(Integer nummat) { this.nummat = nummat; }

}
