$(document).ready(function(){
    $("#sendBtn").click(function(){
        sendMessage();
        $('#message').val('');
    });

    $("#exitBtn").click(function () {
        sock.close();
    });
});

var sock;
//웸소켓을 지정한 url로 연결한다.
sock = new SockJS("/echojs");

//자바스크립트 안에 function을 집어넣을 수 있음.
//데이터가 나한테 전달되읐을 때 자동으로 실행되는 function
sock.onmessage=onMessage;

//데이터를 끊고싶을때 실행하는 메소드
 sock.onclose = onClose;

sock.onopen = function(){
    sock.send("1");
};
function sendMessage(){
    /*소켓으로 보내겠다.  */
    sock.send($("#message").val());
}
//evt 파라미터는 웹소켓을 보내준 데이터다.(자동으로 들어옴)
function onMessage(evt){
    var data = evt.data;
    $("#data").append(data+"<br/>");
    //sock.close();
}

function onClose(evt){
    $("#data").append("다음에 봐요~");
}