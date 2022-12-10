package application.Repository;

import application.Model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account save(Account account);
    void deleteById(final Long id);
    Account getById(final Long id);
    Iterable<Account> findAll();

}
