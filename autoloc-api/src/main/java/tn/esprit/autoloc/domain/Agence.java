package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String ville;

    @Column(length = 255)
    private String adresse;

    @Column(length = 20)
    private String telephone;

    @OneToMany(
            mappedBy = "agence",
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    private List<Vehicule> vehicules;

    @OneToMany(
            mappedBy = "agence",
            fetch = FetchType.EAGER
    )
    private List<Employe> employes;
}