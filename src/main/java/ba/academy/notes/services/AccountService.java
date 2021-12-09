package ba.academy.notes.services;

import ba.academy.notes.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAll();

    AccountDto getById(Integer id);

    AccountDto create(AccountDto dto);

    AccountDto deleteById(Integer id);

    AccountDto updateById(Integer id, AccountDto dto);

}
