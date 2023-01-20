package application.Services.Implementation;

import application.Domain.Entities.Product;
import application.Domain.Entities.ShoppingList;
import application.Domain.Entities.Supermarket;
import application.Domain.Entities.User;
import application.Domain.Mapper.Mapper;
import application.Domain.Models.Product.Response.GetAllProductsResponse;
import application.Domain.Models.ShoppingList.Request.CreateShoppingListRequest;
import application.Domain.Models.ShoppingList.Response.GetShoppingListByIdResponse;
import application.Repository.ProductRepository;
import application.Repository.ShoppingListRepository;
import application.Repository.UserRepository;
import application.Services.Interface.IShoppingListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListService implements IShoppingListService {
    private ProductRepository productRepository;

    private UserRepository userRepository;

    private Mapper mapper;
    private ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ProductRepository productRepository, ShoppingListRepository shoppingListRepository, UserRepository userRepository, Mapper mapper) {
        this.productRepository = productRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }
    @Override
    public void addProductToShoppingList(UUID productId, UUID shoppingListId) {
        Product product=productRepository.getById(productId);
        ShoppingList shoppingList=shoppingListRepository.getById(shoppingListId);
        product.getShoppingLists().add(shoppingList);
        shoppingList.getProducts().add(product);
        productRepository.save(product);
        shoppingListRepository.save(shoppingList);

    }
    @Override
    public ShoppingList createShoppingList(CreateShoppingListRequest createShoppingListRequest, UUID userId) {
        ShoppingList shoppingList=new ShoppingList();
        shoppingList.setName(createShoppingListRequest.getName());
        shoppingList.setCreationDate(createShoppingListRequest.getCreationDate());
        User user = userRepository.getById(userId);
        shoppingList.setUser(user);
        return shoppingListRepository.save(shoppingList);
    }

    @Override
    public void deleteShoppingList(UUID id) {
        shoppingListRepository.deleteById(id);
    }
    @Override
    public GetShoppingListByIdResponse getShoppingListById(UUID id) {
        ShoppingList shoppingList=shoppingListRepository.getById(id);
        return mapper.GetShoppingListByIdResponseToShoppingList(shoppingList);
    }

    @Override
    public void deleteProductFromShoppingList(UUID productId, UUID shoppingListId) {
        Product product=productRepository.getById(productId);
        ShoppingList shoppingList=shoppingListRepository.getById(shoppingListId);
        product.getShoppingLists().remove(shoppingList);
        shoppingList.getProducts().remove(product);
        productRepository.save(product);
        shoppingListRepository.save(shoppingList);
    }


}
