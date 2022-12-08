package application.Repository.Interface;

import application.Model.Client;

import java.util.List;

public interface IClientRepository {
    void add(Client client);
    void deleteById(int id);
    void getById(int id);
    List<Client> getAll();
}
