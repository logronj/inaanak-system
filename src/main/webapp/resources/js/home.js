function getInaanakByUserName(){

	let fname = document.getElementById("inaanak-fname").value;
		console.log('test: ' , fname);
	const url = "http://localhost:8080/inaanak-system/getInaanak/" + fname;
	
	$('#exampleModal').modal({show: false});
	
	
	$.get(url,function(data,status){
			console.log(`${data}`);
			if(`${data}`){
				$('#inaanak-found-modal').modal('show');
				document.getElementById("inaanak-fname").disabled = true;
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
