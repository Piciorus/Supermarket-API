package application.Services.Implementation;

import application.Model.Product;
import application.Model.Supermarket;
import application.Repository.ProductRepository;
import application.Repository.SupermarketRepository;
import application.Services.Interface.IManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements IManagerService {

    private ProductRepository productRepository;

    private SupermarketRepository supermarketRepository;

    public ManagerService(ProductRepository productRepository, SupermarketRepository supermarketRepository) {
        this.productRepository = productRepository;
        this.supermarketRepository = supermarketRepository;
    }

    @Override
    public Product addProduct(Product product, Long supermarketId) {
        product.setSupermarket(supermarketRepository.getById(supermarketId));
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
