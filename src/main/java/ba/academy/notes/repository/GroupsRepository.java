package ba.academy.notes.repository;

import ba.academy.notes.repository.entities.GroupsEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class GroupsRepository extends Repository<GroupsEntity, Integer>{
    protected GroupsRepository() {
        super(GroupsEntity.class);
    }
}
