package application.Repository;

import application.Domain.Entities.Supermarket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SupermarketRepository extends CrudRepository<Supermarket, UUID> {
    Supermarket save(Supermarket supermarket);
    void deleteById(final UUID id);
    Supermarket getById(final UUID id);
    Iterable<Supermarket> findAll();

}
