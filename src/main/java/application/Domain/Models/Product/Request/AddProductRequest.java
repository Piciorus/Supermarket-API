package application.Domain.Models.Product.Request;

import application.Domain.Entities.Supermarket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
public class AddProductRequest {
    private @Getter @Setter String name;
    private @Getter @Setter String brand;
    private @Getter @Setter String category;
    private @Getter @Setter String expirationDate;
    private @Getter @Setter int price;
    private @Getter @Setter Supermarket supermarket;
    private @Getter @Setter Date creationDate;

    public AddProductRequest(String name, String brand, String category, String expirationDate, int price, Supermarket supermarket ) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.expirationDate = expirationDate;
        this.price = price;
        this.supermarket = supermarket;
        this.creationDate = new Date();
    }

}
