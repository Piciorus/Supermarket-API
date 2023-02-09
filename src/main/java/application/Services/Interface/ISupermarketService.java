package application.Services.Interface;

import application.Domain.Entities.Supermarket;
import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Supermarket.Request.UpdateSupermarketRequest;
import application.Domain.Models.Supermarket.Response.GetAllSupermarketResponse;
import application.Domain.Models.Supermarket.Response.GetSupermarketByIdResponse;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;

public interface ISupermarketService {
    @Async
    Supermarket createSupermarket(AddSupermarketRequest supermarketRequest);

    @Async
    void deleteSupermarketById(UUID id);

    @Async
    Iterable<GetAllSupermarketResponse> getAllSupermarkets();

    @Async
    GetSupermarketByIdResponse getSupermarketById(UUID id);

    @Async
    Supermarket updateSupermarket(UpdateSupermarketRequest updateSupermarketRequest, UUID id);

}
