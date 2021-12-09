package ba.academy.notes.repository;

import ba.academy.notes.repository.entities.AccountEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class AccountRepository extends Repository<AccountEntity, Integer>{
    protected AccountRepository() {
        super(AccountEntity.class);
    }
}
