package application.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductId;
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="Brand", nullable = false, length = 50)
    private String brand;
    @Column(name="Category", nullable = false, length = 50)
    private String category;
    @Column(name="ExpirationDate", nullable = false, length = 50)
    private String expirationDate;

    @ManyToMany(mappedBy = "products")
    private List<ShoppingList> shoppingLists = new ArrayList<>(0);


    public Product(int ProductId,String name, String brand, String category, String expirationDate) {
        this.ProductId = ProductId;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.expirationDate = expirationDate;
    }

    public Product() {

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

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

}
