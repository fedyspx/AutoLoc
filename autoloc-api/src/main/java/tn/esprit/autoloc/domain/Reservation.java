package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    @Column(nullable = false, length = 30)
    private String statut;

    @ManyToOne
    private Vehicule vehicule;

    @ManyToOne
    private Client client;

    // Relation Reservation - Contrat
    // La clé étrangère sera créée dans la table reservation
    @OneToOne
    private Contrat contrat;
}