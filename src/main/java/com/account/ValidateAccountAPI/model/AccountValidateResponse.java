package com.account.ValidateAccountAPI.model;

import com.account.ValidateAccountAPI.entity.ProviderEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AccountValidateResponse {

    @JsonProperty
    private List<ProviderEntity> result;

}
