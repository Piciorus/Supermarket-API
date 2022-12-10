package application.Services.Interface;

import application.Model.Account;

public interface IAccountService {
    Account createAccount(Account account);
    void deleteAccountById(Long id);
    Iterable<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account updateAccount(Account account,Long id);

}
