package application.Services.Implementation;

import application.Model.Account;
import application.Repository.Implementation.AccountRepository;
import application.Services.Interface.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService {

    private AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Account getUserById(int id) {
        return accountRepository.getById(id);
    }

    @Override
    public Account create(Account account) {
        accountRepository.add(account);
        return account;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.getAll();
    }
    @Override
    public Account register(String username, String password) {
        return null;
    }

}
