package application.Controller;

import application.Model.Product;
import application.Services.Implementation.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@Component
public class ManagerController {

    private ManagerService managerService;
    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping(path = "/addProduct/{id}")
    public Product addProduct(@RequestBody final Product product, @PathVariable("id") Long supermarketId) {
        return managerService.addProduct(product,supermarketId);
    }

    @DeleteMapping(path = "/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        managerService.deleteProductById(id);
    }

    @GetMapping(path = "/getProduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(managerService.getProductById(id));
    }

    @GetMapping(path = "/getAllProducts")
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        return ResponseEntity.ok(managerService.findAllProducts());
    }
}
