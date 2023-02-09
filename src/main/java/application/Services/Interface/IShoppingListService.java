package application.Services.Interface;

import application.Domain.Entities.ShoppingList;
import application.Domain.Models.ShoppingList.Request.CreateShoppingListRequest;
import application.Domain.Models.ShoppingList.Response.GetShoppingListByIdResponse;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;

public interface IShoppingListService {
    @Async
    void addProductToShoppingList(UUID productId, UUID shoppingListId);

    @Async
    ShoppingList createShoppingList(CreateShoppingListRequest createShoppingListRequest, UUID userId);

    @Async
    void deleteShoppingList(UUID id);

    @Async
    GetShoppingListByIdResponse getShoppingListById(UUID id);

    @Async
    void deleteProductFromShoppingList(UUID productId, UUID shoppingListId);

}
