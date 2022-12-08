package application.Services.Interface;

import application.Model.Account;

import java.util.List;

public interface IAccountService {
    Account getUserById(int id);
    Account create(Account account);
    List<Account> getAll();
    Account register(String username, String password);
}
