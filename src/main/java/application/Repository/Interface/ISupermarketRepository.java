package application.Repository.Interface;

import application.Model.Supermarket;

import java.util.List;

public interface ISupermarketRepository {
    void addSupermarket(Supermarket supermarket);
    void deleteSupermarketById(int id);
    Supermarket getSupermarketById(int id);
    List<Supermarket> getAllSupermarkets();
}
