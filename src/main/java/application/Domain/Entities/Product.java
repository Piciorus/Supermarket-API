package application.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products")
public class Product extends BaseEntity {
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "Brand", nullable = false, length = 50)
    private String brand;
    @Column(name = "Category", nullable = false, length = 50)
    private String category;
    @Column(name = "ExpirationDate", nullable = false, length = 50)
    private String expirationDate;
    @Column(name = "Price", nullable = false, length = 50)
    private int price;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supermarket_id", nullable = true)
    private Supermarket supermarket;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ShoppingList> shoppingLists = new HashSet<>(0);

    public Product(String name, String brand, String category, String expirationDate, int price) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    public Product() {

    }

    private Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(Set<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}
