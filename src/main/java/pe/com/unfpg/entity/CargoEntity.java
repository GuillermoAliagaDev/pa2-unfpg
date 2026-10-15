package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "cargo")
public class CargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcar", nullable = false)
    private Integer codcar;

    @Column(name = "nomcar", nullable = false, length = 50)
    private String nomcar;

    @Column(name = "estcar", nullable = false)
    private Boolean estcar;

    public CargoEntity() {}

    public Integer getCodcar() { return codcar; }
    public void setCodcar(Integer codcar) { this.codcar = codcar; }

    public String getNomcar() { return nomcar; }
    public void setNomcar(String nomcar) { this.nomcar = nomcar; }

    public Boolean getEstcar() { return estcar; }
    public void setEstcar(Boolean estcar) { this.estcar = estcar; }

}
