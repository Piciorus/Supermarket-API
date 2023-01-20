package application.Domain.Entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ShoppingLists")
public class ShoppingList {
    @Id
    @Column(name = "id")
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="CreationDate", nullable = false, length = 50)
    private Date creationDate;

    @Column(name="UpdateDate", nullable = true, length = 50)
    private Date updateDate;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "shoppinglist_products", joinColumns = @JoinColumn(name = "shoppingList_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products=new HashSet<>(0);

    public ShoppingList(Set<Product> productList, Date creationDate, Date updateDate, String name) {
        this.products = productList;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.name = name;
    }

    public ShoppingList() {

    }

    public UUID getShoppingListId() {
        return id;
    }

    public void setShoppingListId(UUID id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}