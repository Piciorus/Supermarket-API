package application.Services.Interface;

import application.Domain.Entities.Product;
import application.Domain.Models.Product.Request.AddProductRequest;
import application.Domain.Models.Product.Request.UpdatePriceProductRequest;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Models.Product.Response.GetProductByIdResponse;

import java.util.List;

public interface IProductService {

    Product addProductToSupermarket(AddProductRequest productRequestAdd, Long id);
    void deleteProductFromSupermarket(Long id);
    GetProductByIdResponse getProductById(Long id);
    List<GetAllProductsResponse> getAllProductsFromSupermarket(Long id);
    Product updateProductPrice(UpdatePriceProductRequest productRequestUpdatePrice, Long id);
}
