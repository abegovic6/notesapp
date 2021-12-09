package ba.academy.notes.repository;

import ba.academy.notes.repository.entities.LabelEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class LabelRepository extends Repository<LabelEntity, Integer>{
    protected LabelRepository() {
        super(LabelEntity.class);
    }
}
