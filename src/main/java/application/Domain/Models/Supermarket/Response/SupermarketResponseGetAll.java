package application.Domain.Models.Supermarket.Response;

public class SupermarketResponseGetAll {
    private String name;
    private String address;

    public SupermarketResponseGetAll(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public SupermarketResponseGetAll() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
