package application.Repository.Implementation;

import application.Model.Client;
import application.Repository.Interface.IClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository implements IClientRepository {
    private List<Client> clientList;

    public ClientRepository(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public void add(Client client) {
        clientList.add(client);
    }

    @Override
    public void deleteById(int id) {
        clientList.remove(id);
    }

    @Override
    public void getById(int id) {
        clientList.get(id);
    }

    @Override
    public List<Client> getAll() {
        return clientList;
    }
}

