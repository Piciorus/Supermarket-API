package application.Services.Interface;

import application.Model.Employee;
import application.Model.Supermarket;

import java.util.List;

public interface IAdminService {
    Employee createEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    Iterable<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee, Long id);

    Supermarket createSupermarket(Supermarket supermarket);
    void removeSupermarket(Long id);
    Supermarket getSupermarketById(Long id);
    Iterable<Supermarket> getAllSupermarkets();

    Supermarket updateSupermarket(Supermarket supermarket, Long id);
}
