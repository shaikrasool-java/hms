<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PurchaseOrder Registration Page</title>
<style type="text/css">
fieldset { 
    display: block;
    margin-left: 300px;
    margin-right: 300px;
    padding-top: 0.35em;
    padding-bottom: 1em;
    padding-left: 0.75em;
    padding-right: 0.75em;
    border: 2px groove (internal value);
}
.err
{
color:red;
font: bold;
align-content: center;
}
</style>
</head>
<body>
	<h2 style="color: red; text-align: center">PurchaseOrder Registration</h2>
	<form:form action="save" method="post" modelAttribute="purchaseOrder">
		<fieldset>
		<legend style="color:blue" align="top">Item</legend>
		<pre>
		Order Code       :<form:input path="ordCode"/>        
		<form:errors path="ordCode" cssClass="err"/><br>
		Shipment Code    :<form:select path="shipment.id">
						<form:option value="">--SELECT--</form:option>
						<form:options items="${shipments}" itemLabel="code" itemValue="id"/>	
						</form:select>
		<form:errors path="shipment" cssClass="err"/><br>
		Shipment Code    :<form:select path="vendor.id">
						<form:option value="">--SELECT--</form:option>
						<form:options items="${venUsers}" itemLabel="code" itemValue="id"/>	
						</form:select>
		<form:errors path="vendor" cssClass="err"/><br>
		Reference Number :<form:input path="refNo"/>
		<form:errors path="refNo" cssClass="err"/><br>
		Quality Check    :<form:radiobutton path="qtyCheck" value="Required"/>Required  <form:radiobutton path="qtyCheck" value="NotRequired"/>Not Required
		<form:errors path="qtyCheck" cssClass="err"/><br>
		Default Status   :<form:input path="status" value="OPEN" readOnly="true"/><br><br>
		Description      :<form:textarea path="dsc"/>
		<form:errors path="dsc" cssClass="err"/><br>
				<input type="submit" value="Register" />	
		</pre>	
		</fieldset>
		
	</form:form>
	${message}
</body>
</html>