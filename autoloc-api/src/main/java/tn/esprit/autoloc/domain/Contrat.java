package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateSignature;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private boolean valide;

    @OneToMany(
            mappedBy = "contrat",
            fetch = FetchType.EAGER
    )
    private List<Paiement> paiements;

    // Côté inverse de la relation Reservation - Contrat
    // La clé étrangère reste dans reservation
    @OneToOne(mappedBy = "contrat")
    private Reservation reservation;
}