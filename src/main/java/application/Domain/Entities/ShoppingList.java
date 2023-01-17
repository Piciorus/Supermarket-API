package application.Domain.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ShoppingLists")
public class ShoppingList {
    @Id
    @Column(columnDefinition = "uniqueidentifier", name = "id")
    private UUID id;

    @Column(name="CreationDate", nullable = false, length = 50)
    private Date creationDate;

    @Column(name="UpdateDate", nullable = true, length = 50)
    private Date updateDate;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToMany(mappedBy = "shoppingList", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products=new ArrayList<>(0);

    public ShoppingList(List<Product> productList, Date creationDate, Date updateDate) {
        this.products = productList;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public ShoppingList() {

    }

    public List<Product> getShoppingList() {
        return products;
    }

    public void setShoppingList(List<Product> shoppingList) {
        this.products = shoppingList;
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
}