package application.Controller;

import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Supermarket.Request.UpdateSupermarketRequest;
import application.Domain.Models.Supermarket.Response.GetAllSupermarketResponse;
import application.Domain.Models.Supermarket.Response.GetSupermarketByIdResponse;
import application.Services.Interface.ISupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController()
@Component
public class SupermarketController {
    private ISupermarketService supermarketService;

    @Autowired
    public SupermarketController(ISupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    @PostMapping(path = "/createSupermarket")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addSupermarket(@RequestBody final AddSupermarketRequest supermarketRequestCreate) {
        supermarketService.createSupermarket(supermarketRequestCreate);
        return ResponseEntity.ok("Supermarket created");
    }

    @GetMapping(path = "/getAllSupermarkets")
    public Iterable<GetAllSupermarketResponse> getAllSupermarkets() {
        return supermarketService.getAllSupermarkets();
    }

    @GetMapping(path = "/getSupermarketById/{id}")
    public ResponseEntity<GetSupermarketByIdResponse> getSupermarketById(@PathVariable("id") Long supermarketId) {
        return ResponseEntity.ok(supermarketService.getSupermarketById(supermarketId));
    }

    @DeleteMapping(path = "/deleteSupermarketById/{id}")
    public ResponseEntity<String> deleteSupermarketById(@PathVariable("id") Long supermarketId) {
        supermarketService.deleteSupermarketById(supermarketId);
        return ResponseEntity.ok("Supermarket deleted");
    }

    @PutMapping(path = "/updateSupermarket/{id}")
    public ResponseEntity<String> updateSupermarket(@RequestBody final UpdateSupermarketRequest updateSupermarketRequest, @PathVariable("id") Long supermarketId) {
        supermarketService.updateSupermarket(updateSupermarketRequest, supermarketId);
        return ResponseEntity.ok("Supermarket updated");
    }
}
