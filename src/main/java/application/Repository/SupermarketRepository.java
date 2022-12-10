package application.Repository;

import application.Model.Supermarket;
import org.springframework.data.repository.CrudRepository;

public interface SupermarketRepository extends CrudRepository<Supermarket, Long> {
    Supermarket save(Supermarket supermarket);
    void deleteById(final Long id);
    Supermarket getById(final Long id);
    Iterable<Supermarket> findAll();

}
