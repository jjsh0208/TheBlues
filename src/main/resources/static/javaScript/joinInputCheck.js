document.getElementById('register_btn').addEventListener('click', function(e) {
    e.preventDefault(); // 기본 동작 방지
    const memberIdCheckResult = document.getElementById('memberIdCheckResult');
    // 'valid1' 클래스가 있으면 폼 제출을 방지
    if (memberIdCheckResult.classList.contains('valid')) {
        alert('중복된 아이디입니다. 다른 아이디를 입력해주세요.'); // 사용자에게 알림
    }else{
        alert('로그인 성공');
        document.getElementById('joinForm').submit(); // 폼 제출
    }
});
