package application.Controller;

import application.Model.Employee;
import application.Model.ShoppingList;
import application.Services.Implementation.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@Component
public class ClientController {
    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientController() {

    }

    @PostMapping(path = "/createShoppingList")
    public ResponseEntity<ShoppingList> createShoppingList(@RequestBody ShoppingList shoppingList) {
        return ResponseEntity.ok(clientService.createShoppingList(shoppingList));
    }

    @GetMapping(path = "/getShoppingListById/{id}")
    public ResponseEntity<ShoppingList> getShoppingListById(@PathVariable("id") final int id) {
        return ResponseEntity.ok(clientService.getShoppingListById(id));
    }

    @DeleteMapping(path = "/deleteShoppingList/{id}")
    public void deleteShoppingList(@PathVariable("id") final int id) {
        clientService.deleteShoppingList(id);
    }



}
