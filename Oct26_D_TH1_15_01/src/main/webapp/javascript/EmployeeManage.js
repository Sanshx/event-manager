function findEmployee(){
	var empId = document.getElementById("emp_id").value;
	if(empId != ""){
		var ajaxObj;
		if (window.XMLHttpRequest) {
		    ajaxObj = new XMLHttpRequest();
		    } else {
		    ajaxObj = new ActiveXObject("Microsoft.XMLHTTP");
		}
		ajaxObj.onreadystatechange = function() {
			if(ajaxObj.readyState == 4 && ajaxObj.status == 200){
				var response = ajaxObj.responseXML;
				if(response!=null){
					
					document.getElementById("emp_id_fixed").value = response.getElementsByTagName("EMP_ID")[0].childNodes[0].nodeValue;
					document.getElementById("emp_fname").value = response.getElementsByTagName("F_NAME")[0].childNodes[0].nodeValue;
					document.getElementById("emp_lname").value = response.getElementsByTagName("L_NAME")[0].childNodes[0].nodeValue;
					document.getElementById("emp_mail").value = response.getElementsByTagName("EMAIL")[0].childNodes[0].nodeValue;
					document.getElementById("emp_tel").value = response.getElementsByTagName("CONTACT")[0].childNodes[0].nodeValue;
					document.getElementById("emp_bday").value = response.getElementsByTagName("BDAY")[0].childNodes[0].nodeValue;
					document.getElementById("emp_wannv").value = response.getElementsByTagName("WA")[0].childNodes[0].nodeValue;
					document.getElementById("emp_location").value = response.getElementsByTagName("LOCATION")[0].childNodes[0].nodeValue;
					document.getElementById("modify_emp_button").innerHTML = "Update Employee";
					//Checking access
					var access = response.getElementsByTagName("ACCESS")[0].childNodes[0].nodeValue;
					if(access == 'NoAccess'){
						document.getElementById("myBtn3b").disabled = true;
						document.getElementById("modify_emp_button").disabled = true;
					}
					else if(access == 'Access'){
						document.getElementById("myBtn3b").disabled = false;
						document.getElementById("modify_emp_button").disabled = false;
					}
					else if(access == 'UpdateAccess'){
						document.getElementById("myBtn3b").disabled = true;
						document.getElementById("modify_emp_button").disabled = false;
					}
					document.getElementById('myBtn3b').style.visibility = 'visible';
				}
				else{
					document.getElementById("modal_modify_emp").reset();
					document.getElementById("emp_id_fixed").value = empId;
					document.getElementById("modify_emp_button").innerHTML = "Add Employee";
					document.getElementById('myBtn3b').style.visibility = 'hidden';
				}
				document.getElementById("emp_id_fixed").disabled = true;
				
			}
		};
		ajaxObj.open("POST", "GetEmployeeData", true);
		ajaxObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		ajaxObj.send("empId="+empId);
	}
	else{
		document.getElementById('myBtn3b').style.visibility = 'hidden';
		document.getElementById("emp_id_fixed").disabled = false;
		document.getElementById("modal_modify_emp").reset();
		document.getElementById("modify_emp_button").innerHTML = "Add Employee";
	}
}



function getLocations(idToFill){
	var obj;
	if (window.XMLHttpRequest) {
	    obj = new XMLHttpRequest();
	    } else {
	    obj = new ActiveXObject("Microsoft.XMLHTTP");
	}
	obj.onreadystatechange = function() {
		if(obj.readyState == 4 && obj.status == 200){
			document.getElementById(idToFill).innerHTML = obj.responseText;
		}
	};
	obj.open("POST", "GetLocations", false);
	obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	obj.send(null);
	
}


function modifyEmployee(){
	var empId = document.getElementById("emp_id_fixed").value; 
	var fname = document.getElementById("emp_fname").value;
	var lname = document.getElementById("emp_lname").value;
	var bday = document.getElementById("emp_bday").value;
	var wa = document.getElementById("emp_wannv").value;
	var locId = document.getElementById("emp_location").value;
	var departId = null;
	var email = document.getElementById("emp_mail").value;
	var contact = document.getElementById("emp_tel").value;
	var option = null;
	
	var buttonData = document.getElementById("modify_emp_button").innerHTML;
	if(buttonData == "Add Employee"){
		option = "Add";
	}
	else if(buttonData == "Update Employee"){
		option = "Update";
	}
	
	var obj;
	if (window.XMLHttpRequest) {
	    obj = new XMLHttpRequest();
	    } else {
	    obj = new ActiveXObject("Microsoft.XMLHTTP");
	}
	obj.onreadystatechange = function() {
		if(obj.readyState == 4 && obj.status == 200){
			alert(obj.responseText);
		}
	};
	obj.open("POST", "ModifyEmployeeData", true);
	obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	obj.send("empId="+empId+"&fname="+fname+"&lname="+lname+"&bday="+bday+"&wa="+wa+"&locId="+locId+"&departId="+departId+"&email="+email+"&contact="+contact+"&option="+option);
	
	
}


function deleteEmployee(){
	var fname =  document.getElementById("emp_fname").value;
	var empId = document.getElementById("emp_id_fixed").value;
	var proceed = window.confirm("Delete "+fname+"\nAre you sure ? ");
	if(proceed == true){
		var obj;
		if (window.XMLHttpRequest) {
		    obj = new XMLHttpRequest();
		    } else {
		    obj = new ActiveXObject("Microsoft.XMLHTTP");
		}
		obj.onreadystatechange = function() {
			if(obj.readyState == 4 && obj.status == 200){
				alert(obj.responseText);
			}
		};
		obj.open("POST", "DeleteEmployee", true);
		obj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		obj.send("empId="+empId);
	}
}




