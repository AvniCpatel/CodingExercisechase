package com.account.ValidateAccountAPI.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProviderReqeust {

    @JsonProperty
    private String accountNumber;


}
