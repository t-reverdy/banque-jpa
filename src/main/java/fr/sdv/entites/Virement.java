package fr.sdv.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation implements Serializable {

    @Column(name = "BENEFICIAIRE")
    private String beneficiaire;

    public Virement() {}

    public Virement(LocalDate date, double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
