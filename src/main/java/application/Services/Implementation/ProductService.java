package application.Services.Implementation;

import application.Domain.Entities.Product;
import application.Domain.Entities.Supermarket;
import application.Domain.Mapper.Mapper;
import application.Domain.Models.Product.Request.AddProductRequest;
import application.Domain.Models.Product.Request.UpdatePriceProductRequest;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Models.Product.Response.GetProductByIdResponse;
import application.Repository.ProductRepository;
import application.Repository.SupermarketRepository;
import application.Services.Interface.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
    private final Mapper mapper;
    private final ProductRepository productRepository;
    private final SupermarketRepository supermarketRepository;

    public ProductService(Mapper mapper, ProductRepository productRepository, SupermarketRepository supermarketRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.supermarketRepository = supermarketRepository;
    }

    @Override
    public Product addProductToSupermarket(AddProductRequest addProductRequest, UUID id) {
        addProductRequest.setSupermarket(supermarketRepository.getById(id));
        Product product = mapper.AddProductRequestToProduct(addProductRequest);
        return productRepository.save(product);
    }

    @Override
    public void deleteProductFromSupermarket(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<GetAllProductsResponse> getAllProductsFromSupermarket(UUID id) {
        Supermarket supermarket = supermarketRepository.getById(id);
        List<GetAllProductsResponse> list = new ArrayList<>();
        supermarket.getProducts().forEach(product -> {
            list.add(mapper.ProductToProductResponse(product));
        });
        return list;
    }

    @Override
    public GetProductByIdResponse getProductById(UUID id) {
        Product product = productRepository.getById(id);
        return mapper.ProductToGetProductByIdResponse(product);
    }

    @Override
    public Product updateProductPrice(UpdatePriceProductRequest updatePriceProductRequest, UUID id) {
        Product productUpdated = productRepository.getById(id);
        productUpdated.setPrice(updatePriceProductRequest.getPrice());
        productUpdated.setUpdateDate(updatePriceProductRequest.getUpdateDate());
        return productRepository.save(productUpdated);
    }

}
