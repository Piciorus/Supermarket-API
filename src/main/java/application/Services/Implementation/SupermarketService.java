package application.Services.Implementation;

import application.Domain.Entities.Supermarket;
import application.Domain.Mapper.Mapper;
import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Supermarket.Request.UpdateSupermarketRequest;
import application.Domain.Models.Supermarket.Response.GetAllSupermarketResponse;
import application.Domain.Models.Supermarket.Response.GetSupermarketByIdResponse;
import application.Repository.SupermarketRepository;
import application.Services.Interface.ISupermarketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SupermarketService implements ISupermarketService {
    private final SupermarketRepository supermarketRepository;

    private final Mapper mapper;

    public SupermarketService(SupermarketRepository supermarketRepository, Mapper mapper) {
        this.supermarketRepository = supermarketRepository;
        this.mapper = mapper;
    }

    @Override
    public Supermarket createSupermarket(AddSupermarketRequest supermarketRequest) {
        Supermarket supermarket = mapper.CreateSupermarketRequestToSupermarket(supermarketRequest);
        return supermarketRepository.save(supermarket);
    }

    @Override
    public void deleteSupermarketById(UUID id) {
        supermarketRepository.deleteById(id);
    }

    @Override
    public Iterable<GetAllSupermarketResponse> getAllSupermarkets() {
        List<GetAllSupermarketResponse> list = new ArrayList<>();
        supermarketRepository.findAll().forEach(supermarket -> {
            list.add(mapper.SupermarketToGetAllSupermarketResponse(supermarket));
        });
        return list;
    }

    @Override
    public GetSupermarketByIdResponse getSupermarketById(UUID id) {
        Supermarket supermarket = supermarketRepository.getById(id);
        return mapper.GetSupermarketByIdResponseToSupermarket(supermarket);
    }

    @Override
    public Supermarket updateSupermarket(UpdateSupermarketRequest updateSupermarketRequest, UUID id) {
        Supermarket supermarketUpdated = supermarketRepository.getById(id);
        supermarketUpdated.setName(updateSupermarketRequest.getName());
        supermarketUpdated.setAddress(updateSupermarketRequest.getAddress());
        supermarketUpdated.setUpdateDate(updateSupermarketRequest.getUpdateDate());
        return supermarketRepository.save(supermarketUpdated);
    }

    public Iterable<GetAllSupermarketResponse> findAll() {
        List<GetAllSupermarketResponse> list = new ArrayList<>();
        supermarketRepository.findAll().forEach(supermarket -> {
            list.add(mapper.SupermarketToGetAllSupermarketResponse(supermarket));
        });
        return list;
    }

}
