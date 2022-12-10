package application.Services.Implementation;

import application.Model.Employee;
import application.Model.Supermarket;
import application.Repository.EmployeeRepository;
import application.Repository.SupermarketRepository;
import application.Services.Interface.IAdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    private EmployeeRepository employeeRepository;
    private SupermarketRepository supermarketRepository;

    public AdminService(EmployeeRepository employeeRepository, SupermarketRepository supermarketRepository) {
        this.employeeRepository = employeeRepository;
        this.supermarketRepository = supermarketRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee employeeUpdated = employeeRepository.getById(id);
        employeeUpdated.setName(employee.getName());
        employeeUpdated.setSurname(employee.getSurname());
        employeeUpdated.setSalary(employee.getSalary());
        employeeUpdated.setPhone(employee.getPhone());
        employeeUpdated.setCnp(employee.getCnp());
        return employeeRepository.save(employeeUpdated);

    }

    @Override
    public Supermarket createSupermarket(Supermarket supermarket) {
        return supermarketRepository.save(supermarket);
    }

    @Override
    public void removeSupermarket(Long id) {
        supermarketRepository.deleteById(id);
    }
    @Override
    public Supermarket getSupermarketById(Long id) {
        return supermarketRepository.getById(id);
    }
    @Override
    public Iterable<Supermarket> getAllSupermarkets() {
        return supermarketRepository.findAll();
    }
    @Override
    public Supermarket updateSupermarket(Supermarket supermarket, Long id) {
        Supermarket supermarketUpdated = supermarketRepository.getById(id);
        supermarketUpdated.setName(supermarket.getName());
        supermarketUpdated.setAddress(supermarket.getAddress());
        return supermarketRepository.save(supermarketUpdated);
    }
}
