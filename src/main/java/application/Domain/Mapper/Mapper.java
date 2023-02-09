package application.Domain.Mapper;

import application.Domain.Entities.*;
import application.Domain.Models.Product.Request.AddProductRequest;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Models.Product.Response.GetProductByIdResponse;
import application.Domain.Models.ShoppingList.Response.GetShoppingListByIdResponse;
import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Supermarket.Response.GetAllSupermarketResponse;
import application.Domain.Models.Supermarket.Response.GetSupermarketByIdResponse;
import application.Domain.Models.Task.Request.AddTaskToEmployeeRequest;
import application.Domain.Models.Task.Response.GetAllTasksResponse;
import application.Domain.Models.Task.Response.GetTaskByIdResponse;
import application.Domain.Models.User.Request.RegisterUserRequest;
import application.Domain.Models.User.Response.GetAllUsersResponse;
import application.Domain.Models.User.Response.GetByIdUserResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public User RegisterUserRequestToUser(RegisterUserRequest userRequest) {
        User user = new User();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setUsername(userRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setCnp(userRequest.getCnp());
        user.setPhone(userRequest.getPhone());
        user.setCreationDate(userRequest.getCreationDate());
        return user;
    }

    public GetAllUsersResponse UserToGetAllUsersResponse(User user) {
        GetAllUsersResponse user1 = new GetAllUsersResponse();
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setRole(user.getRoles());
        return user1;
    }

    public GetByIdUserResponse UserToGetByIdUserResponse(User user) {
        GetByIdUserResponse user1 = new GetByIdUserResponse();
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        return user1;
    }

    public Supermarket CreateSupermarketRequestToSupermarket(AddSupermarketRequest supermarketRequest) {
        Supermarket supermarket = new Supermarket();
        supermarket.setName(supermarketRequest.getName());
        supermarket.setAddress(supermarketRequest.getAddress());
        supermarket.setCreationDate(supermarketRequest.getCreationDate());
        return supermarket;
    }

    public GetSupermarketByIdResponse GetSupermarketByIdResponseToSupermarket(Supermarket supermarket) {
        GetSupermarketByIdResponse getSupermarketByIdResponse = new GetSupermarketByIdResponse();
        getSupermarketByIdResponse.setName(supermarket.getName());
        getSupermarketByIdResponse.setAddress(supermarket.getAddress());
        return getSupermarketByIdResponse;
    }

    public GetAllSupermarketResponse SupermarketToGetAllSupermarketResponse(Supermarket supermarket) {
        GetAllSupermarketResponse supermarketResponse = new GetAllSupermarketResponse();
        supermarketResponse.setName(supermarket.getName());
        supermarketResponse.setAddress(supermarket.getAddress());
        return supermarketResponse;
    }

    public GetAllProductsResponse ProductToProductResponse(Product product) {
        GetAllProductsResponse productResponse = new GetAllProductsResponse();
        productResponse.setName(product.getName());
        productResponse.setCategory(product.getCategory());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    public GetProductByIdResponse ProductToGetProductByIdResponse(Product product) {
        GetProductByIdResponse productResponse = new GetProductByIdResponse();
        productResponse.setName(product.getName());
        productResponse.setCategory(product.getCategory());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    public Product AddProductRequestToProduct(AddProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setBrand(productRequest.getBrand());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        product.setExpirationDate(productRequest.getExpirationDate());
        product.setSupermarket(productRequest.getSupermarket());
        product.setCreationDate(productRequest.getCreationDate());
        return product;
    }

    public GetAllTasksResponse TaskToGetAllTasksResponse(Task task) {
        GetAllTasksResponse taskResponse = new GetAllTasksResponse();
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDateToComplete(task.getDateToComplete());
        return taskResponse;
    }

    public GetTaskByIdResponse TaskToGetTaskByIdResponse(Task task) {
        GetTaskByIdResponse taskResponse = new GetTaskByIdResponse();
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDateToComplete(task.getDateToComplete());
        return taskResponse;
    }

    public Task AddTaskToEmployeeRequestToTask(AddTaskToEmployeeRequest taskRequest) {
        Task task = new Task();
        task.setDescription(taskRequest.getDescription());
        task.setCreationDate(taskRequest.getCreationDate());
        task.setDateToComplete(taskRequest.getDateToComplete());
        task.setStatus(taskRequest.isStatus());
        task.setUser(taskRequest.getUser());
        return task;
    }

    public GetShoppingListByIdResponse GetShoppingListByIdResponseToShoppingList(ShoppingList shoppingList) {
        GetShoppingListByIdResponse getShoppingListByIdResponse = new GetShoppingListByIdResponse();
        getShoppingListByIdResponse.setName(shoppingList.getName());
        getShoppingListByIdResponse.setProducts(shoppingList.getProducts());
        return getShoppingListByIdResponse;
    }

}
