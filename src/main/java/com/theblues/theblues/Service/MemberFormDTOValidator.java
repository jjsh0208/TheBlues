package com.theblues.theblues.Service;

import com.theblues.theblues.DTO.MemberFormDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberFormDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MemberFormDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberFormDTO memberFormDTO = (MemberFormDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "비밀번호를 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_passwd_confirm", "field.required", "비밀번호 확인을 입력해주세요.");

        if (!memberFormDTO.getPassword().equals(memberFormDTO.getUser_passwd_confirm())) {
            errors.rejectValue("user_passwd_confirm", "passwordMismatch", "비밀번호가 일치하지 않습니다.");
        }
    }
}
