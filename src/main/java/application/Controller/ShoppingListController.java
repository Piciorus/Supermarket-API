package application.Controller;

import application.Domain.Models.ShoppingList.Request.CreateShoppingListRequest;
import application.Domain.Models.ShoppingList.Response.GetShoppingListByIdResponse;
import application.Services.Implementation.ShoppingListService;
import application.Services.Interface.IShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController()
@Component
public class ShoppingListController {
    private final IShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping(path = "/addProductToShoppingList/{id}/{id1}")
    @Async
    public ResponseEntity<String> addProductToShoppingList(@PathVariable UUID id, @PathVariable UUID id1) {
        shoppingListService.addProductToShoppingList(id, id1);
        return ResponseEntity.ok("Product added to shopping list");

    }

    @PostMapping(path = "/createShoppingList/{id}")
    @Async
    public ResponseEntity<String> createShoppingList(@RequestBody CreateShoppingListRequest createShoppingListRequest, @PathVariable UUID id) {
        shoppingListService.createShoppingList(createShoppingListRequest, id);
        return ResponseEntity.ok("Shopping list created");
    }

    @GetMapping(path = "/getShoppingListById/{id}")
    @Async
    public ResponseEntity<GetShoppingListByIdResponse> getShoppingListById(@PathVariable UUID id) {
        return ResponseEntity.ok(shoppingListService.getShoppingListById(id));
    }

    @DeleteMapping(path = "/deleteShoppingList/{id}")
    @Async
    public ResponseEntity<String> deleteShoppingList(@PathVariable UUID id) {
        shoppingListService.deleteShoppingList(id);
        return ResponseEntity.ok("Shopping list deleted");
    }

    @DeleteMapping(path = "/deleteProductFromShoppingList/{id}/{id1}")
    @Async
    public ResponseEntity<String> deleteProductFromShoppingList(@PathVariable UUID id, @PathVariable UUID id1) {
        shoppingListService.deleteProductFromShoppingList(id, id1);
        return ResponseEntity.ok("Product deleted from shopping list");
    }
}
