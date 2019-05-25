package com.sak.passwordgenerator.serivce.config;

import com.sak.passwordgenerator.PasswordGenerator;
import com.sak.passwordgenerator.PasswordValidator;
import com.sak.passwordgenerator.PasswordValidatorImpl;
import com.sak.passwordgenerator.RandomPasswordGenerator;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ModuleConfiguration {

    @Bean
    public PasswordValidator getPasswordValidatorBean() {
        return new PasswordValidatorImpl();
    }

    @Bean
    public PasswordGenerator getPasswordGeneratorBean() {
        return new RandomPasswordGenerator(getPasswordValidatorBean());
    }
}
