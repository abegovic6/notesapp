package ba.academy.notes.repository.transformer;

import ba.academy.notes.dto.GroupsDto;
import ba.academy.notes.repository.entities.GroupsEntity;

public class GroupsDtoTransformer implements DtoTransformer<GroupsEntity, GroupsDto>{
    private final AccountDtoTransformer accountDtoTransformer = new AccountDtoTransformer();

    @Override
    public GroupsDto toDto(GroupsEntity entity) {
        GroupsDto dto = new GroupsDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setColor(entity.getColor());
        dto.setAccountDto(accountDtoTransformer.toDto(entity.getAccount()));
        return dto;
    }

    @Override
    public GroupsEntity toEntity(GroupsDto dto, GroupsEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new GroupsEntity();
        entityInstance.setName(dto.getName());
        entityInstance.setDescription(dto.getDescription());
        entityInstance.setColor(dto.getColor());
        return entityInstance;
    }
}
