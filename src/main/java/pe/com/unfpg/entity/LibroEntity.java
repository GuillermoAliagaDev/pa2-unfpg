package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "libro")
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codlib", nullable = false)
    private Integer codlib;

    @Column(name = "isbnlib", nullable = true, length = 20)
    private String isbnlib;

    @Column(name = "titlib", nullable = false, length = 200)
    private String titlib;

    @Column(name = "autlib", nullable = false, length = 150)
    private String autlib;

    @Column(name = "deslib", nullable = true, length = 300)
    private String deslib;

    @Column(name = "estlib", nullable = false)
    private Boolean estlib;

    @Column(name = "codcatl", nullable = false)
    private Integer codcatl;

    @Column(name = "codedi", nullable = false)
    private Integer codedi;

    public LibroEntity() {}

    public Integer getCodlib() { return codlib; }
    public void setCodlib(Integer codlib) { this.codlib = codlib; }

    public String getIsbnlib() { return isbnlib; }
    public void setIsbnlib(String isbnlib) { this.isbnlib = isbnlib; }

    public String getTitlib() { return titlib; }
    public void setTitlib(String titlib) { this.titlib = titlib; }

    public String getAutlib() { return autlib; }
    public void setAutlib(String autlib) { this.autlib = autlib; }

    public String getDeslib() { return deslib; }
    public void setDeslib(String deslib) { this.deslib = deslib; }

    public Boolean getEstlib() { return estlib; }
    public void setEstlib(Boolean estlib) { this.estlib = estlib; }

    public Integer getCodcatl() { return codcatl; }
    public void setCodcatl(Integer codcatl) { this.codcatl = codcatl; }

    public Integer getCodedi() { return codedi; }
    public void setCodedi(Integer codedi) { this.codedi = codedi; }

}
