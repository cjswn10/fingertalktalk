/**
 * Created by YJ on 2017-07-25.
 */
$( document).ready(function() {
    $('#joinBtn').click(function () {

        var id = $('#id').val();
        var pw = $('#pw').val();
        var name = $('#name').val();
        var phone = $('#phone').val();
        var member_data = {
            'member_id' : id,
            'member_pw' : pw,
            'member_name' : name,
            'member_phone' : phone
        };
        console.log(id, pw, name, phone);


        $.ajax({
            type:'POST',
            url:'/addMember',
            dataType: 'json',
            contentType: 'application/json',
            data : JSON.stringify(member_data),
            success : function(result) {
                console.log(result)
                if(result['code'] != '0000')
                    alert(result['msg']);
                else {
                    alert(result['msg']);
                    window.location.href = 'index.html';
                }
            }

        });
    });
});