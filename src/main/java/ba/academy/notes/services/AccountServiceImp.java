package ba.academy.notes.services;

import ba.academy.notes.dto.AccountDto;
import ba.academy.notes.repository.AccountRepository;
import ba.academy.notes.repository.LabelRepository;
import ba.academy.notes.repository.entities.AccountEntity;
import ba.academy.notes.repository.entities.GroupsEntity;
import ba.academy.notes.repository.entities.LabelEntity;
import ba.academy.notes.repository.entities.NoteEntity;
import ba.academy.notes.repository.transformer.AccountDtoTransformer;
import ba.academy.notes.repository.transformer.LabelDtoTransformer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
@Transactional
public class AccountServiceImp implements AccountService{
    private final AccountDtoTransformer dtoTransformer = new AccountDtoTransformer();

    @Inject
    AccountRepository repository;


    @Override
    public List<AccountDto> getAll() {
        return dtoTransformer.toDtoList(repository.findAllAsList());
    }

    @Override
    public AccountDto getById(Integer id) {
        return dtoTransformer.toDto(repository.findBy(id));
    }

    @Override
    public AccountDto create(AccountDto dto) {
        final AccountEntity entity = dtoTransformer.toEntity(dto, new AccountEntity());
        repository.persist(entity);
        return dtoTransformer.toDto(entity);
    }

    @Override
    public AccountDto deleteById(Integer id) {
        AccountEntity entity = repository.findBy(id);
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
    public AccountDto updateById(Integer id, AccountDto dto) {
        AccountEntity entity = repository.findBy(id);
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        try {
            repository.persist(entity);
            return dtoTransformer.toDto(entity);
        } catch (Exception e) {
            return null;
        }
    }
}
