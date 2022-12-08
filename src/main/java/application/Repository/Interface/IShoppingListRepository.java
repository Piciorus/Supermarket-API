package application.Repository.Interface;

import application.Model.ShoppingList;

import java.util.List;

public interface IShoppingListRepository {
    void add(ShoppingList shoppingList);
    void deleteById(int id);
    ShoppingList getById(int id);
    List<ShoppingList> getAll();
}
