package application.Services.Implementation;

import application.Domain.Entities.Product;
import application.Domain.Entities.Supermarket;
import application.Domain.Models.Product.Request.ProductRequestUpdatePrice;
import application.Domain.Models.Product.Response.ProductResponseGetAll;
import application.Domain.Mapper.Mapper;
import application.Repository.ProductRepository;
import application.Repository.SupermarketRepository;
import application.Services.Interface.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private Mapper mapper;
    private ProductRepository productRepository;
    private SupermarketRepository supermarketRepository;

    public ProductService(Mapper mapper, ProductRepository productRepository, SupermarketRepository supermarketRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.supermarketRepository = supermarketRepository;
    }

    @Override
    public Product addProductToSupermarket(Product product,Long id) {
        product.setSupermarket(supermarketRepository.getById(id));
        return productRepository.save(product);
    }

    @Override
    public void deleteProductFromSupermarket(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseGetAll> getAllProductsFromSupermarket(Long id) {
        Supermarket supermarket=supermarketRepository.getById(id);
        List<ProductResponseGetAll> list = new ArrayList<>();
        supermarket.getProducts().forEach(product -> {
            list.add(mapper.ProductToProductResponse(product));
        });
        return list;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Product updateProductPrice(ProductRequestUpdatePrice productRequestUpdatePrice, Long id) {
        Product productUpdated=productRepository.getById(id);
        productUpdated.setPrice(productRequestUpdatePrice.getPrice());
        return productRepository.save(productUpdated);
    }
}
