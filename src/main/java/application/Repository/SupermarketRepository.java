package application.Repository;

import application.Domain.Entities.Supermarket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SupermarketRepository extends CrudRepository<Supermarket, UUID> {
    @Async
    Supermarket save(Supermarket supermarket);

    @Async
    void deleteById(final UUID id);

    @Async
    Supermarket getById(final UUID id);

    @Async
    Iterable<Supermarket> findAll();

}
