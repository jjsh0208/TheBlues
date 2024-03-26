document.addEventListener("DOMContentLoaded", function() {
    var toggleElements = document.querySelectorAll('.Board_active, .Membership_active');

    toggleElements.forEach(function(elem) {
        elem.addEventListener('click', function() {
            var tabWrap = this.nextElementSibling; // 바로 다음 형제 요소인 .tab_wrap을 선택합니다.

            if (tabWrap.classList.contains('active')) {
            tabWrap.classList.remove('active');
            }
            else {// 모든 .tab_wrap 요소들의 active 클래스를 제거하고, 클릭된 요소만 active 클래스 추가
                document.querySelectorAll('.tab_wrap').forEach(function(el) {
                el.classList.remove('active');
                });
                tabWrap.classList.add('active');
            }
        });
    });
});

