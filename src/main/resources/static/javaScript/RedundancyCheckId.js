function checkUsername() {
    var username = document.getElementById('username').value;

    // 사용자가 입력을 멈추고 0.5초 후에 중복 검사를 실행하도록 디바운싱 적용
    clearTimeout(window.memberIdCheckTimeout);
    window.memberIdCheckTimeout = setTimeout(function() {
        fetch(`/api/members/checkUsername?username=${username}`)//요청 주소 변경해야함
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error('중복된 아이디입니다.');
                }
            })
            .then(data => {
                document.getElementById('usernameCheckResult').textContent = data;
            })
            .catch(error => {
                document.getElementById('usernameCheckResult').textContent = error.message;
            });
    }, 500); // 사용자가 타이핑을 멈춘 후 0.5초 뒤에 실행
}