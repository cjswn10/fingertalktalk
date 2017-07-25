$( document ).ready(function() {
    var mallList = {};
    $.ajax({
        type:'GET',
        url:'/getMallList',
        success : function (oResult) {
            if(!oResult)
                alert("등록된 몰 정보가 없습니다.");
            else {
                var html = '';
                $.each(oResult, function(entryIndex, entry) {
                    html += '<div class="entry" style="padding:10px">';
                    html += '<div class="mallName">' + entry.mall_name +  '</div>';
                    html += '<img width="100px" src="' + entry.mall_img + '">';
                    html += '</div>';
                });
                $('.mallList').html(html);
            }
        }
    });
});