<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${message}</h2>
<jsp:useBean id="product" class="org.inventory.manager.model.Product" scope="request"></jsp:useBean>
<table>
 <tr>
    <th>Firstname</th>
    <th>Lastname</th> 
    <th>Age</th>
  </tr>
  <tr>
    <td><jsp:getProperty property="name" name="product"/></td>
    <td><jsp:getProperty property="company" name="product"/></td> 
    <td><jsp:getProperty property="quantity" name="product"/></td>
  </tr>
</table>
</body>
</html>