package application.Repository;

import application.Domain.Entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
    Product save(Product product);
    void deleteById(final UUID id);
    Product getById(final UUID id);
    Iterable<Product> findAll();

}
