/**
 * Created by jungmini on 2017. 8. 10..
 */
$( document).ready(function () {
    var mallList = {};
    var member_id = null;

        // $.ajax({
        //     type:'GET',
        //     url:'/getMallList',
        //     success : function(result) {
        //         if (!result)
        //             alert("몰 정보들을 가져오는 데에 실패했습니다.");
        //         else {
        //             var html = '';
        //             $.each(result, function(entryIndex, entry) {
        //                 html += '<div class="entry" style="padding:10px">';
        //                 html += '<div class="mallName">' + entry.mall_name + '</div>';
        //                 html += '<img width="100px" src="' + entry.mall_img + '">';
        //                 html += '</div>';
        //
        //             });
        //
        //             $('.mallList').html(html);
        //
        //         }
        //
        //     }
        // });

    $.ajax({
        type:'GET',
        url:'/getMemberInfo',
        success : function(result) {
            if(!result)
                alert("회원 정보를 가져오는 데에 실패했습니다.");
            else {
                $.each(result, function(entryIndex, entry) {

                    member_id = entry.member_id;
                    alert(member_id);
                    console.log(member_id);

                });
            }
        }
    });



    $('#addGatheringBtn').click(function() {
        var gathering_title = $('#gathering_title').val();
        var gathering_host = member_id;
        var gathering_character = $(':radio[name="gathering_character"]:checked').val();
        var gathering_date = $('#gathering_date_1').val();
        var gathering_anonymity = $(':radio[name="gathering_anonymity"]:checked').val();
        // var gathering_category = $('select[name="gathering_category"]:selected').val();
        var gathering_category = $('#gathering_category option:selected').val();
        // var gathering_category = $('select[name="gathering_caregory"]').val();
        // var gathering_age = $('#gathering_age_1').val();
        var gathering_age = "12";
        var gathering_info = {
            'gathering_title' : gathering_title,
            'gathering_host' : gathering_host,
            'gathering_character' : gathering_character,
            'gathering_date' : gathering_date,
            'gathering_anonymity' : gathering_anonymity,
            'gathering_category' : gathering_category,
            'gathering_age' : gathering_age
        };

        console.log(gathering_title, gathering_host, gathering_character, gathering_date, gathering_anonymity, gathering_category, gathering_age);

        $.ajax({
            type:'POST',
            url:'/addGathering',
            dataType: 'json',
            contentType: 'application/json',
            data : JSON.stringify(gathering_info),
            success : function(result) {
                console.log(result);
                if(result['code'] != '0000')
                    alert(result['msg']);
                else {
                    alert(result['msg']);
                }
            }
        });
    });
    });
