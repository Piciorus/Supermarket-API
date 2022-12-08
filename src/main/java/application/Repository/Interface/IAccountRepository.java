package application.Repository.Interface;

import application.Model.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAccountRepository {
    void add(Account account);
    void deleteById(int id);
    Account getById(int id);
    List<Account> getAll();

}
