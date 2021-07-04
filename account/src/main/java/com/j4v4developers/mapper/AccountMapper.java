package com.j4v4developers.mapper;

import com.j4v4developers.db_model.entity.Account;
import com.j4v4developers.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account fromAccountDtoToAccount(AccountDto accountDto);

    AccountDto fromAccountToAccountDto(Account account);
}
