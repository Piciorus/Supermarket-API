package application.Repository;

import application.Domain.Entities.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
    ShoppingList save(ShoppingList shoppingList);
    void deleteById(final Long id);
    ShoppingList getById(final Long id);
    Iterable<ShoppingList> findAll();
}

