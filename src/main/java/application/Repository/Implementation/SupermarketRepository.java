package application.Repository.Implementation;

import application.Model.Employee;
import application.Model.Supermarket;
import application.Repository.Interface.ISupermarketRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupermarketRepository implements ISupermarketRepository {
    private List<Supermarket> supermarketList;

    public SupermarketRepository(List<Supermarket> supermarketList) {
        this.supermarketList = supermarketList;
    }

    @Override
    public void addSupermarket(Supermarket supermarket) {
        supermarketList.add(supermarket);
    }

    @Override
    public void deleteSupermarketById(int id) {
        supermarketList.remove(id);
    }

    @Override
    public Supermarket getSupermarketById(int id) {
        return supermarketList.get(id);
    }

    @Override
    public List<Supermarket> getAllSupermarkets() {
        return supermarketList;
    }


}
