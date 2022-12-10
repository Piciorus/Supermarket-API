package application.Services.Implementation;

import application.Model.Account;
import application.Repository.AccountRepository;
import application.Services.Interface.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.getById(id);
    }

    @Override
    public Account updateAccount(Account account,Long id) {
        Account accountUpdated = accountRepository.getById(id);
        accountUpdated.setUsername(account.getUsername());
        accountUpdated.setPassword(account.getPassword());
        return accountRepository.save(accountUpdated);
    }
}
