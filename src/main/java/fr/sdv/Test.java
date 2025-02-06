package fr.sdv;

import fr.sdv.entites.Banque;
import fr.sdv.entites.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Banque banque = new Banque("banque");
        em.persist(banque);

        Client client = new Client("Smith", "John", LocalDate.of(10,10,10),banque);
        banque.getClients().add(client);
        em.persist(client);


        tx.commit();
        em.close();
        emf.close();
    }
}
