package application.Services.Interface;

import application.Model.Product;

public interface IManagerService {
    Product addProduct(Product product, Long supermarketId);
    void deleteProductById(final Long id);
    Product getProductById(final Long id);
    Iterable<Product> findAllProducts();
}
