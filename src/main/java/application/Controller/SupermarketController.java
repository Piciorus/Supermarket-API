package application.Controller;

import application.Config.ResponseEntity;
import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Supermarket.Request.UpdateSupermarketRequest;
import application.Domain.Models.Supermarket.Response.GetAllSupermarketResponse;
import application.Domain.Models.Supermarket.Response.GetSupermarketByIdResponse;
import application.Services.Interface.ISupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController()
@Component
public class SupermarketController {
    private final ISupermarketService supermarketService;

    @Autowired
    public SupermarketController(ISupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    @PostMapping(path = "/createSupermarket")
    @ResponseStatus(HttpStatus.CREATED)
    @Async
    public ResponseEntity<String> addSupermarket(@RequestBody final AddSupermarketRequest addSupermarketRequest) {
        supermarketService.createSupermarket(addSupermarketRequest);
        return new ResponseEntity<>("dada", 200, "Supermarket created");
    }

    @GetMapping(path = "/getAllSupermarkets")
    @Async
    public Iterable<GetAllSupermarketResponse> getAllSupermarkets() {
        return supermarketService.getAllSupermarkets();
    }

    @GetMapping(path = "/getSupermarketById/{id}")
    @Async
    public ResponseEntity<GetSupermarketByIdResponse> getSupermarketById(@PathVariable("id") UUID supermarketId) {
        return new ResponseEntity<>(supermarketService.getSupermarketById(supermarketId), 200, "Get supermarket by id");
    }

    @DeleteMapping(path = "/deleteSupermarketById/{id}")
    @Async
    public ResponseEntity<String> deleteSupermarketById(@PathVariable("id") UUID supermarketId) {
        supermarketService.deleteSupermarketById(supermarketId);
        return new ResponseEntity<>("", 200, "Supermarket deleted");
    }

    @PutMapping(path = "/updateSupermarket/{id}")
    @Async
    public ResponseEntity<String> updateSupermarket(@RequestBody final UpdateSupermarketRequest updateSupermarketRequest, @PathVariable("id") UUID supermarketId) {
        supermarketService.updateSupermarket(updateSupermarketRequest, supermarketId);
        return new ResponseEntity<>("", 200, "Supermarket updated");
    }
}
