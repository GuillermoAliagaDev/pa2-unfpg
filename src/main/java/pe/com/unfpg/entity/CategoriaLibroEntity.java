package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "categorialibro")
public class CategoriaLibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcatl", nullable = false)
    private Integer codcatl;

    @Column(name = "nomcatl", nullable = false, length = 40)
    private String nomcatl;

    @Column(name = "estcatl", nullable = false)
    private Boolean estcatl;

    public CategoriaLibroEntity() {}

    public Integer getCodcatl() { return codcatl; }
    public void setCodcatl(Integer codcatl) { this.codcatl = codcatl; }

    public String getNomcatl() { return nomcatl; }
    public void setNomcatl(String nomcatl) { this.nomcatl = nomcatl; }

    public Boolean getEstcatl() { return estcatl; }
    public void setEstcatl(Boolean estcatl) { this.estcatl = estcatl; }

}
