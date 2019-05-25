package com.sak.passwordgenerator.serivce.http.request.impl;

import com.sak.passwordgenerator.serivce.http.request.GeneratePasswordRequest;

public class GeneratePasswordRequestImpl implements GeneratePasswordRequest {

    private int requestId;
    private String requestNote;

    @Override
    public int getRequestId() {
        return requestId;
    }

    @Override
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public String getRequestNote() {
        return requestNote;
    }

    @Override
    public void setRequestNote(String requestNote) {
        this.requestNote = requestNote;
    }

    @Override
    public String toString() {
        return "GeneratePasswordRequestImpl{" +
                "requestId=" + requestId +
                ", requestNote='" + requestNote + '\'' +
                '}';
    }
}
