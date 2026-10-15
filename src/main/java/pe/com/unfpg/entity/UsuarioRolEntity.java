package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "usuariorol")
@IdClass(UsuarioRolId.class)
public class UsuarioRolEntity {
    @Id
    @Column(name = "codusu", nullable = false)
    private Integer codusu;

    @Id
    @Column(name = "codrol", nullable = false)
    private Integer codrol;

    public UsuarioRolEntity() {}

    public Integer getCodusu() { return codusu; }
    public void setCodusu(Integer codusu) { this.codusu = codusu; }

    public Integer getCodrol() { return codrol; }
    public void setCodrol(Integer codrol) { this.codrol = codrol; }

}
