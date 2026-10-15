package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "estadoprestamolibro")
public class EstadoPrestamoLibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codestl", nullable = false)
    private Integer codestl;

    @Column(name = "nomestl", nullable = false, length = 50)
    private String nomestl;

    @Column(name = "estestl", nullable = false)
    private Boolean estestl;

    public EstadoPrestamoLibroEntity() {}

    public Integer getCodestl() { return codestl; }
    public void setCodestl(Integer codestl) { this.codestl = codestl; }

    public String getNomestl() { return nomestl; }
    public void setNomestl(String nomestl) { this.nomestl = nomestl; }

    public Boolean getEstestl() { return estestl; }
    public void setEstestl(Boolean estestl) { this.estestl = estestl; }

}
