document.addEventListener('DOMContentLoaded', function(){
    document.getElementById('memberId').addEventListener('input', function() {
        var memberId = document.getElementById('memberId').value;

        // 사용자가 입력을 멈추고 0.5초 후에 중복 검사를 실행하도록 디바운싱 적용
        clearTimeout(window.memberIdCheckTimeout);
        window.memberIdCheckTimeout = setTimeout(function () {
            fetch(`/api/members/checkMemberId?memberId=${encodeURIComponent(memberId)}`)
                .then(response => {
                    const clonedResponse = response.clone(); // 응답 복제
                    const memberIdCheckResult = document.getElementById('memberIdCheckResult');
                    if (!response.ok) {
                        // HTTP 상태 코드가 200-299가 아닐 경우
                        clonedResponse.text().then(text => { // 복제된 응답으로 처리
                            throw new Error(text || '오류가 발생했습니다.');
                        });
                        memberIdCheckResult.classList.remove('valid1'); // 다른 클래스 제거
                        memberIdCheckResult.classList.add('valid'); // 'valid' 클래스 추가}
                    }
                    else{
                        memberIdCheckResult.classList.remove('valid'); // 다른 클래스 제거
                        memberIdCheckResult.classList.add('valid1'); // 'valid' 클래스 추가}
                    }
                    return response.text();
                })
                .then(data => {
                     document.getElementById('memberIdCheckResult').textContent = data;
                })
                .catch(error => {
                    document.getElementById('memberIdCheckResult').textContent = error.message;
                });
        }, 500); // 사용자가 타이핑을 멈춘 후 0.5초 뒤에 실행

    })
})
