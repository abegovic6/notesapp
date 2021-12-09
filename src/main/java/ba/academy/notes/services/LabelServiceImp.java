package ba.academy.notes.services;

import ba.academy.notes.dto.LabelDto;
import ba.academy.notes.repository.AccountRepository;
import ba.academy.notes.repository.GroupsRepository;
import ba.academy.notes.repository.LabelRepository;
import ba.academy.notes.repository.NoteRepository;
import ba.academy.notes.repository.entities.AccountEntity;
import ba.academy.notes.repository.entities.GroupsEntity;
import ba.academy.notes.repository.entities.LabelEntity;
import ba.academy.notes.repository.entities.NoteEntity;
import ba.academy.notes.repository.transformer.LabelDtoTransformer;
import ba.academy.notes.repository.transformer.NotesDtoTransformer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ApplicationScoped
@Transactional
public class LabelServiceImp implements LabelService{

    private final LabelDtoTransformer dtoTransformer = new LabelDtoTransformer();

    @Inject
    LabelRepository repository;

    @Inject
    AccountRepository accountRepository;

    @Override
    public List<LabelDto> getAll() {
        return dtoTransformer.toDtoList(repository.findAllAsList());
    }

    @Override
    public LabelDto getById(Integer id) {
        return dtoTransformer.toDto(repository.findBy(id));
    }

    @Override
    public LabelDto create(LabelDto dto) {
        final LabelEntity entity = dtoTransformer.toEntity(dto, new LabelEntity());

        final AccountEntity accountEntity = accountRepository.findBy(entity.getAccount().getId());
        entity.setAccount(accountEntity);

        repository.persist(entity);

        return dtoTransformer.toDto(entity);
    }

    @Override
    public LabelDto deleteById(Integer id) {
        LabelEntity entity = repository.findBy(id);
        if(entity != null) {
            try {
                repository.remove(entity); // remove will throw an exception if it can't delete the object
                return dtoTransformer.toDto(entity);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public LabelDto updateById(Integer id, LabelDto dto) {
        LabelEntity entity = repository.findBy(id);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setColor(dto.getColor());

        final AccountEntity accountEntity = accountRepository.findBy(entity.getAccount().getId());
        entity.setAccount(accountEntity);

        try {
            repository.persist(entity);
            return dtoTransformer.toDto(entity);
        } catch (Exception e) {
            return null;
        }
    }
}
