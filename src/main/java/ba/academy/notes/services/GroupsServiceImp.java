package ba.academy.notes.services;

import ba.academy.notes.dto.GroupsDto;
import ba.academy.notes.repository.AccountRepository;
import ba.academy.notes.repository.GroupsRepository;
import ba.academy.notes.repository.entities.AccountEntity;
import ba.academy.notes.repository.entities.GroupsEntity;
import ba.academy.notes.repository.entities.LabelEntity;
import ba.academy.notes.repository.transformer.GroupsDtoTransformer;
import ba.academy.notes.repository.transformer.LabelDtoTransformer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
@Transactional
public class GroupsServiceImp implements GroupsService {
    private final GroupsDtoTransformer dtoTransformer = new GroupsDtoTransformer();

    @Inject
    GroupsRepository repository;

    @Inject
    AccountRepository accountRepository;

    @Override
    public List<GroupsDto> getAll() {
        return dtoTransformer.toDtoList(repository.findAllAsList());
    }

    @Override
    public GroupsDto getById(Integer id) {
        return dtoTransformer.toDto(repository.findBy(id));
    }

    @Override
    public GroupsDto create(GroupsDto dto) {
        final GroupsEntity entity = dtoTransformer.toEntity(dto, new GroupsEntity());

        repository.persist(entity);

        final AccountEntity accountEntity = accountRepository.findBy(entity.getAccount().getId());
        entity.setAccount(accountEntity);

        return dtoTransformer.toDto(entity);
    }

    @Override
    public GroupsDto deleteById(Integer id) {
        GroupsEntity entity = dtoTransformer.toEntity(getById(id), new GroupsEntity());
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
    public GroupsDto updateById(Integer id, GroupsDto dto) {
        GroupsEntity entity = dtoTransformer.toEntity(getById(id), new GroupsEntity());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setColor(dto.getColor());
        try {
            repository.persist(entity);
            return dtoTransformer.toDto(entity);
        } catch (Exception e) {
            return null;
        }
    }
}
