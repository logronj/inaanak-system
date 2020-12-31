function getInaanakByUserName(){

	let fname = document.getElementById("inaanak-fname").value;
	const url = "http://localhost:8080/inaanak-system/getInaanak/" + fname;

//	const url = "https://inaanak-system.herokuapp.com/getInaanak/" + fname;
	
	$('#exampleModal').modal({show: false});
	
	
	$.get(url,function(data,status,xhr){
			
			if(`${data}` == 'error'){
				$('#internal-error-modal').modal('show');
				return;
			}
			
			if(`${data}`){
				$('#inaanak-found-modal').modal('show');
				enableOtherFields();
			}else{
				$('#inaanak-notfound-modal').modal('show');
			}
			
		});
	
}

function enableOtherFields(){

	document.getElementById("inaanak-mname").disabled = false;
	document.getElementById("inaanak-lname").disabled = false;
	
	document.getElementById("ninong-fname").disabled = false;
	document.getElementById("ninong-mname").disabled = false;
	document.getElementById("ninong-lname").disabled = false;
	
	document.getElementById("ninong-favorites").disabled = false;
	document.getElementById("ninong-kind").disabled = false;
	document.getElementById("submit-btn").disabled = false;
	
}
