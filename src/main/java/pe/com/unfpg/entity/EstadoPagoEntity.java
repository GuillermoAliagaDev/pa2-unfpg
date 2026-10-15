package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "estadopago")
public class EstadoPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codestp", nullable = false)
    private Integer codestp;

    @Column(name = "nomestp", nullable = false, length = 40)
    private String nomestp;

    @Column(name = "estestp", nullable = false)
    private Boolean estestp;

    public EstadoPagoEntity() {}

    public Integer getCodestp() { return codestp; }
    public void setCodestp(Integer codestp) { this.codestp = codestp; }

    public String getNomestp() { return nomestp; }
    public void setNomestp(String nomestp) { this.nomestp = nomestp; }

    public Boolean getEstestp() { return estestp; }
    public void setEstestp(Boolean estestp) { this.estestp = estestp; }

}
