package application.Repository;

import application.Model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee save(Employee employee);
    void deleteById(final Long id);
    Employee getById(final Long id);
    Iterable<Employee> findAll();

}
