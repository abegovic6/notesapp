package ba.academy.notes.repository.transformer;

import ba.academy.notes.dto.AccountDto;
import ba.academy.notes.repository.entities.AccountEntity;

public class AccountDtoTransformer implements DtoTransformer<AccountEntity, AccountDto>{

    @Override
    public AccountDto toDto(AccountEntity entity) {
        AccountDto dto = new AccountDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    @Override
    public AccountEntity toEntity(AccountDto dto, AccountEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new AccountEntity();

        entityInstance.setName(dto.getName());
        entityInstance.setUsername(dto.getUsername());
        entityInstance.setEmail(dto.getEmail());
        entityInstance.setPassword(dto.getPassword());
        return entityInstance;
    }
}
