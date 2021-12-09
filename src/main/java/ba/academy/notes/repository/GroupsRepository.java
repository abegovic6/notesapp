package ba.academy.notes.repository;

import ba.academy.notes.repository.entities.GroupsEntity;

public class GroupsRepository extends Repository<GroupsEntity, Integer>{
    protected GroupsRepository() {
        super(GroupsEntity.class);
    }
}
