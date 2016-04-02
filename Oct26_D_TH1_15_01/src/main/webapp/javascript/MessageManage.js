function getMessage(messageType){
	
	//Clearing previous data
	document.getElementById("birthday_text").value = '';
	document.getElementById('add_msg_birthday').innerHTML = "Add Message";
	document.getElementById("anniversary_text").value = '';
	document.getElementById('add_msg_anniversary').innerHTML = "Add Message";
	document.getElementById('add_msg_birthday').value = '';
	document.getElementById('add_msg_anniversary').value = '';
	
	var messageQuote = '"'.concat(messageType);
	messageQuote = messageQuote.concat('"');
	
	var obj;
	if (window.XMLHttpRequest) {
	    obj = new XMLHttpRequest();
	    } else {
	    obj = new ActiveXObject("Microsoft.XMLHTTP");
	}
	obj.onreadystatechange = function() {
		if(obj.readyState == 4 && obj.status == 200){
			var i = 0;
			var table = '';
			var result = obj.responseXML;
			var message = result.getElementsByTagName("MESSAGE");
			for(i = 0;i < message.length;i++){
				var id = message[i].getElementsByTagName("ID")[0].childNodes[0].nodeValue;
				var concatId = messageType.concat(id);
				table += "<tr>" +
						"<td id='"+concatId+"'>"+message[i].getElementsByTagName("TEXT")[0].childNodes[0].nodeValue+"</td>" +
						"<td><button type='button' onclick='editMessage("+messageQuote+","+id+")' class='btn btn-success' id='edit_msg"+id+"' value='"+id+"'>Edit</button></td>" +
						"<td><button type='button' onclick='deleteMessage("+messageQuote+","+id+")' class='btn btn-success btn-danger' id='edit_msg"+id+"' value='"+id+"'>Delete</button></td>" +
						"</tr>";
			}
			document.getElementById(messageType).innerHTML = table;
		}
	};
	obj.open("POST", "GetWishMessages", true);
	obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	obj.send("messageType="+messageType);
	
}


function editMessage(messageType, id){
	var concatId = messageType.concat(id);
	if(messageType == 'messages_birthday'){
		document.getElementById("birthday_text").value = document.getElementById(concatId).innerHTML;
		document.getElementById('add_msg_birthday').innerHTML = "Update Message";
		document.getElementById('add_msg_birthday').value = id;
		
	}
	else if(messageType == 'messages_anniversary'){
		document.getElementById("anniversary_text").value = document.getElementById(concatId).innerHTML;
		document.getElementById('add_msg_anniversary').innerHTML = "Update Message";
		document.getElementById('add_msg_anniversary').value = id;
	}

}

function deleteMessage(messageType, id){
	var proceed = window.confirm("Delete this message ? ");
	if(proceed == true){
		var obj;
		if (window.XMLHttpRequest) {
		    obj = new XMLHttpRequest();
		    } else {
		    obj = new ActiveXObject("Microsoft.XMLHTTP");
		}
		obj.onreadystatechange = function() {
			if(obj.readyState == 4 && obj.status == 200){
				getMessage(messageType);
			}
		};
		obj.open("POST", "DeleteWishMessages", true);
		obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		obj.send("messageType="+messageType+"&id="+id);
	}
}


//function of deciding whether its add or update request
function modifyMessage(messageType){
	
	if(messageType == 'messages_birthday'){
		if(document.getElementById('add_msg_birthday').innerHTML == "Add Message"){
			addMessage(messageType);
		}
		else if(document.getElementById('add_msg_birthday').innerHTML == "Update Message"){
			updateMessage(messageType);
		}
	}
	else if(messageType == 'messages_anniversary'){
		if(document.getElementById('add_msg_anniversary').innerHTML == "Add Message"){
			addMessage(messageType);
		}
		else if(document.getElementById('add_msg_anniversary').innerHTML == "Update Message"){
			updateMessage(messageType);
		}
	}
}

//Message addition
function addMessage(messageType){
	
	var message_text = '';
	
	if(messageType == 'messages_birthday'){
		message_text = document.getElementById("birthday_text").value;
	}
	else message_text = document.getElementById("anniversary_text").value;
	
	var obj;
	if (window.XMLHttpRequest) {
	    obj = new XMLHttpRequest();
	    } else {
	    obj = new ActiveXObject("Microsoft.XMLHTTP");
	}
	obj.onreadystatechange = function() {
		if(obj.readyState == 4 && obj.status == 200){
			getMessage(messageType);
		}
	};
	
	obj.open("POST", "AddWishMessages", true);
	obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	obj.send("messageType="+messageType+"&messageText="+message_text);
	
}



//Message updation
function updateMessage(messageType, id){
	var message_text = '';
	var id = '';
	
	if(messageType == 'messages_birthday'){
		message_text = document.getElementById("birthday_text").value;
		id = document.getElementById("add_msg_birthday").value;
	}
	else {
		message_text = document.getElementById("anniversary_text").value;
		id = document.getElementById("add_msg_anniversary").value;
	}
	
	var obj;
	if (window.XMLHttpRequest) {
	    obj = new XMLHttpRequest();
	    } else {
	    obj = new ActiveXObject("Microsoft.XMLHTTP");
	}
	obj.onreadystatechange = function() {
		if(obj.readyState == 4 && obj.status == 200){
			getMessage(messageType);
		}
	};
	obj.open("POST", "EditWishMessages", true);
	obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	obj.send("messageType="+messageType+"&messageText="+message_text+"&id="+id);
	
}