package application.Model;

import javax.persistence.*;

@Entity
@Table(name = "Supermarkets")
public class Supermarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SupermarketId;
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="Address", nullable = false, length = 50)
    private String address;

    @OneToOne(mappedBy = "supermarket")
    private Employee employee;

    @OneToOne(mappedBy = "supermarket")
    private Admin admin;

    @OneToOne(mappedBy = "supermarket")
    private Inventory inventory;

    public Supermarket(String name, String address) {
        this.name = name;
        this.address = address;
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


}
