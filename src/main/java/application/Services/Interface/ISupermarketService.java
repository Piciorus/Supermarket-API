package application.Services.Interface;

import application.Domain.Entities.Supermarket;
import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Supermarket.Request.UpdateSupermarketRequest;
import application.Domain.Models.Supermarket.Response.GetAllSupermarketResponse;
import application.Domain.Models.Supermarket.Response.GetSupermarketByIdResponse;

import java.util.UUID;

public interface ISupermarketService {
    Supermarket  createSupermarket(AddSupermarketRequest supermarketRequest);
    void deleteSupermarketById(UUID id);
    Iterable<GetAllSupermarketResponse> getAllSupermarkets();
    GetSupermarketByIdResponse getSupermarketById(UUID id);
    Supermarket updateSupermarket(UpdateSupermarketRequest updateSupermarketRequest, UUID id);

}
