package application.Domain.Entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEntity {
    @Id
    @Column(name = "id")
    @Type(type = "uuid-char")
    public UUID id = UUID.randomUUID();

    @Column(name="CreationDate", nullable = true, length = 50)
    public Date creationDate;
    @Column(name="UpdateDate", nullable = true, length = 50)
    public Date updateDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
}
