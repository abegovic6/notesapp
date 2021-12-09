package ba.academy.notes.repository;

import ba.academy.notes.repository.entities.NoteEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class NoteRepository extends Repository<NoteEntity, Integer>{
    protected NoteRepository() {
        super(NoteEntity.class);
    }
}
