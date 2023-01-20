package application.Repository;

import application.Domain.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    User save(User user);
    void deleteById(final UUID id);
    User getById(final UUID id);
    Iterable<User> findAll();
    @Query(value="SELECT * FROM users WHERE username=?1",nativeQuery = true)
    User customQuery(String username);
    User findByUsername(String username);
}
