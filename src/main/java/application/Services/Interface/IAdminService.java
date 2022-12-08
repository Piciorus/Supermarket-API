package application.Services.Interface;

import application.Model.Employee;
import application.Model.Supermarket;

import java.util.List;

public interface IAdminService {
    Employee createEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();

    Supermarket createSupermarket(Supermarket supermarket);
    void removeSupermarket(int id);
    Supermarket getSupermarketById(int id);
    List<Supermarket> getAllSupermarkets();
}
