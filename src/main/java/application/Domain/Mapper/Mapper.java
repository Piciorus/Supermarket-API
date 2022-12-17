package application.Domain.Mapper;

import application.Domain.Entities.Product;
import application.Domain.Entities.Supermarket;
import application.Domain.Entities.User;
import application.Domain.Models.Product.Request.ProductRequestAdd;
import application.Domain.Models.Product.Response.ProductResponseGetAll;
import application.Domain.Models.Supermarket.Request.SupermarketRequestCreate;
import application.Domain.Models.Supermarket.Response.SupermarketResponseGetAll;
import application.Domain.Models.User.Request.UserRequestRegister;
import application.Domain.Models.User.Response.UserResponseGetAllUsers;
import application.Domain.Models.User.Response.UserResponseGetById;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public User UserRequestToUser(UserRequestRegister userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setCnp(userRequest.getCnp());
        user.setPhone(userRequest.getPhone());
        return user;
    }

    public UserResponseGetAllUsers UserToUserResponse(User user){
        UserResponseGetAllUsers user1 = new UserResponseGetAllUsers();
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        return user1;
    }

    public UserResponseGetById UserToUserResponseGetById(User user){
        UserResponseGetById user1 = new UserResponseGetById();
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        return user1;
    }

    public Supermarket SupermarketRequestToSupermarket(SupermarketRequestCreate supermarketRequest){
        Supermarket supermarket = new Supermarket();
        supermarket.setName(supermarketRequest.getName());
        supermarket.setAddress(supermarketRequest.getAddress());
        return supermarket;
    }

    public SupermarketResponseGetAll SupermarketToSupermarketResponse(Supermarket supermarket){
        SupermarketResponseGetAll supermarketResponse = new SupermarketResponseGetAll();
        supermarketResponse.setName(supermarket.getName());
        supermarketResponse.setAddress(supermarket.getAddress());
        return supermarketResponse;
    }

    public ProductResponseGetAll ProductToProductResponse(Product product){
        ProductResponseGetAll productResponse = new ProductResponseGetAll();
        productResponse.setName(product.getName());
        productResponse.setCategory(product.getCategory());
        return productResponse;
    }

    public Product ProductRequestToProduct(ProductRequestAdd productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setBrand(productRequest.getBrand());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        product.setExpirationDate(productRequest.getExpirationDate());
        product.setSupermarket(productRequest.getSupermarket());
        return product;
    }
}
