package ba.academy.notes.services;

import ba.academy.notes.dto.GroupsDto;

import java.util.List;

public interface GroupsService {
    List<GroupsDto> getAll();

    GroupsDto getById(Integer id);

    GroupsDto create(GroupsDto dto);

    GroupsDto deleteById(Integer id);

    GroupsDto updateById(Integer id, GroupsDto dto);
}
