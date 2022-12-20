package application.Controller;

import application.Domain.Entities.Product;
import application.Domain.Models.Product.Request.AddProductRequest;
import application.Domain.Models.Product.Request.UpdatePriceProductRequest;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Models.Product.Response.GetProductByIdResponse;
import application.Services.Interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@Component
public class ProductController {
    private IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/addProductToSupermarket/{id}")
    public ResponseEntity<String> addProductToSupermarket(@RequestBody final AddProductRequest productRequestAdd, @PathVariable("id") Long supermarketId)
    {
        productService.addProductToSupermarket(productRequestAdd, supermarketId);
        return ResponseEntity.ok("Product added to supermarket");
    }

    @DeleteMapping(path = "/deleteProductFromSupermarket/{id}")
    public ResponseEntity<String> deleteProductFromSupermarket(@PathVariable("id") Long productId)
    {
        productService.deleteProductFromSupermarket(productId);
        return ResponseEntity.ok("Product deleted from supermarket");
    }

    @GetMapping(path = "/getAllProductsFromSupermarket/{id}")
    public ResponseEntity<List<GetAllProductsResponse>> getAllProductsFromSupermarket(@PathVariable("id") Long supermarketId)
    {
        return ResponseEntity.ok(productService.getAllProductsFromSupermarket(supermarketId));
    }

    @PutMapping(path = "/updateProductPrice/{id}")
    public ResponseEntity<String> updateProductPrice(@RequestBody final UpdatePriceProductRequest productRequestUpdatePrice, @PathVariable("id") Long productId)
    {
        productService.updateProductPrice(productRequestUpdatePrice, productId);
        return ResponseEntity.ok("Product price updated");
    }

    @GetMapping(path = "/getProductById/{id}")
    public ResponseEntity<GetProductByIdResponse> getProductById(@PathVariable("id") Long productId)
    {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

}
