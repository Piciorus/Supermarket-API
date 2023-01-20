package application.Repository;

import application.Domain.Entities.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, UUID> {
    ShoppingList save(ShoppingList shoppingList);
    void deleteById(final UUID id);
    ShoppingList getById(final UUID id);
    Iterable<ShoppingList> findAll();
}

