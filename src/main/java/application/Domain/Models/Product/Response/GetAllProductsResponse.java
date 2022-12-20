package application.Domain.Models.Product.Response;

public class GetAllProductsResponse {
    private String name;
    private String category;

    private int price;

    public GetAllProductsResponse(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public GetAllProductsResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
