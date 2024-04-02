package com.theblues.theblues.Controller;

import com.theblues.theblues.DTO.MemberFormDTO;
import com.theblues.theblues.Repository.MemberRepository;
import com.theblues.theblues.Service.MemberFormDTOValidator;
import com.theblues.theblues.Service.MemberServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberServiceImpl memberService;

    @GetMapping("/index")
    public String index(){
        return "layouts/index";
    }

    //회원가입 화면으로 이동
    @GetMapping("/members/new")
    public String join (){
        return "members/join";
    }

    //회원가입 입력검사
    @PostMapping("/members/new")
    public String processUserRegistration(@Valid MemberFormDTO memberFormDTO, Errors errors, Model model) {
        new MemberFormDTOValidator().validate(memberFormDTO,errors);
        if (errors.hasErrors()){
            //회원가입 실패시 입력 데이터 값을 유지
            model.addAttribute("MemberDto", memberFormDTO);
            //모바일 값을 따로 유지
            String[] mobileParts = memberFormDTO.getMobile().split(",");
            model.addAttribute("mobilePart1", mobileParts.length > 0 ? mobileParts[0] : "");
            model.addAttribute("mobilePart2", mobileParts.length > 1 ? mobileParts[1] : "");
            model.addAttribute("mobilePart3", mobileParts.length > 2 ? mobileParts[2] : "");
            //System.out.println("모바일길이 : " + mobileParts.length);
            //System.out.println(memberFormDTO.toString());

            //비밀번호 확인 검사
            if (!memberFormDTO.getPassword().equals(memberFormDTO.getUser_passwd_confirm())){
                model.addAttribute("passwordMismatch", "비밀번호가 일치하지 않습니다.");
            }

            //유효성검사를 통과못한 필드와 메시지를 핸들링
            Map<String,String> validatorResult = memberService.validateHandling(errors);
            for (String key : validatorResult.keySet()){
                model.addAttribute(key,validatorResult.get(key)); //예) valid_인풋 : 에러 메시지
            }

            return "members/join";
        }

        memberService.join(memberFormDTO);
        return"layouts/index";
    }


}
