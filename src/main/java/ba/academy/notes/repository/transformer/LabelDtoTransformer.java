package ba.academy.notes.repository.transformer;

import ba.academy.notes.dto.GroupsDto;
import ba.academy.notes.dto.LabelDto;
import ba.academy.notes.repository.entities.GroupsEntity;
import ba.academy.notes.repository.entities.LabelEntity;

public class LabelDtoTransformer implements DtoTransformer<LabelEntity, LabelDto>{
    @Override
    public LabelDto toDto(LabelEntity entity) {
        LabelDto dto = new LabelDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setColor(entity.getColor());
        return dto;
    }

    @Override
    public LabelEntity toEntity(LabelDto dto, LabelEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new LabelEntity();
        entityInstance.setName(dto.getName());
        entityInstance.setDescription(dto.getDescription());
        entityInstance.setColor(dto.getColor());
        return entityInstance;
    }
}
