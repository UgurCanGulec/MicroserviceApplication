package com.j4v4developers.dao;

import com.j4v4developers.db_model.entity.Account;
import com.j4v4developers.mapper.AccountMapper;
import com.j4v4developers.dto.AccountDto;
import com.j4v4developers.repository.AccountRepository;
import com.j4v4developers.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class AccountDao {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountDao(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountDto getAccountById(String id) {
        Account account = accountRepository.getAccountByIdAndIsActive(id, true);
        if (account == null) {
            throw new AccountNotFoundException();
        } else {
            return accountMapper.fromAccountToAccountDto(account);
        }
    }

    public AccountDto saveOrUpdateAccount(AccountDto accountDto) {
        Account account = accountMapper.fromAccountDtoToAccount(accountDto);
        account.setCreatedAt(LocalDate.now());
        account.setIsActive(Boolean.TRUE);
        account = accountRepository.save(account);
        return accountMapper.fromAccountToAccountDto(account);
    }

    public AccountDto deleteAccountById(String id) {
        Account account = accountRepository.getAccountByIdAndIsActive(id, true);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        account.setIsActive(Boolean.FALSE);
        account = accountRepository.save(account);
        return accountMapper.fromAccountToAccountDto(account);
    }


}
