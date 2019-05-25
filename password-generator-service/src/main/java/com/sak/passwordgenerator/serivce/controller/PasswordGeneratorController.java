package com.sak.passwordgenerator.serivce.controller;

public interface PasswordGeneratorController<REQUEST, RESPONSE> {

    RESPONSE generatePasswordAPI(REQUEST generatePasswordRequest);
}
