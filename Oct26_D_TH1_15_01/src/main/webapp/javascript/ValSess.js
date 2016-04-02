function valSessFunc(){
	var obj;
	if (window.XMLHttpRequest) {
	    obj = new XMLHttpRequest();
	    } else {
	    obj = new ActiveXObject("Microsoft.XMLHTTP");
		}
		obj.onreadystatechange = function () {
			if(obj.readyState == 4 && obj.status == 200){
				var result = obj.responseText;
				if(result=="false"){
					document.getElementById("notLogin").style.visibility = "visible";
					document.getElementById("alreadyLogin").style.visibility = "hidden";
					document.getElementById("dashLink").href = "";
					}else if(result=="superAdmin"){
					document.getElementById("notLogin").style.visibility = "hidden";
					document.getElementById("alreadyLogin").style.visibility = "visible";
					document.getElementById("dashLink").href = "Super_Admin_Dboard.jsp";
					}else if(result=="subAdmin"){
					document.getElementById("notLogin").style.visibility = "hidden";
					document.getElementById("alreadyLogin").style.visibility = "visible";
					document.getElementById("dashLink").href = "Sub_Admin_Dboard.jsp";
					}
				}
			};
		obj.open("POST", "ValidateSession", true); 
		obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		obj.send(null);
}

function loginUser(){
	var orgId = document.getElementById("user_cmpname").value;
	var uname = document.getElementById("user_username").value;
	var upass = document.getElementById("user_password").value;
	var isnum = /^\d+$/.test(orgId);
	if(isnum){
		var obj;
		if (window.XMLHttpRequest) {
		    obj = new XMLHttpRequest();
		    } else {
		    obj = new ActiveXObject("Microsoft.XMLHTTP");
		}
		obj.onreadystatechange = function () {
			if(obj.readyState == 4 && obj.status == 200){
				var result = obj.responseText;
				if(result == "superadmin") window.location="Super_Admin_Dboard.jsp";
				else if(result == "subadmin") window.location="Sub_Admin_Dboard.jsp";
				else document.getElementById("loginError").innerHTML = "<font color='red'>"+obj.responseText+"</font>";
			}
		};
		obj.open("POST", "LoginServlet"); //change full path of validateSession servlet
		obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		obj.send("orgId="+orgId+"&userId="+uname+"&password="+upass);
	}
	else {
		document.getElementById("loginError").innerHTML = "<font color='red'>Company ID can only be a number</font>";
	}
}