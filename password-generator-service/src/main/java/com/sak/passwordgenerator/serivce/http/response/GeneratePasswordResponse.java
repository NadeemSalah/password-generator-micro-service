package com.sak.passwordgenerator.serivce.http.response;

public interface GeneratePasswordResponse {

    String getResponseId();

    GeneratePasswordResponse setResponseId(String responseId);

    String getGeneratedPassword();

    GeneratePasswordResponse setGeneratedPassword(String generatedPassword);
}
