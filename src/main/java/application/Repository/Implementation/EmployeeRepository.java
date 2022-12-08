package application.Repository.Implementation;

import application.Model.Employee;
import application.Repository.Interface.IEmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeRepository implements IEmployeeRepository {
    private List<Employee> employeeList;

    public EmployeeRepository(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeList.remove(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeList.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

}
