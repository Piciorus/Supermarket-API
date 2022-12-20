package application.Domain.Entities;

//import application.Domain.Entities.Employee;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Supermarkets")
public class Supermarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="Address", nullable = false, length = 50)
    private String address;
    @Column(name="CreationDate", nullable = false, length = 50)
    private Date creationDate;
    @Column(name="UpdateDate", nullable = true, length = 50)
    private Date updateDate;

    @OneToMany(mappedBy = "supermarket", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products;

    public Supermarket(long id,String name, String address,List<Product> products,Date creationDate,Date updateDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.products = products;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
