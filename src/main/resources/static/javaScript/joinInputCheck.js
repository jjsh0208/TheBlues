document.getElementById('register_btn').addEventListener('click', function(e) {
    e.preventDefault(); // 기본 동작 방지
    document.getElementById('joinForm').submit(); // 폼 제출
    // 폼 검증 로직 여기에 추가...
    // 모든 검증 함수가 true를 반환하면 폼 제출 실행
    // if (validateForm()) { // validateForm()는 모든 검증 로직을 포함한 함수로 가정
    //     document.getElementById('joinForm').submit(); // 폼 제출
    // }
});


 function validateForm(e) {
    // ID 검증
    var memberId = document.getElementById('member_id').value;
    if (!/^[a-z0-9]{4,16}$/.test(memberId)) {
        alert('ID는 영문 소문자와 숫자를 포함한 4-16자여야 합니다.');
        return false;
    }

    // 비밀번호 검증
    var password = document.getElementById('password').value;
    if (!/(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{10,16}/.test(password)) {
        alert('비밀번호는 영문 대소문자, 숫자, 특수문자 중 2가지 이상을 조합한 10~16자여야 합니다.');
        return false;
    }

    // 비밀번호 확인 검증
    var passwordConfirm = document.getElementById('user_passwd_confirm').value;
    if (password !== passwordConfirm) {
        alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
        return false;
    }

    // 이름 검증 (예시로 간단한 길이 체크만 추가)
    var name = document.getElementById('name').value;
    if (name.length < 1) {
        alert('이름을 입력해주세요.');
        return false;
    }

    // 휴대폰 번호 검증 (예시로 간단한 길이 체크만 추가)
    var mobile2 = document.getElementById('mobile2').value;
    var mobile3 = document.getElementById('mobile3').value;
    if (!/^\d{4}$/.test(mobile2) || !/^\d{4}$/.test(mobile3)) {
        alert('휴대폰 번호가 올바르지 않습니다.');
        return false;
    }

    // 이메일 검증
    var email = document.getElementById('email').value;
    if (!/\S+@\S+\.\S+/.test(email)) {
        alert('올바른 이메일 주소를 입력해주세요.');
        return false;
    }

    // 이용약관 동의 검증
    var agreeService = document.getElementById('agree_service_check').checked;
    if (!agreeService) {
        alert('이용약관에 동의해주세요.');
        return false;
    }

    // 개인정보 수집 및 이용 동의 검증
    var agreePrivacy = document.getElementById('agree_privacy_check').checked;
    if (!agreePrivacy) {
        alert('개인정보 수집 및 이용에 동의해주세요.');
        return false;
    }

    // 모든 검증을 통과했다면, 폼 제출을 계속 진행
    return true;
}
