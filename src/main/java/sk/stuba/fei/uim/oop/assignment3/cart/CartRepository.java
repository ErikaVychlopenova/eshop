package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
    Optional<Cart> findById(Integer Id);
}
