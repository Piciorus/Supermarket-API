package application.Domain.Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="Role", nullable = false, length = 50)
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public long  getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
