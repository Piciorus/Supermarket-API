package application.Model;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "supermarket", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products;

    public Supermarket(long id,String name, String address) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
