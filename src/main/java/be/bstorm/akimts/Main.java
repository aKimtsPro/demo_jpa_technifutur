package be.bstorm.akimts;

import be.bstorm.akimts.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("northwind");


        EntityManager manager = emf.createEntityManager();

        Customer customer = manager.find(Customer.class, "ALFKI");

        emf.close();
    }
}