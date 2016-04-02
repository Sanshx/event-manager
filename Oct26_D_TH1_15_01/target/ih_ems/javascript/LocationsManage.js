function addLocation(){
	var country = document.getElementById("country");
	var selectedCountry = country.options[country.selectedIndex].innerHTML;
	var city = document.getElementById("city").value;
	city = city.replace('&','and');
	var address = document.getElementById("address").value;
	address = address.replace('&','and');
	var timezone = document.getElementById("timezone").value;
	
	var ajaxObj;
	if (window.XMLHttpRequest) {
	    ajaxObj = new XMLHttpRequest();
	    } else {
	    ajaxObj = new ActiveXObject("Microsoft.XMLHTTP");
	}
	ajaxObj.open("post","ModifyLocations",true);
	ajaxObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	ajaxObj.onreadystatechange = function(){
		if(ajaxObj.readyState == 4 && ajaxObj.status == 200){
			alert(ajaxObj.responseText);
		}
	};
	ajaxObj.send("country="+selectedCountry+"&city="+city+"&address="+address+"&timezone="+timezone);
}


function deleteLocation(){
	var locationId = document.getElementById("deleteLocation").value;
	var ajaxObj;
	if (window.XMLHttpRequest) {
	    ajaxObj = new XMLHttpRequest();
	    } else {
	    ajaxObj = new ActiveXObject("Microsoft.XMLHTTP");
	}
	ajaxObj.open("post","RemoveLocations",true);
	ajaxObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	ajaxObj.onreadystatechange = function(){
		if(ajaxObj.readyState == 4 && ajaxObj.status == 200){
			alert(ajaxObj.responseText);
			getLocations('deleteLocation');
		}
	};
	ajaxObj.send("locationId="+locationId);
}


