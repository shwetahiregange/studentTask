<%@page import="com.javaTpoint.model.StudentName" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
</head>

<body>
    <h1>Index page</h1>
    <table border="1">
    
    <tr>
    <th><center>Student Id</center></th>
    <th><center>Student Name</center></th>
     </tr>
     <% ArrayList <StudentName> al=(ArrayList<StudentName>)request.getAttribute("tt");
     Iterator itr= al.iterator();
     StudentName sn=new StudentName();
     while(itr.hasNext()){
    	 sn=(StudentName)itr.next();%>
    	 <tr>
    	 
    	 <td><center><%=sn.getId() %></center></td>
    	 <td><center><%=sn.getName() %></center></td>
    	 <td><center><a href="/updateStud">Update</a></center></td>
    	 <td><center><a href="/deleteStud">Delete</a></center></td>
    	 
   </tr>
    	 
    <% }%> 
     
    
    
    
    </table>
</body>
    </html>