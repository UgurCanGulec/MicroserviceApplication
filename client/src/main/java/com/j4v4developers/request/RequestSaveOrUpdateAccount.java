package com.j4v4developers.request;

import com.j4v4developers.dto.AccountDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Account save or update request", description = "It includes saved Account")
public class RequestSaveOrUpdateAccount {
    @ApiModelProperty(value = "AccountDto", name = "AccountDto to save", dataType = "AccountDto")
    private AccountDto accountDto;
}
