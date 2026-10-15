package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codusu", nullable = false)
    private Integer codusu;

    @Column(name = "nomusu", nullable = false, length = 50)
    private String nomusu;

    @JsonIgnore
    @Column(name = "clausu", nullable = false, length = 255)
    private String clausu;

    @Column(name = "corusu", nullable = false, length = 100)
    private String corusu;

    @Column(name = "creusu", nullable = true)
    private LocalDateTime creusu;

    @Column(name = "estusu", nullable = false)
    private Boolean estusu;

    @Column(name = "codalu", nullable = true)
    private Integer codalu;

    @Column(name = "coddoc", nullable = true)
    private Integer coddoc;

    @Column(name = "codemp", nullable = true)
    private Integer codemp;

    public UsuarioEntity() {}

    public Integer getCodusu() { return codusu; }
    public void setCodusu(Integer codusu) { this.codusu = codusu; }

    public String getNomusu() { return nomusu; }
    public void setNomusu(String nomusu) { this.nomusu = nomusu; }

    public String getClausu() { return clausu; }
    public void setClausu(String clausu) { this.clausu = clausu; }

    public String getCorusu() { return corusu; }
    public void setCorusu(String corusu) { this.corusu = corusu; }

    public LocalDateTime getCreusu() { return creusu; }
    public void setCreusu(LocalDateTime creusu) { this.creusu = creusu; }

    public Boolean getEstusu() { return estusu; }
    public void setEstusu(Boolean estusu) { this.estusu = estusu; }

    public Integer getCodalu() { return codalu; }
    public void setCodalu(Integer codalu) { this.codalu = codalu; }

    public Integer getCoddoc() { return coddoc; }
    public void setCoddoc(Integer coddoc) { this.coddoc = coddoc; }

    public Integer getCodemp() { return codemp; }
    public void setCodemp(Integer codemp) { this.codemp = codemp; }

}
