package sk.stuba.fei.uim.oop.assignment3.product;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    ArrayList<Product> findAll();
    Optional<Product> findById(Integer Id);
}
