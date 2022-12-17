package application.Controller;

import application.Domain.Entities.Supermarket;
import application.Domain.Models.Supermarket.Request.SupermarketRequestCreate;
import application.Domain.Models.Supermarket.Response.SupermarketResponseGetAll;
import application.Services.Interface.ISupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
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
    public ResponseEntity<String> addSupermarket(@RequestBody final SupermarketRequestCreate supermarketRequestCreate) {
        supermarketService.createSupermarket(supermarketRequestCreate);
        return new ResponseEntity<>("Supermarket created ",HttpStatus.OK);
    }

    @GetMapping(path = "/getAllSupermarkets")
    public Iterable<SupermarketResponseGetAll> getAllSupermarkets() {
        return supermarketService.getAllSupermarkets();
    }

    @GetMapping(path = "/getSupermarketById/{id}")
    public ResponseEntity<Supermarket> getSupermarketById(@PathVariable("id") Long supermarketId) {
        return ResponseEntity.ok(supermarketService.getSupermarketById(supermarketId));
    }

    @DeleteMapping(path = "/deleteSupermarketById/{id}")
    public ResponseEntity<String> deleteSupermarketById(@PathVariable("id") Long supermarketId) {
        supermarketService.deleteSupermarketById(supermarketId);
        return new ResponseEntity<>("Supermarket deleted",HttpStatus.OK);
    }

    @PutMapping(path = "/updateSupermarket/{id}")
    public ResponseEntity<String> updateSupermarket(@RequestBody final Supermarket supermarket, @PathVariable("id") Long supermarketId) {
        supermarketService.updateSupermarket(supermarket, supermarketId);
        return new ResponseEntity<>("Supermarket updated",HttpStatus.OK);
    }
}
