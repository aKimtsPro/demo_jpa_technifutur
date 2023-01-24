package be.bstorm.akimts.repository;

import be.bstorm.akimts.entities.Product;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<TENTITY, TID> {

    // Create
    void add(TENTITY toInsert);

    // Read
    Optional<TENTITY> get(TID id);
    List<TENTITY> getAll();

    // Update
    void update(TID id, TENTITY entity);

    // Delete
    void remove(TID id);


}
