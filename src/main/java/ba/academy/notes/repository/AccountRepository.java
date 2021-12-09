package ba.academy.notes.repository;

import ba.academy.notes.repository.entities.AccountEntity;

public class AccountRepository extends Repository<AccountEntity, Integer>{
    protected AccountRepository() {
        super(AccountEntity.class);
    }
}
