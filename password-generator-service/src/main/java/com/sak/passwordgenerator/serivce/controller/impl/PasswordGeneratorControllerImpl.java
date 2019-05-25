package com.sak.passwordgenerator.serivce.controller.impl;

import com.sak.passwordgenerator.PasswordGenerator;
import com.sak.passwordgenerator.serivce.controller.PasswordGeneratorController;
import com.sak.passwordgenerator.serivce.http.response.GeneratePasswordResponse;
import com.sak.passwordgenerator.serivce.http.response.impl.GeneratePasswordResponseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/passgenerator")
public class PasswordGeneratorControllerImpl implements
        PasswordGeneratorController<PasswordGeneratorControllerImpl.VoidGeneratePasswordRequest, GeneratePasswordResponse> {

    @Autowired
    private PasswordGenerator passwordGenerator;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/generaterandompass")
    @ResponseBody
    public GeneratePasswordResponse generatePasswordAPI(VoidGeneratePasswordRequest generatePasswordRequest) {
        return new GeneratePasswordResponseImpl()
                .setResponseId(UUID.randomUUID().toString())
                .setGeneratedPassword(passwordGenerator.generateRandomPassword());
    }

    class VoidGeneratePasswordRequest {
        public VoidGeneratePasswordRequest() {
        }
    }
}
