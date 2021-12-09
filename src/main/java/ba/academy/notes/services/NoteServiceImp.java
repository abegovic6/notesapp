package ba.academy.notes.services;

import ba.academy.notes.dto.NoteDto;
import ba.academy.notes.repository.GroupsRepository;
import ba.academy.notes.repository.LabelRepository;
import ba.academy.notes.repository.NoteRepository;
import ba.academy.notes.repository.entities.GroupsEntity;
import ba.academy.notes.repository.entities.LabelEntity;
import ba.academy.notes.repository.entities.NoteEntity;
import ba.academy.notes.repository.transformer.NotesDtoTransformer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
@Transactional
public class NoteServiceImp implements NoteService{
    private final NotesDtoTransformer dtoTransformer = new NotesDtoTransformer();

    @Inject
    NoteRepository repository;

    @Inject
    GroupsRepository groupsRepository;

    @Inject
    LabelRepository labelRepository;

    @ConfigProperty(name = "prefix.message")
    String prefix;

    @Override
    public List<NoteDto> getAll() {
        return dtoTransformer.toDtoList(repository.findAllAsList());
    }

    @Override
    public NoteDto getById(Integer id) {
        return dtoTransformer.toDto(repository.findBy(id));
    }

    @Override
    public NoteDto create(NoteDto dto) {
        final NoteEntity entity = dtoTransformer.toEntity(dto, new NoteEntity());

        final GroupsEntity groupsEntity = groupsRepository.findBy(entity.getId());
        entity.setGroup(groupsEntity);

        final Set<LabelEntity> labelEntities = new HashSet<>();
        for(var l : dto.getLabelDtoList())
            labelEntities.add(labelRepository.findBy(l.getId()));
        entity.setLabels(labelEntities);

        repository.persist(entity);

        return dtoTransformer.toDto(entity);
    }

    @Override
    public NoteDto deleteById(Integer id) {
        NoteEntity entity = repository.findBy(id);
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
    public NoteDto updateById(Integer id, NoteDto dto) {
        NoteEntity entity = repository.findBy(id);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setColor(dto.getColor());

        final GroupsEntity groupsEntity = groupsRepository.findBy(entity.getId());
        entity.setGroup(groupsEntity);

        final Set<LabelEntity> labelEntities = new HashSet<>();
        for(var l : dto.getLabelDtoList())
            labelEntities.add(labelRepository.findBy(l.getId()));
        entity.setLabels(labelEntities);

        try {
            repository.persist(entity);
            return dtoTransformer.toDto(entity);
        } catch (Exception e) {
            return null;
        }
    }
}
