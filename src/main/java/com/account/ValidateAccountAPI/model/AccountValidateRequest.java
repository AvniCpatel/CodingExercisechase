package com.account.ValidateAccountAPI.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AccountValidateRequest {

    @JsonProperty
    private String accountNumber;

    @JsonProperty
    private List providers;

}
