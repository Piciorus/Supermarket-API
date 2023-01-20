package application.Domain.Models.ShoppingList.Response;

import application.Domain.Entities.Product;
import application.Domain.Models.Product.Response.GetAllProductsResponse;

import java.util.List;
import java.util.Set;

public class GetShoppingListByIdResponse {
    private String name;

    private Set<Product> products;

    public GetShoppingListByIdResponse(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public GetShoppingListByIdResponse() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
