package application.Domain.Models.Product.Request;

public class ProductRequestUpdatePrice {
    private int price;

    public ProductRequestUpdatePrice(int price) {
        this.price = price;
    }

    public ProductRequestUpdatePrice() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
