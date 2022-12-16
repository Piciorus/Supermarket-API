package application.Repository;

import application.Domain.Entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product save(Product product);
    void deleteById(final Long id);
    Product getById(final Long id);
    Iterable<Product> findAll();

}
