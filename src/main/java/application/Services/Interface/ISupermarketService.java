package application.Services.Interface;

import application.Domain.Entities.Supermarket;
import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Supermarket.Request.UpdateSupermarketRequest;
import application.Domain.Models.Supermarket.Response.GetAllSupermarketResponse;
import application.Domain.Models.Supermarket.Response.GetSupermarketByIdResponse;

public interface ISupermarketService {
    Supermarket  createSupermarket(AddSupermarketRequest supermarketRequest);
    void deleteSupermarketById(Long id);
    Iterable<GetAllSupermarketResponse> getAllSupermarkets();
    GetSupermarketByIdResponse getSupermarketById(Long id);
    Supermarket updateSupermarket(UpdateSupermarketRequest updateSupermarketRequest, Long id);

}
