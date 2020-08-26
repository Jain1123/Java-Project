<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.cestar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel = "stylesheet" href= "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">


</head>
<body class="bg-info">

<%

  List<Employee> emps = new ArrayList<>();
  
   emps = (List)session.getAttribute("emps_list");
   
   //out.print(emps);

%>

 <table class= "table table-striped  bg-light"> 
  
  
  <tr class="bg-success">  <th>ID</th> <th>NAME</th> <th>CITY</th> <th>DEPARTMENT</th> <th>EMAIL</th> <th>UPDATE</th> <th>DELETE</th></tr>
  
  <%  
  
   for(Employee emp:  emps ){
	   
	   out.print("<tr> <td>"+emp.getId()+"</td> <td>"+emp.getName()+"</td> <td>"+emp.getCity()+"</td> <td>"+emp.getDepartment()+"</td> <td>"+emp.getEmail()+"</td> <td><a href='edit?e_id="+emp.getId()+"' class = 'btn btn-secondary'>Update</a></td> <td><a href='delete?e_id="+emp.getId()+"' class='btn btn-info'>Delete</a></td></tr>");
	   
   }
  
  
  %>


 </table>
 
 <div class="form-row text-center">
 
 <div class="col-12">
 <a href = "insert.jsp" class= "btn btn-success" >Insert Record</a>
 </div>
 
 </div>

</body>
</html>