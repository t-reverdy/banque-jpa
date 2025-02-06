package fr.sdv.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte implements Serializable {

    @Column(name = "TAUX")
    private double taux;

    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    public AssuranceVie() {}

    public AssuranceVie(String numero, Double solde, double taux, LocalDate dateFin) {
        super(numero, solde);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AssuranceVie{");
        sb.append("taux=").append(taux);
        sb.append(", dateFin=").append(dateFin);
        sb.append('}');
        return sb.toString();
    }
}
