package be.bstorm.akimts;

import be.bstorm.akimts.entities.Category;
import be.bstorm.akimts.entities.Customer;
import be.bstorm.akimts.entities.Product;
import be.bstorm.akimts.repository.ProductRepository;
import be.bstorm.akimts.repository.SupplierRepository;
import be.bstorm.akimts.repository.impl.ProductRepositoryImpl;
import be.bstorm.akimts.repository.impl.SupplierRepositoryImpl;
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

        SupplierRepository repository = new SupplierRepositoryImpl();

        repository.vipForInCity("Montréal");

        EMFSharer.getInstance().close();
    }
}