package ba.academy.notes.repository;

import ba.academy.notes.repository.entities.LabelEntity;

public class LabelRepository extends Repository<LabelEntity, Integer>{
    protected LabelRepository() {
        super(LabelEntity.class);
    }
}
