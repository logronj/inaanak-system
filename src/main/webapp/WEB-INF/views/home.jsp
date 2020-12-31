<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="include.jsp"/>
</head>
<body>

	<form:form modelAttribute="formDetails" action="submit">
		<div class="text-center container">
			
			<div class="form-title">
				<img class="fb-pic" src="<c:url value="/resources/images/fb_pic.jpg" />" ><h1>Gaano mo kakilala si Ninong?</h1>
				<p>Bawat tamang sagot ay may kalakip na pera</p>
			</div>
			
			<div class="row form-group">
				<h4 class="inaanakName">Pangalan ng Inaanak</h4>
				<div class="col-md-3">
					<label>First Name</label> 
					<form:input id="inaanak-fname" type="text" minlength="3" maxlength="20" path="inaanak.firstName" cssClass="form-control" autocomplete="false"/>
					
				</div>
				<div class="col-md-3">
					<label>Middle Name</label> 
					<form:input id="inaanak-mname" type="text" minlength="3" maxlength="20" path="inaanak.middleName" cssClass="form-control" autocomplete="false"
					disabled = "true"/>
					<form:errors path="inaanak.middleName" cssClass="error m-0 p-0"></form:errors>
				</div>
				<div class="col-md-3">
					<label>Last Name</label> 
					<form:input id="inaanak-lname" type="text" minlength="3" maxlength="20" path="inaanak.lastName" cssClass="form-control" autocomplete="false"
					disabled="true"/>
					<form:errors path="inaanak.lastName" cssClass="error m-0 p-0"></form:errors>
				</div>
				<div class="col-md-3">
					<button type="button" class="btn btn-success search-btn" onclick="getInaanakByUserName()">Search</button>
				</div>
			</div>
			
			<div class="row form-group">
				<h4 class="ninongName">1. Ano ang buong pangalan ni Ninong? <span class="amount">50.00</span></h4>
				<div class="col-md-4">
					<label>First Name</label> 
					<form:input id="ninong-fname" type="text" minlength="3" maxlength="20" path="ninong.firstName" cssClass="form-control" autocomplete="false"
					disabled="true"/>
					<form:errors path="ninong.firstName" cssClass="error m-0 p-0"></form:errors>
				</div>
				<div class="col-md-4">
					<label>Middle Name</label> 
					<form:input id="ninong-mname" type="text" minlength="3" maxlength="20" path="ninong.middleName" cssClass="form-control" autocomplete="false"
					disabled="true"/>
					<form:errors path="ninong.middleName" cssClass="error m-0 p-0"></form:errors>
				</div>
				<div class="col-md-4">
					<label>Last Name</label> 
					<form:input id="ninong-lname" type="text" minlength="3" maxlength="20" path="ninong.lastName" cssClass="form-control" autocomplete="false"
					disabled="true"/>
					<form:errors path="ninong.lastName" cssClass="error m-0 p-0"></form:errors>
				</div>
			</div>
			
			<div class="row form-group">
				<h4 class="favorites">2. Dahil hindi umiinom ng alak at kumakain ng pulutan si Ninong, anong paboritong pagkain at inumin ni Ninong? 
				<span class="amount">100.00</span></h4>
				<textarea id="ninong-favorites" rows="3" cols="2" maxlength="500" path="favoriteFoodAndDrinks" disabled="true"></textarea>
				<form:errors path="favoriteFoodAndDrinks" cssClass="error m-0 p-0"></form:errors>
			</div>
			
			<div class="row form-group">
				<h4 class="isNinongKind">3. Mabait ba si Ninong? Bakit? <span class="amount">200.00</span></h4>
				<textarea id="ninong-kind" rows="5" cols="2" maxlength="500" path="isNinongKind" disabled="true"></textarea>
				<form:errors path="isNinongKind" cssClass="error m-0 p-0"></form:errors>
			</div>
			
			<div class="row form-group">
				<h1 class="bonus">Bonus <span class="amount">500.00</span></h1>
				<label>Kung nakausap mo si Ninong ng sampung beses o pataas sa buong taon.</label>
			</div>
			
			
			
			<div class="form-group text-center">
				<div class="col-md-12"><button id="submit-btn" class="btn btn-primary" disabled="true">Submit</button></div>
			</div>
			
		</div>

	<!-- For refactor -->
	<div class="modal fade" id="inaanak-notfound-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel" styles="color:red ; font-weight: bold">Inaanak Not Found</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <img alt="baby" class="baby-nf" src="<c:url value="/resources/images/inaanak-notfound.jpg"/>">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- For refactor -->
	<div class="modal fade" id="inaanak-found-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel" styles="color:red ; font-weight: bold">Inaanak Found</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <img alt="baby" class="baby-nf" src="<c:url value="/resources/images/inaanak-found.jpg"/>">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" id="internal-error-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel" styles="color:red ; font-weight: bold">Internal Server Error</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <img alt="baby" class="baby-nf" src="<c:url value="/resources/images/inaanak-notfound.jpg"/>">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	</form:form>
	

	
	<script type="text/javascript" src="<c:url value="/resources/js/home.js"/>"></script>
</body>
</html>