package application.Services.Interface;

import application.Model.Product;
import application.Model.ShoppingList;
import application.Model.Task;

import java.util.List;

public interface IClientService {
    ShoppingList createShoppingList(ShoppingList shoppingList);
    void deleteShoppingList(int id);
    ShoppingList getShoppingListById(int id);

}
