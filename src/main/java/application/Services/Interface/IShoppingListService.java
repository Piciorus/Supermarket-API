package application.Services.Interface;

import application.Domain.Entities.ShoppingList;
import application.Domain.Models.ShoppingList.Request.CreateShoppingListRequest;
import application.Domain.Models.ShoppingList.Response.GetShoppingListByIdResponse;

import java.util.UUID;

public interface IShoppingListService {
    void addProductToShoppingList(UUID productId, UUID shoppingListId);
    ShoppingList createShoppingList(CreateShoppingListRequest createShoppingListRequest, UUID userId);
    void deleteShoppingList(UUID id);
    GetShoppingListByIdResponse getShoppingListById(UUID id);

    void deleteProductFromShoppingList(UUID productId, UUID shoppingListId);

}
