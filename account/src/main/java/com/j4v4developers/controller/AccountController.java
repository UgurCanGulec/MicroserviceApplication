package com.j4v4developers.controller;

import com.j4v4developers.service.AccountService;
import com.j4v4developers.dto.AccountDto;
import com.j4v4developers.request.RequestSaveOrUpdateAccount;
import com.j4v4developers.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account-operations")
@Api(value = "Account Micro Service Rest Api")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/{id}")
    @ApiOperation(value = "Get account by id", response = AccountDto.class)
    public ResponseEntity<BaseResponse<AccountDto>> getAccountById(@PathVariable("id") String id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(new BaseResponse<>(accountDto, null, null, true));
    }

    @PostMapping("/account")
    @ApiOperation(value = "Save or update account author", response = AccountDto.class)
    public ResponseEntity<BaseResponse<AccountDto>> saveOrUpdateAccount(
            @ApiParam(name = "Account save or update request", value = "Account save or update", required = true)
            @RequestBody RequestSaveOrUpdateAccount request) {
        AccountDto accountDto = accountService.saveOrUpdateAccount(request.getAccountDto());
        return ResponseEntity.ok(new BaseResponse<>(accountDto, null, null, true));
    }

    @PutMapping(value = "account/{id}")
    @ApiOperation(value = "Delete account by id", response = AccountDto.class)
    public ResponseEntity<BaseResponse<AccountDto>> deleteAuthorById(@PathVariable("id") String id) {
        AccountDto accountDto = accountService.deleteAccountById(id);
        return ResponseEntity.ok(new BaseResponse<>(accountDto,null,null,true));
    }


}
