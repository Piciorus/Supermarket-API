package application.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ShoppingLists")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ShoppingListId;

    @OneToOne
    @JoinColumn(name="ClientId")
    private Client client;
    @ManyToMany
    @JoinTable(name = "ShoppingListProducts", joinColumns = @JoinColumn(name = "shopping_list_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products=new ArrayList<>(0);

    public ShoppingList(int ShoppingListId,List<Product> productList) {
        this.ShoppingListId = ShoppingListId;
        this.products = productList;
    }

    public ShoppingList() {

    }

    public List<Product> getShoppingList() {
        return products;
    }

    public void setShoppingList(List<Product> shoppingList) {
        this.products = shoppingList;
    }

    public int getShoppingListId() {
        return ShoppingListId;
    }

    public void setShoppingListId(int ShoppingListId) {
        this.ShoppingListId = ShoppingListId;
    }
}
