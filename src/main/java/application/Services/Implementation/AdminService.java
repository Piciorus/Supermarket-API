package application.Services.Implementation;

import application.Model.Employee;
import application.Model.Supermarket;
import application.Repository.Implementation.AdminRepository;
import application.Repository.Implementation.EmployeeRepository;
import application.Repository.Implementation.SupermarketRepository;
import application.Services.Interface.IAdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    private EmployeeRepository employeeRepository;
    private SupermarketRepository supermarketRepository;

    public AdminService(EmployeeRepository employeeRepository, SupermarketRepository supermarketRepository) {
        this.employeeRepository = employeeRepository;
        this.supermarketRepository = supermarketRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {return employeeRepository.addEmployee(employee);}

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Supermarket createSupermarket(Supermarket supermarket) {
        supermarketRepository.addSupermarket(supermarket);
        return supermarket;
    }

    @Override
    public void removeSupermarket(int id) {
        supermarketRepository.deleteSupermarketById(id);
    }

    @Override
    public Supermarket getSupermarketById(int id) {
        return supermarketRepository.getSupermarketById(id);
    }

    @Override
    public List<Supermarket> getAllSupermarkets() {
        return supermarketRepository.getAllSupermarkets();
    }


}
