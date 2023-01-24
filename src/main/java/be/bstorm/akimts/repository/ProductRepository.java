package be.bstorm.akimts.repository;

import be.bstorm.akimts.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>{

    List<Product> getUnitPriceBetween(double min, double max);

}
