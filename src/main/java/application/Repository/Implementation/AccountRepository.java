package application.Repository.Implementation;

import application.Model.Account;
import application.Repository.Interface.IAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository implements IAccountRepository {
    private List<Account> userList;

    public AccountRepository(List<Account> userList) {
        this.userList = userList;
    }

    @Override
    public void add(Account account) {
        userList.add(account);
    }

    @Override
    public void deleteById(int id) {
        userList.remove(id);
    }

    @Override
    public Account getById(int id) {return userList.get(id);}

    @Override
    public List<Account> getAll() {
        return userList;
    }
}
