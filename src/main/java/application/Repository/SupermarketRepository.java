package application.Repository;

import application.Domain.Entities.Supermarket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermarketRepository extends CrudRepository<Supermarket, Long> {
    Supermarket save(Supermarket supermarket);
    void deleteById(final Long id);
    Supermarket getById(final Long id);
    Iterable<Supermarket> findAll();

}
