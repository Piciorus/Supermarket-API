package application.Repository.Interface;

import application.Model.Admin;

import java.util.List;

public interface IAdminRepository {
    void add(Admin admin);
    void deleteById(int id);
    void getById(int id);
    List<Admin> getAll();

}
