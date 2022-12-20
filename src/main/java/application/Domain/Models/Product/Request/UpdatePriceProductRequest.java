package application.Domain.Models.Product.Request;

import java.util.Date;

public class UpdatePriceProductRequest {
    private int price;

    private Date updateDate;
    public UpdatePriceProductRequest(int price) {
        this.price = price;
        this.updateDate = new Date();
    }

    public UpdatePriceProductRequest() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
