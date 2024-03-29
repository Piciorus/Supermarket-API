package application.Controller;

import application.Domain.Models.Product.Request.AddProductRequest;
import application.Domain.Models.Product.Request.UpdatePriceProductRequest;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Models.Product.Response.GetProductByIdResponse;
import application.Services.Interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController()
@Component
public class ProductController {
    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/addProductToSupermarket/{id}")
    @Async
    public ResponseEntity<String> addProductToSupermarket(@RequestBody final AddProductRequest addProductRequest, @PathVariable("id") UUID supermarketId) {
        productService.addProductToSupermarket(addProductRequest, supermarketId);
        return ResponseEntity.ok("Product added to supermarket");
    }

    @DeleteMapping(path = "/deleteProductFromSupermarket/{id}")
    @Async
    public ResponseEntity<String> deleteProductFromSupermarket(@PathVariable("id") UUID productId) {
        productService.deleteProductFromSupermarket(productId);
        return ResponseEntity.ok("Product deleted from supermarket");
    }

    @GetMapping(path = "/getAllProductsFromSupermarket/{id}")
    @Async
    public ResponseEntity<List<GetAllProductsResponse>> getAllProductsFromSupermarket(@PathVariable("id") UUID supermarketId) {
        return ResponseEntity.ok(productService.getAllProductsFromSupermarket(supermarketId));
    }

    @PutMapping(path = "/updateProductPrice/{id}")
    @Async
    public ResponseEntity<String> updateProductPrice(@RequestBody final UpdatePriceProductRequest updatePriceProductRequest, @PathVariable("id") UUID productId) {
        productService.updateProductPrice(updatePriceProductRequest, productId);
        return ResponseEntity.ok("Product price updated");
    }

    @GetMapping(path = "/getProductById/{id}")
    @Async
    public ResponseEntity<GetProductByIdResponse> getProductById(@PathVariable("id") UUID productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping(path = "/getAllProducts")
    @Async
    public ResponseEntity<List<GetAllProductsResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


}
