package com.homestock.homestock.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        int countMatches = 0;
        if (password.length() < 8 || password.length() > 32) {
            return false;
        }
        List<String> matchRules = Arrays.asList(".*\\d.*",".*[a-z].*", ".*[A-Z].*",".*[*.!@#$%^&(){}[]:\";'<>,.?/~`_+-=|\\].*");
        for (String rule: matchRules){
            if(password.matches(rule)){
                countMatches++;
            }
        }
        if(countMatches == matchRules.size()){
            return true;
        }
        return false;
    }
}
