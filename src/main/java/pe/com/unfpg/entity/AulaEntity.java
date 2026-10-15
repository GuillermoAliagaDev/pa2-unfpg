package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "aula")
public class AulaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codaul", nullable = false)
    private Integer codaul;

    @Column(name = "nomaul", nullable = false, length = 50)
    private String nomaul;

    @Column(name = "capaul", nullable = false)
    private Integer capaul;

    @Column(name = "codubi", nullable = false)
    private Integer codubi;

    @Column(name = "codtipa", nullable = false)
    private Integer codtipa;

    @Column(name = "codesta", nullable = false)
    private Integer codesta;

    public AulaEntity() {}

    public Integer getCodaul() { return codaul; }
    public void setCodaul(Integer codaul) { this.codaul = codaul; }

    public String getNomaul() { return nomaul; }
    public void setNomaul(String nomaul) { this.nomaul = nomaul; }

    public Integer getCapaul() { return capaul; }
    public void setCapaul(Integer capaul) { this.capaul = capaul; }

    public Integer getCodubi() { return codubi; }
    public void setCodubi(Integer codubi) { this.codubi = codubi; }

    public Integer getCodtipa() { return codtipa; }
    public void setCodtipa(Integer codtipa) { this.codtipa = codtipa; }

    public Integer getCodesta() { return codesta; }
    public void setCodesta(Integer codesta) { this.codesta = codesta; }

}
