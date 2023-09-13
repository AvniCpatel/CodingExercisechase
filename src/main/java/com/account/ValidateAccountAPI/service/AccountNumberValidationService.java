package com.account.ValidateAccountAPI.service;


import com.account.ValidateAccountAPI.entity.ProviderEntity;
import com.account.ValidateAccountAPI.model.AccountValidateRequest;
import com.account.ValidateAccountAPI.model.AccountValidateResponse;
import com.account.ValidateAccountAPI.model.ProviderReqeust;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountNumberValidationService {

    @Value("provider1.url")
    private String provider1URL;

    @Value("provider2.url")
    private String provider2URL;


    public AccountValidateResponse validateAccountNumber(AccountValidateRequest acccountValidateRequest) {
        RestTemplate restTemplate = new RestTemplate();
        ProviderReqeust providerReqeust = new ProviderReqeust();
        providerReqeust.setAccountNumber(acccountValidateRequest.getAccountNumber());
        HttpEntity<ProviderReqeust> httpEntity = new HttpEntity<>(providerReqeust);
        AccountValidateResponse accountValidateResponse = new AccountValidateResponse();
        ProviderEntity providerEntity1 = new ProviderEntity();
        providerEntity1.setProvider("provider1");
        ProviderEntity providerEntity2 = new ProviderEntity();
        providerEntity2.setProvider("provider2");
        acccountValidateRequest.getProviders().forEach(o -> {
            if (o == "provider1") {
                ResponseEntity<String> response = restTemplate.exchange(provider1URL, HttpMethod.GET, httpEntity, String.class);
                if(response.getBody().contains("true")) {
                    providerEntity1.setValid(true);
                }
                else {
                    providerEntity1.setValid(false);
                }
            }
            if (o == "provider2") {
                ResponseEntity<String> response = restTemplate.exchange(provider2URL, HttpMethod.GET, httpEntity, String.class);
                if(response.getBody().contains("true")) {
                    providerEntity2.setValid(true);
                }
                else {
                    providerEntity2.setValid(false);
                }
            }
        });
        List<ProviderEntity> providerEntityList = new ArrayList<>();
        providerEntityList.add(providerEntity1);
        providerEntityList.add(providerEntity2);
        accountValidateResponse.setResult(providerEntityList);


        return accountValidateResponse;
    }
}
