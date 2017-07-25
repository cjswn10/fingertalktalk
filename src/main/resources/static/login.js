/**
 * Created by YJ on 2017-07-25.
 */
$( document ).ready(function() {
    $('#loginBtn').click(function () {
        var id = $('#id').val();
        var pwd = $('#password').val();console.log(id,pwd);
        var member_data = {
          'member_id' : id,
            'member_pw' : pwd
        };
        //'type' : 이렇게 쓰는 방법 찾아보기
        $.ajax({
            type:'POST',
            url:'/validateMember',
            dataType: 'json',   //400error 써줘요
            contentType: 'application/json',    //400error 써줘요
            data : JSON.stringify(member_data), //400error 이렇게 써줘요
            success : function (result) {
                console.log(result)
                if(result['code'] != '0000')
                    alert(result['msg']);
                else
                    window.location.href='home.html';
            }

        });
    });


});