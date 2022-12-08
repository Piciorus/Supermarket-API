package application.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ClientId;
    @Column(name="Name", nullable = false, length = 50)
    private String Name;
    @Column(name="Surname", nullable = false, length = 50)
    private String Surname;
    @Column(name="Phone", nullable = false, length = 50)
    private String Phone;
    @Column(name="CNP", nullable = false, length = 50)
    private String Cnp;

    @OneToOne
    @JoinColumn(name="UserId")
    private Account account;

    @OneToOne(mappedBy = "client")
    private ShoppingList shoppingList;

    public Client(int clientId, String name, String surname, String phone, String cnp) {
        this.ClientId = clientId;
        this.Name = name;
        this.Surname = surname;
        this.Phone = phone;
        this.Cnp = cnp;
    }

    public Client() {

    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCnp() {
        return Cnp;
    }

    public void setCnp(String cnp) {
        Cnp = cnp;
    }

//    public ShoppingList getShoppingList() {
//        return shoppingList;
//    }
//
//    public void setShoppingList(ShoppingList shoppingList) {
//        this.shoppingList = shoppingList;
//    }
}
