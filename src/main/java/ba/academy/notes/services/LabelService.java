package ba.academy.notes.services;

import ba.academy.notes.dto.LabelDto;

import java.util.List;

public interface LabelService {
    List<LabelDto> getAll();

    LabelDto getById(Integer id);

    LabelDto create(LabelDto dto);

    LabelDto deleteById(Integer id);

    LabelDto updateById(Integer id, LabelDto dto);
}
