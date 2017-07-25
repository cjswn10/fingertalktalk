/**
 * Created by YJ on 2017-07-25.
 */
$( document ).ready(function() {
    $('#test').text('ftFront');


    $('#loginBtn').click(function () {
        var id = $('#id').val();
        var pwd = $('#password').val();

        //'type' : 이렇게 쓰는 방법 찾아보기
        $.ajax({
            type:'POST',
            url:'/getMemberInfo',
            data : {member_id : id},
            success : function (result) {
                console.log(result)
                if(!result)
                    alert("등록되지 않은 정보입니다");
                else
                    window.location.href='home.html';
            }

        });
    });


});