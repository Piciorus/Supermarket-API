package application.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="Brand", nullable = false, length = 50)
    private String brand;
    @Column(name="Category", nullable = false, length = 50)
    private String category;
    @Column(name="ExpirationDate", nullable = true, length = 50)
    private String expirationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supermarket_id", nullable = false)
    private Supermarket supermarket;
    public Product(int id,String name, String brand, String category, String expirationDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.expirationDate = expirationDate;
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

    public long getProductId() {
        return id;
    }

    public void setProductId(long ProductId) {
        this.id = ProductId;
    }

}
