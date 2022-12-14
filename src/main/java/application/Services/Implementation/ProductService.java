package application.Services.Implementation;

import application.Domain.Entities.Product;
import application.Domain.Entities.Supermarket;
import application.Domain.Models.Product.Request.AddProductRequest;
import application.Domain.Models.Product.Request.UpdatePriceProductRequest;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Mapper.Mapper;
import application.Domain.Models.Product.Response.GetProductByIdResponse;
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
    public Product addProductToSupermarket(AddProductRequest productRequestAdd, Long id) {
        productRequestAdd.setSupermarket(supermarketRepository.getById(id));
        Product product = mapper.AddProductRequestToProduct(productRequestAdd);
        return productRepository.save(product);
    }

    @Override
    public void deleteProductFromSupermarket(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<GetAllProductsResponse> getAllProductsFromSupermarket(Long id) {
        Supermarket supermarket=supermarketRepository.getById(id);
        List<GetAllProductsResponse> list = new ArrayList<>();
        supermarket.getProducts().forEach(product -> {
            list.add(mapper.ProductToProductResponse(product));
        });
        return list;
    }

    @Override
    public GetProductByIdResponse getProductById(Long id) {
        Product product = productRepository.getById(id);
        return mapper.ProductToGetProductByIdResponse(product);
    }

    @Override
    public Product updateProductPrice(UpdatePriceProductRequest productRequestUpdatePrice, Long id) {
        Product productUpdated=productRepository.getById(id);
        productUpdated.setPrice(productRequestUpdatePrice.getPrice());
        productUpdated.setUpdateDate(productRequestUpdatePrice.getUpdateDate());
        return productRepository.save(productUpdated);
    }
}
