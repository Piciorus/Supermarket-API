package application.Domain.Models.Product.Request;

import application.Domain.Entities.Supermarket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestAdd {
    private @Getter @Setter String name;
    private @Getter @Setter String brand;
    private @Getter @Setter String category;
    private @Getter @Setter String expirationDate;
    private @Getter @Setter int price;
    private @Getter @Setter Supermarket supermarket;

}
