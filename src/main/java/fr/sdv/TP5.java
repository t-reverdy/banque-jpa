package fr.sdv;

import fr.sdv.entites.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class TP5 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Banque banque = new Banque("National Bank");
        Client client = new Client("John", "Wick", LocalDate.of(10,10,10), banque);
        Client client2 = new Client("Jane", "Smith", LocalDate.of(10,10,10), banque);
        banque.getClients().add(client);
        banque.getClients().add(client2);

        Compte compte = new Compte("0001", 10000.0);
        compte.getClients().add(client);
        compte.getClients().add(client2);

        AssuranceVie assuranceVie = new AssuranceVie("0002", 1500.0, 1.5, LocalDate.of(10,10,10));
        LivretA livretA = new LivretA("0003", 900.0, 2.0);

        client2.getComptes().add(assuranceVie);
        client2.getComptes().add(livretA);

        Virement virement = new Virement(LocalDate.of(10,10,10), 2000.0, "salire",livretA,  "moi");
        livretA.getOperations().add(virement);

        Operation operation = new Operation(LocalDate.of(10,10,10), 200.0, "frais", compte);
        compte.getOperations().add(operation);

        em.persist(compte);

        System.out.println(compte.getClients());
        System.out.println(compte.getOperations());

        tx.commit();
        em.close();
        emf.close();
    }
}
