package repositories;

import ru.itis.site.models.Account;

// теперь в AccountsRepository будут те же методы, но вместо <T, ID> будут <Account, Long>
public interface AccountsRepository extends CrudRepository<Account, Long>{

}
