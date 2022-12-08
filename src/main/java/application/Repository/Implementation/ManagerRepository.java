package application.Repository.Implementation;

import application.Model.Manager;
import application.Repository.Interface.IManagerRepository;

import java.util.List;

public class ManagerRepository implements IManagerRepository {
    private List<Manager> managers;

    @Override
    public void add(Manager manager) {
        managers.add(manager);
    }

    @Override
    public void deleteById(int id) {
        managers.remove(id);
    }

    @Override
    public Manager getById(int id) {
        return managers.get(id);
    }

    @Override
    public List<Manager> getAll() {
        return managers;
    }
}

