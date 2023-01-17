package application.Domain.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(columnDefinition = "uniqueidentifier", name = "id")
    private UUID id;
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="Brand", nullable = false, length = 50)
    private String brand;
    @Column(name="Category", nullable = false, length = 50)
    private String category;
    @Column(name="ExpirationDate", nullable = false, length = 50)
    private String expirationDate;

    @Column(name="Price", nullable = false, length = 50)
    private int price;
    @Column(name="CreationDate", nullable = false, length = 50)
    private Date creationDate;
    @Column(name="UpdateDate", nullable = true, length = 50)
    private Date updateDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supermarket_id", nullable = true)
    private Supermarket supermarket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shoppingList_id", nullable = true)
    private ShoppingList shoppingList;
    public Product(String name, String brand, String category, String expirationDate, int price, Date creationDate, Date updateDate) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.expirationDate = expirationDate;
        this.price = price;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
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

    public UUID getProductId() {
        return id;
    }

    public void setProductId(UUID ProductId) {
        this.id = ProductId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
