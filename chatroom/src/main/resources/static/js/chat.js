
var _messageIndex = 0;

window.onload = function () {
    //alert("hello...");
    var sendButton = document.getElementById("send");
    var userName = document.getElementById("userName");
    var message = document.getElementById("message");
    var chatPane = document.getElementById("chatRoomPane");

    sendButton.onclick = function () {
        var userVal = userName.value;
        if( !userVal || userVal.length == 0) {
            alert("Please enter a user name...");
        }
        var messageText = message.value;
        if( !messageText || messageText.length == 0) {
            alert("Please enter a message...");
        }
        var xhttp = new XMLHttpRequest();
        var payLoad = "userName={userName}&text={text}";
        payLoad = payLoad.replace("{userName}", userVal);
        payLoad = payLoad.replace("{text}", messageText);
        xhttp.open("GET", "/chat/postmessage?"+payLoad, true);
        xhttp.send();
    }

    function paintPendingMessages() {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/chat/getmessages?"+"index="+_messageIndex, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if(this.readyState != 4) {
                return;
            }
            var messagesInfo = JSON.parse(this.responseText);
            var messObj;
            var chatText;
            var messArray = messagesInfo.messages;
            for( mIndex in messArray) {
                messObj = messArray[mIndex];
                chatText= "<b>"+messObj.userName+"</b>";
                chatText+= messObj.text;
                chatPane.innerHTML+= chatText;
                chatPane.innerHTML+="<br/>";
            }

            _messageIndex = messagesInfo.currentMessageIndex;

        }
    }

    setInterval(paintPendingMessages, 2000);


}