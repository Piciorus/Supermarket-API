package application.Services.Interface;

import application.Domain.Entities.Supermarket;
import application.Domain.Models.Supermarket.Request.SupermarketRequestCreate;
import application.Domain.Models.Supermarket.Response.SupermarketResponseGetAll;

public interface ISupermarketService {
    Supermarket  createSupermarket(SupermarketRequestCreate supermarketRequest);
    void deleteSupermarketById(Long id);
    Iterable<SupermarketResponseGetAll> getAllSupermarkets();
    Supermarket getSupermarketById(Long id);
    Supermarket updateSupermarket(Supermarket supermarket, Long id);

}
