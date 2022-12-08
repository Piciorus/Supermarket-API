package application.Repository.Interface;

import application.Model.Manager;

import java.util.List;

public interface IManagerRepository {
    void add(Manager manager);
    void deleteById(int id);
    Manager getById(int id);
    List<Manager> getAll();
}

