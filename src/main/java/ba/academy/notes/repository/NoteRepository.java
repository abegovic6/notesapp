package ba.academy.notes.repository;

import ba.academy.notes.repository.entities.NoteEntity;

public class NoteRepository extends Repository<NoteEntity, Integer>{
    protected NoteRepository() {
        super(NoteEntity.class);
    }
}
