package com.theblues.theblues.Service;

import com.theblues.theblues.DTO.MemberFormDTO;
import com.theblues.theblues.Entity.Member;
import com.theblues.theblues.Repository.MemberRepository;
import com.theblues.theblues.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Override
    public Long join(MemberFormDTO memberFormDTO) {
        Member member = Member.builder()
                .memberId(memberFormDTO.getMemberId())
                .password(memberFormDTO.getPassword())
                .name(memberFormDTO.getName())
                .mobile(memberFormDTO.getMobile())
                .is_sms(memberFormDTO.getIs_sms())
                .email(memberFormDTO.getEmail())
                .is_news_mail(memberFormDTO.getIs_news_mail())
                .agree_service_check(memberFormDTO.getAgree_service_check())
                .build();

        return memberRepository.save(member).getId();
    }

    @Override
    public Map<String, String> validateHandling(Errors errors) {
        Map<String,String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
            System.out.println(validKeyName);
        }
        return validatorResult;
    }

    @Transactional(readOnly = true)
    public boolean checkMemberIdExists(String memberId){
        return memberRepository.existsByMemberId(memberId);
    }

}
