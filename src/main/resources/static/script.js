var stompClient = null;
var datetime = null;
function time(){ datetime = new Date().toLocaleTimeString();}

setInterval(time,1000);

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#userinfo").html("");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        $("#welcome").text("Welcome " + $("#name-value").val() );
        $("#fullpage").removeClass('d-none');
        $("#name-from").addClass('d-none');

        stompClient.subscribe('/topic/user', function (greeting) {

            showGreeting(JSON.parse(greeting.body).name, JSON.parse(greeting.body).content);
        });
        stompClient.send("/app/notify", {}, JSON.stringify({'name': $("#name-value").val() + ' has joined the Chat', 'message': ')'}));

    });
}

function disconnect() {
    if (stompClient !== null) {

        stompClient.send("/app/notify", {}, JSON.stringify({'name': $("#name-value").val() + ' has left the Chat','message': ')'}));
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
    $("#fullpage").addClass('d-none');
    $("#name-from").removeClass('d-none');

}

function sendName() {
    /*stompClient.send("/app/message", {}, JSON.stringify({'message': $("#message").val()}) );*/
    stompClient.send("/app/message", {}, JSON.stringify({'name': $("#name-value").val(),'message': $("#message").val()}));
}

function showGreeting(name, message) {

    $("#userinfo").prepend("<tr><td>"+ datetime +"</br><strong>"+ name +"</strong> : "+ message + "</td></tr>");
    //$("#userinfo").append("<tr><td>"+  message + "</td></tr>");

}
$(function () {
    $("form").on('submit', function (e) {
            e.preventDefault();
    });
    $( "#connect" ).click(function(){
        if ($.trim($("#name-value").val()) === "") {
            alert('Please enter your name');
        }else
        {
            connect();
        }
    });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#sendName" ).click(function() { sendUserName(); });
});
