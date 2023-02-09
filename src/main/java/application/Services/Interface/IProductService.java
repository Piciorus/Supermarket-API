package application.Services.Interface;

import application.Domain.Entities.Product;
import application.Domain.Models.Product.Request.AddProductRequest;
import application.Domain.Models.Product.Request.UpdatePriceProductRequest;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Models.Product.Response.GetProductByIdResponse;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    @Async
    Product addProductToSupermarket(AddProductRequest productRequestAdd, UUID id);

    @Async
    void deleteProductFromSupermarket(UUID id);

    @Async
    GetProductByIdResponse getProductById(UUID id);

    @Async
    List<GetAllProductsResponse> getAllProductsFromSupermarket(UUID id);

    @Async
    Product updateProductPrice(UpdatePriceProductRequest productRequestUpdatePrice, UUID id);
}
