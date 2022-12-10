package application.Repository;

import application.Model.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
    Manager save(Manager manager);
    void deleteById(final Long id);
    Manager getById(final Long id);
    Iterable<Manager> findAll();
}
