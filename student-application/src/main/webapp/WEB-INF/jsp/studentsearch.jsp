<%@page import="com.javaTpoint.model.StudentName" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>

<body>
    <h1>Student Detail</h1>
    <table border="1">
    
    <tr>
  <th><center>Student Id</center></th>
    <th><center>Student Name</center></th>
     </tr>
     <% StudentName al=(StudentName)request.getAttribute("ss");
   
     StudentName sn=new StudentName();
     {
    	 
     sn=(StudentName)al;%>
     
    	 <tr>
    	 
    	 <td><center><%=sn.getId() %></center></td>
    	 <td><center><%=sn.getName()%></center></td>
    	 
   </tr>
    	 
    <%}%> 
     
  </table>
</body>
    </html>