package com.theblues.theblues.interfaces;

import com.theblues.theblues.DTO.MemberFormDTO;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.validation.Errors;

import java.util.Map;

public interface MemberService {

    Long join (MemberFormDTO memberFormDTO);

    Map<String,String> validateHandling(Errors errors);


}
