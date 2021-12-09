package ba.academy.notes.repository.transformer;

import ba.academy.notes.dto.GroupsDto;
import ba.academy.notes.dto.NoteDto;
import ba.academy.notes.repository.entities.LabelEntity;
import ba.academy.notes.repository.entities.NoteEntity;

public class NotesDtoTransformer implements DtoTransformer<NoteEntity, NoteDto>{
    private final GroupsDtoTransformer groupsDtoTransformer = new GroupsDtoTransformer();
    private final LabelDtoTransformer labelDtoTransformer = new LabelDtoTransformer();

    @Override
    public NoteDto toDto(NoteEntity entity) {
        NoteDto dto = new NoteDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setColor(entity.getColor());
        dto.setGroupsDto(groupsDtoTransformer.toDto(entity.getGroup()));
        dto.setLabelDtoList(labelDtoTransformer.toDtoList(entity.getLabels()));
        return dto;
    }

    @Override
    public NoteEntity toEntity(NoteDto dto, NoteEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new NoteEntity();
        entityInstance.setTitle(dto.getTitle());
        entityInstance.setDescription(dto.getDescription());
        entityInstance.setColor(dto.getColor());
        return entityInstance;
    }
}
