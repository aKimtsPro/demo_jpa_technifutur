package be.bstorm.akimts.repository;

import be.bstorm.akimts.entities.Region;
import be.bstorm.akimts.entities.Supplier;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long>{

    List<Supplier> getFromRegion(String region);

    void vipForInCity(String city);

}
