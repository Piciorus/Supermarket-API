package application.Controller;

import application.Model.Account;
import application.Services.Implementation.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@Component
public class AccountController {

    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/addAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addAccount(@RequestBody final Account Account) {
        return accountService.createAccount(Account);
    }

    @GetMapping(path = "/getAllAccounts")
    public Iterable<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "/getAccountById/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long accountId) {
        return ResponseEntity.ok(accountService.getAccountById(accountId));
    }

    @DeleteMapping(path = "/deleteAccountById/{id}")
    public void deleteAccountById(@PathVariable("id") Long accountId) {
        accountService.deleteAccountById(accountId);
    }

    @PutMapping(path = "/updateAccount/{id}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account,@PathVariable("id") Long accountId) {
        return ResponseEntity.ok(accountService.updateAccount(account,accountId));
    }

}
