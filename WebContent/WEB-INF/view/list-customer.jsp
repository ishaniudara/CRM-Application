<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

   <link rel="stylesheet" type="text/css"          

            href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>CRM-Customer Relationship Manager</h2></div></div>
<div id="container">
<div id="content">
<input type="button" value="Add Customer" onclick="window.location.href='ShowFormForAdd'; return fasle">
<table>
<tr><th>first name</th>
<th>last name</th>
<th>email</th>
<th>Action</th></tr>
<c:forEach var="tempcustomer" items="${customers}">
<c:url var="updateurl" value="/customer/showformupdate">
<c:param name="customerid" value="${tempcustomer.id}"/>
</c:url>

<c:url var="deleteurl" value="/customer/delete">
<c:param name="customerid" value="${tempcustomer.id}"/>
</c:url>
<tr>
<td>${tempcustomer.firstName }</td>
<td>${tempcustomer.lastName }</td>
<td>${tempcustomer.email }</td>
<td><a href="${updateurl}">Update</a>|</td>
 <td><a href="${deleteurl}" onclick="if(!(confirm('Are you sure want to delete this customer'))) return false">Delete</a></td>
</tr>
</c:forEach>
</table>
</div></div>
</body>
</html>