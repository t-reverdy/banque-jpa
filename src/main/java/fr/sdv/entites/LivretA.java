package fr.sdv.entites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte implements Serializable {

    @Column(name = "TAUX")
    private double taux;

    public LivretA() {}

    public LivretA(String numero, Double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LivretA{");
        sb.append("taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
