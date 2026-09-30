package tn.esprit.autoloc.autolocapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import static org.junit.jupiter.api.Assertions.fail;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootTest
public class AgenceTests {

    @Autowired
    private AgenceRepositoryMock agenceRepository;

    @Test
    public void addAgence() {

        // Création de l'agence
        Agence agence = new Agence();
        agence.setNom("Agence ariana");
        agence.setAdresse("1 Rue Hedi");
        agence.setTelephone("71585874");
        agence.setVille("Tunis");

        // Premier véhicule
        Vehicule vehicule1 = new Vehicule();
        vehicule1.setImmatriculation("785414TU96");
        vehicule1.setMarque("Isuzu");
        vehicule1.setModele("DMax");
        vehicule1.setCategorie(CategorieVehicule.SUV);
        vehicule1.setTarifJournalier(new BigDecimal("100"));
        vehicule1.setStatut(StatutVehicule.MAINTENANCE);
        vehicule1.setAgence(agence);

        // Deuxième véhicule
        Vehicule vehicule2 = new Vehicule();
        vehicule2.setImmatriculation("785414TU95");
        vehicule2.setMarque("Toyota");
        vehicule2.setModele("Yaris");
        vehicule2.setCategorie(CategorieVehicule.UTILITAIRE);
        vehicule2.setTarifJournalier(new BigDecimal("80"));
        vehicule2.setStatut(StatutVehicule.DISPONIBLE);
        vehicule2.setAgence(agence);

        // Association des deux véhicules à l'agence
        agence.setVehicules(Arrays.asList(vehicule1, vehicule2));

        // Persistance de l'agence et des véhicules
        agenceRepository.save(agence);
    }
    @Test


    public void loadAgence() {

        Iterable<Agence> agences = agenceRepository.findAll();

        StringBuilder result = new StringBuilder();

        for (Agence agence : agences) {

            result.append(agence.getId())
                    .append(" | ")
                    .append(agence.getNom())
                    .append("\n");

            result.append("Vehicules Count : ")
                    .append(agence.getVehicules().size())
                    .append("\n");

            for (Vehicule vehicule : agence.getVehicules()) {

                result.append("=== ")
                        .append(vehicule.getIdVehicule())
                        .append("|")
                        .append(vehicule.getImmatriculation())
                        .append("\n");
            }
        }

        fail(result.toString());
    }
}

interface AgenceRepositoryMock extends CrudRepository<Agence, Long> {
}