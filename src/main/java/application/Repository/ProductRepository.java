package application.Repository;

import application.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product save(Product product);
    void deleteById(final Long id);
    Product getById(final Long id);
    Iterable<Product> findAll();

}
