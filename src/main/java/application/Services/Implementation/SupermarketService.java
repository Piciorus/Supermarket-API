package application.Services.Implementation;

import application.Domain.Entities.Supermarket;
import application.Domain.Models.Supermarket.Request.SupermarketRequestCreate;
import application.Domain.Models.Supermarket.Response.SupermarketResponseGetAll;
import application.Domain.Mapper.Mapper;
import application.Repository.SupermarketRepository;
import application.Services.Interface.ISupermarketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupermarketService implements ISupermarketService {
    private SupermarketRepository supermarketRepository;

    private Mapper mapper;


    public SupermarketService(SupermarketRepository supermarketRepository, Mapper mapper) {
        this.supermarketRepository = supermarketRepository;
        this.mapper = mapper;
    }

    @Override
    public Supermarket createSupermarket(SupermarketRequestCreate supermarketRequest) {
        Supermarket supermarket = mapper.SupermarketRequestToSupermarket(supermarketRequest);
        return supermarketRepository.save(supermarket);
    }

    @Override
    public void deleteSupermarketById(Long id) {
        supermarketRepository.deleteById(id);
    }

    @Override
    public Iterable<SupermarketResponseGetAll> getAllSupermarkets() {
        List<SupermarketResponseGetAll> list = new ArrayList<>();
        supermarketRepository.findAll().forEach(supermarket -> {
            list.add(mapper.SupermarketToSupermarketResponse(supermarket));
        });
        return list;
    }

    @Override
    public Supermarket getSupermarketById(Long id) {
        return supermarketRepository.getById(id);
    }

    @Override
    public Supermarket updateSupermarket(Supermarket supermarket, Long id) {
        Supermarket supermarketUpdated=supermarketRepository.getById(id);
        supermarketUpdated.setName(supermarket.getName());
        supermarketUpdated.setAddress(supermarket.getAddress());
        return supermarketRepository.save(supermarketUpdated);
    }
}
