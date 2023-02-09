package application.Repository;

import application.Domain.Entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
    @Async
    Product save(Product product);

    @Async
    void deleteById(final UUID id);

    @Async
    Product getById(final UUID id);

    @Async
    Iterable<Product> findAll();

}
