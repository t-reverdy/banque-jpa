package fr.sdv.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="banque")
public class Banque implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NOM")
    private String nom;

    @OneToMany(mappedBy = "banque")
    private Set<Client> clients;
    {
        clients = new HashSet<Client>();
    }

    public Banque() {}

    public Banque(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banque{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
