package application.Repository;

import application.Domain.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
    void deleteById(final Long id);
    User getById(final Long id);
    Iterable<User> findAll();

    @Query(value="SELECT * FROM users WHERE username=?1",nativeQuery = true)
    User customQuery(String username);
}
