package application.Domain.Models.Supermarket.Request;

import java.util.Date;

public class AddSupermarketRequest {
    private String name;
    private String address;

    private Date creationDate;
    public AddSupermarketRequest(String name, String address) {
        this.name = name;
        this.address = address;
        this.creationDate = new Date();
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
