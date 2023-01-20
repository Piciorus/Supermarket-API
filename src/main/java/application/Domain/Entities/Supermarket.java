package application.Domain.Entities;

//import application.Domain.Entities.Employee;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Supermarkets")
@SQLDelete(sql = "UPDATE supermarkets SET deleted = 1 WHERE id=?")
@Where(clause = "deleted = 0")
public class Supermarket {
//    @Id
//    @Column(columnDefinition = "uniqueidentifier", name = "id")@Id
    @Id
    @Column(name = "id")
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="Address", nullable = false, length = 50)
    private String address;
    @Column(name="CreationDate", nullable = false, length = 50)
    private Date creationDate;
    @Column(name="UpdateDate", nullable = true, length = 50)
    private Date updateDate;
    private boolean deleted;
    @OneToMany(mappedBy = "supermarket", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products=new ArrayList<>(0);

    public Supermarket(String name, String address,List<Product> products,Date creationDate,Date updateDate,boolean deleted) {
        this.name = name;
        this.address = address;
        this.products = products;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
