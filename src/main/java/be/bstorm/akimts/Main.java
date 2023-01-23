package be.bstorm.akimts;

import be.bstorm.akimts.entities.Category;
import be.bstorm.akimts.entities.Customer;
import be.bstorm.akimts.entities.Product;
import be.bstorm.akimts.utils.EMFSharer;
import be.bstorm.akimts.utils.ServiceLocator;
import static be.bstorm.akimts.utils.ServiceLocator.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("northwind");

        EntityManager em = emf.createEntityManager();

        // GET ONE
        Product product = em.find( Product.class, 33L );
        System.out.println( product.getName() );
        System.out.println( product.getCategory().getCategoryName() );
        System.out.println( product.getSupplier().getCompanyName() );

        // GET ALL
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> list = query.getResultList();
        list.forEach( p -> System.out.println(p.getName()) );

        // UPDATE
        em.getTransaction().begin();
        product.setQttPerUnit("300g"); // l'entité étant attachée, les infos sont apportées à la db au prochain commit
        em.getTransaction().commit();

        // INSERT
        Category cat = new Category();
        cat.setId( (short)18 );
        cat.setCategoryName("Others");
        cat.setDescription("Products with default category");

        em.getTransaction().begin();
//        em.persist( cat );  // si id != des id déjà présent, sinon exception
        em.merge( cat );    // si id != des id déjà présent, sinon update
        em.getTransaction().commit();

        // DELETE
        em.getTransaction().begin();
        cat = em.merge( cat );
        em.remove( cat );
        em.getTransaction().commit();

        emf.close();


    }
}