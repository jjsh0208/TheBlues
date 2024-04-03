package com.theblues.theblues.Api;

import com.theblues.theblues.Service.MemberServiceImpl;
import com.theblues.theblues.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {
    @Autowired
    MemberServiceImpl memberService;

    @GetMapping("/api/members/checkMemberId")
    public ResponseEntity<?> checkMemberId(@RequestParam String memberId){
        boolean exists = memberService.checkMemberIdExists(memberId);
        if(exists){
            return ResponseEntity.badRequest().body("이미 존재하는 아이디입니다.");
        }

        return ResponseEntity.ok("사용 가능한 아이디입니다.");
    }

}
