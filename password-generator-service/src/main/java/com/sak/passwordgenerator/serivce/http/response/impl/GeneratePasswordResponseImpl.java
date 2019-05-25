package com.sak.passwordgenerator.serivce.http.response.impl;

import com.sak.passwordgenerator.serivce.http.response.GeneratePasswordResponse;

public class GeneratePasswordResponseImpl implements GeneratePasswordResponse {

    private String responseId;
    private String generatedPassword;


    @Override
    public String getResponseId() {
        return responseId;
    }

    @Override
    public GeneratePasswordResponseImpl setResponseId(String responseId) {
        this.responseId = responseId;
        return this;
    }

    @Override
    public String getGeneratedPassword() {
        return generatedPassword;
    }

    @Override
    public GeneratePasswordResponseImpl setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
        return this;
    }
}
