package com.sak.passwordgenerator.serivce.http.request;

public interface GeneratePasswordRequest {

    int getRequestId();

    void setRequestId(int requestId);

    String getRequestNote();

    void setRequestNote(String requestNote);

}
