package application.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int InventoryId;

    @OneToOne
    @JoinColumn(name="SupermarketId")
    private Supermarket supermarket;

    @ManyToMany
    @JoinTable(name = "InventoryProducts", joinColumns = @JoinColumn(name = "inventory_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products=new ArrayList<>(0);

    public Inventory() {

    }
}
