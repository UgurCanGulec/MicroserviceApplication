package com.j4v4developers.service;

import com.j4v4developers.dao.AccountDao;
import com.j4v4developers.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountDto getAccountById(String id){
        return accountDao.getAccountById(id);
    }

    @Transactional
    public AccountDto saveOrUpdateAccount(AccountDto accountDto) {
        return accountDao.saveOrUpdateAccount(accountDto);
    }

    @Transactional
    public AccountDto deleteAccountById(String id) {
        return accountDao.deleteAccountById(id);
    }

}
