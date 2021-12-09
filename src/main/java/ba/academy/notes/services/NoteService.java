package ba.academy.notes.services;


import ba.academy.notes.dto.NoteDto;

import java.util.List;

public interface NoteService {
    List<NoteDto> getAll();

    NoteDto getById(Integer id);

    NoteDto create(NoteDto dto);

    NoteDto deleteById(Integer id);

    NoteDto updateById(Integer id, NoteDto dto);
}
