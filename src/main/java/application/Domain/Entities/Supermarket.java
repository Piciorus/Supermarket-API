package application.Domain.Entities;

//import application.Domain.Entities.Employee;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Supermarkets")
@SQLDelete(sql = "UPDATE supermarkets SET deleted = 1 WHERE id=?")
@Where(clause = "deleted = 0")
public class Supermarket extends BaseEntity {
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "Address", nullable = false, length = 50)
    private String address;
    private boolean deleted;
    @OneToMany(mappedBy = "supermarket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>(0);

    public Supermarket(String name, String address, List<Product> products, boolean deleted) {
        this.name = name;
        this.address = address;
        this.products = products;
        this.deleted = deleted;
    }

    public Supermarket() {

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
