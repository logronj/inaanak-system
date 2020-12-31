<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="include.jsp"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<title>Confirmation</title>
</head>
<body>
	<div class="container text-center">
		
		<p class="submit-sucessful">Successfully submitted form! </p>
		
		<p>${formDetails.inaanak.firstName} pls wait for Ninong ${formDetails.ninong.firstName} to verify your inputs</p>
	
		<p class="happy"> Thanks ! Happy New Year <i class="fa fa-glass-cheers"></i> !</p>
		<p> Mahal ka ni Ninong <i class="fa fa-heart fa-2x"></i></p>
		
	</div>

	
</body>
</html>