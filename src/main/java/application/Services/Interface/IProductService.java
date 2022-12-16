package application.Services.Interface;

import application.Domain.Entities.Product;
import application.Domain.Models.Product.Request.ProductRequestUpdatePrice;
import application.Domain.Models.Product.Response.ProductResponseGetAll;

import java.util.List;

public interface IProductService {

    Product addProductToSupermarket(Product product,Long id);
    void deleteProductFromSupermarket(Long id);
    Product getProductById(Long id);
    List<ProductResponseGetAll> getAllProductsFromSupermarket(Long id);
    Product updateProductPrice(ProductRequestUpdatePrice productRequestUpdatePrice, Long id);
}
