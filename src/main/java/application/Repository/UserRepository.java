package application.Repository;

import application.Domain.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    @Async
    User save(User user);

    @Async
    void deleteById(final UUID id);

    @Async
    User getById(final UUID id);

    @Async
    Iterable<User> findAll();

    @Query(value = "SELECT * FROM users WHERE username=?1", nativeQuery = true)
    @Async
    User customQuery(String username);

    @Async
    User findByUsername(String username);
}
