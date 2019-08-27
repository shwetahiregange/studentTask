<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.javaTpoint.model.StudentName" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
<form action="Addition" method="post">
  <h3>Add Students</h3>
   Student ID: <input type="text" name="id"  required="required" />
    student Name : <input type="text" name="name" required="required"/>
    <input type="submit" value="ADD">
    </form>
</body>

</html>