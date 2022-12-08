package application.Repository.Implementation;

import application.Model.ShoppingList;
import application.Repository.Interface.IShoppingListRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingListRepository implements IShoppingListRepository {

    private List<ShoppingList> shoppingList;

    @Override
    public void add(ShoppingList shoppingList) {
        this.shoppingList.add(shoppingList);
    }

    @Override
    public void deleteById(int id) {
        shoppingList.remove(id);
    }

    @Override
    public ShoppingList getById(int id) {
        return shoppingList.get(id);
    }

    @Override
    public List<ShoppingList> getAll() {
        return shoppingList;
    }
}
