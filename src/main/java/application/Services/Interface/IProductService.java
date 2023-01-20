package application.Services.Interface;

import application.Domain.Entities.Product;
import application.Domain.Models.Product.Request.AddProductRequest;
import application.Domain.Models.Product.Request.CreateProductRequest;
import application.Domain.Models.Product.Request.UpdatePriceProductRequest;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Models.Product.Response.GetProductByIdResponse;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    Product addProductToSupermarket(AddProductRequest productRequestAdd, UUID id);
    void deleteProductFromSupermarket(UUID id);
    GetProductByIdResponse getProductById(UUID id);
    List<GetAllProductsResponse> getAllProductsFromSupermarket(UUID id);
    Product updateProductPrice(UpdatePriceProductRequest productRequestUpdatePrice, UUID id);
}
