package application.Repository;

import application.Model.Admin;
import application.Model.Supermarket;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin save(Admin admin);
    void deleteById(final Long id);
    Admin getById(final Long id);
    Iterable<Admin> findAll();

}
