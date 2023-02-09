package application.Repository;

import application.Domain.Entities.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, UUID> {
    @Async
    ShoppingList save(ShoppingList shoppingList);

    @Async
    void deleteById(final UUID id);

    @Async
    ShoppingList getById(final UUID id);

    @Async
    Iterable<ShoppingList> findAll();
}

