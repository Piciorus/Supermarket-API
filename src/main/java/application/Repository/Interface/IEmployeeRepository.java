package application.Repository.Interface;

import application.Model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    Employee addEmployee(Employee employee);
    void deleteEmployeeById(int id);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
}
