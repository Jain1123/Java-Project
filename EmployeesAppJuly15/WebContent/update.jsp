<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import = "com.cestar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel = "stylesheet" href= "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>

<%

  Employee emp = (Employee)session.getAttribute("emp");

  //out.print(emp);

%>

  <form action="update" class= "bg-success container">
  
   <div class="form-group">   
   <label for="e_id">Update Employee ID:</label>
   <input type = "text" class="form-control" id="e_id" name="e_id" value="<%=emp.getId()%>">
   </div>
  
   <div class="form-group">
   <label for="e_name">Update Employee Name:</label>
   <input type = "text" class="form-control" id="e_name" name="e_name" value="<%=emp.getName()%>">
   </div>
 
   <div class="form-group">   
   <label for="e_city">Update City:</label>
   <input type = "text" class="form-control" id="e_city" name="e_city" value="<%=emp.getCity()%>">
   </div>
   
   <div class="form-group">
   <label for="e_dept">Update Department:</label>
   <input type = "text" class="form-control" id="e_dept" name="e_dept" value="<%=emp.getDepartment()%>">
   </div>
   
   <div class="form-group">
   <label for="e_email">Update Email:</label>
   <input type = "text" class="form-control" id="e_email" name="e_email" value="<%=emp.getEmail()%>">
   </div>
  
   <button class="btn btn-success" type="submit" role="button">Update Records</button>
    
  </form>
    
</body>
</html>