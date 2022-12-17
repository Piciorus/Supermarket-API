package application.Repository;

import application.Domain.Entities.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query(value="SELECT username,password \n" +
            "FROM users \n" +
            "inner join user_role on user_role.user_id=users.id\n" +
            "inner join roles on user_role.role_id=roles.id\n" +
            "where roles.role='admin' ",nativeQuery = true)
    List<Role> findUsernameAndPasswordByRole(String role);

}
