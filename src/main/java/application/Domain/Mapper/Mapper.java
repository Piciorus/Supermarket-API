package application.Domain.Mapper;

//import application.Domain.Entities.Employee;
import application.Domain.Entities.Product;
import application.Domain.Entities.Supermarket;
import application.Domain.Entities.User;
import application.Domain.Models.Product.Response.ProductResponseGetAll;
import application.Domain.Models.Supermarket.Request.SupermarketRequestCreate;
import application.Domain.Models.Supermarket.Response.SupermarketResponseGetAll;
import application.Domain.Models.User.Request.UserRequestRegister;
import application.Domain.Models.User.Response.UserResponseGetAllUsers;
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
}
