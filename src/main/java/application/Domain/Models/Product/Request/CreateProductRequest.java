package application.Domain.Models.Product.Request;

import java.util.Date;

public class CreateProductRequest {
    private final String name;
    private final String brand;
    private final String category;
    private String expirationDate;
    private final int price;

    private Date creationDate;

    public CreateProductRequest(String name, String brand, String category, String expirationDate, int price) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.expirationDate = expirationDate;
        this.price = price;
        this.creationDate = new Date();
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
