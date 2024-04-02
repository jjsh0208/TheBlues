package com.theblues.theblues.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberFormDTO {

    //사용자 계정
    @NotBlank(message = "회원계정을 입력해주세요.")
    private String member_id;

    //비밀번호
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*\\W).{10,16}$|"
            + "^(?=.*[a-zA-Z]).{10,16}$|"
            + "^(?=.*[0-9]).{10,16}$|"
            + "^(?=.*\\W).{10,16}$",
            message = "비밀번호는 10~16자 영문 대 소문자, 숫자, 특수문자 중 2가지 이상 조합을 사용하세요.")
    private String password;

    @NotBlank(message = "비밀번호를 확인해주세요.")
    private  String user_passwd_confirm;

    //고객명
    @NotBlank(message = "이름를 입력해주세요.")
    private String name;

    //전화번호
    @Pattern(regexp = "^01(?:0|1|[6-9]),\\d{4},\\d{4}$",
            message = "전화번호 형식이 올바르지 않습니다. 형식: 010-1234-5678")
    private String mobile;

    //sms 수신여부 (선택사항)
    private String is_sms;

    //사용자 이메일
    @NotBlank(message="이메일을 입력해주세요.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    //이메일 수신여부 (선택사항)
    private String is_news_mail;

    //쇼핑몰 이용약관
    @NotBlank(message = "이용약관에 동의해주세요.")
    private String agree_service_check;

    //개인정보 수집 및 이용 동의약관
    @NotBlank(message = "개인정보 수집 및 이용에 동의해주세요.")
    private String agree_privacy_check;

}
