package application.Services.Implementation;

import application.Model.Product;
import application.Model.ShoppingList;
import application.Repository.Implementation.ShoppingListRepository;
import application.Services.Interface.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private ShoppingListRepository shoppingListRepository;

    public ClientService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        shoppingListRepository.add(shoppingList);
        return shoppingList;
    }

    @Override
    public void deleteShoppingList(int id) {
        shoppingListRepository.deleteById(id);
    }

    @Override
    public ShoppingList getShoppingListById(int id) {
        return shoppingListRepository.getById(id);
    }


}
