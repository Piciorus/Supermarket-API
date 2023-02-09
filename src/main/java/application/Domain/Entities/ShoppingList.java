package application.Domain.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ShoppingLists")
public class ShoppingList extends BaseEntity {
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "shoppinglist_products", joinColumns = @JoinColumn(name = "shoppingList_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>(0);

    public ShoppingList(Set<Product> productList, String name) {
        this.products = productList;
        this.name = name;
    }

    public ShoppingList() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}