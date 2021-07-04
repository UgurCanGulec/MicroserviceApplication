package com.j4v4developers.client;

import com.j4v4developers.response.BaseResponse;
import com.j4v4developers.dto.AccountDto;
import com.j4v4developers.request.RequestSaveOrUpdateAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-microservice", url = "localhost:8501/api/account-operations")
public interface AccountServiceClient {

    @GetMapping("/account/{id}")
    ResponseEntity<BaseResponse<AccountDto>> getAccountById(@PathVariable("id") String id);

    @PostMapping("/account")
    ResponseEntity<BaseResponse<AccountDto>> saveOrUpdateAccount(@RequestBody RequestSaveOrUpdateAccount request);

    @PutMapping(value = "account/{id}")
    ResponseEntity<BaseResponse<AccountDto>> deleteAuthorById(@PathVariable("id") String id);
}
