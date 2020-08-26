<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel = "stylesheet" href= "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

<form action="insert" class="container bg-info">
<!-- insert is the name of servlet in controller -->

<div class="form-group">
<label for="e_id">Employee ID</label>
<input type="text" id="e_id" name="e_id" class="form-control">
</div>

<div class="form-group">
<label for="e_n">Employee Name</label>
<input type="text" id="e_n" name="e_name" class="form-control">
</div>

<div class="form-group">
<label for="e_c">Employee City</label>
<input type="text" id="e_c" name="e_city" class="form-control">
</div>

<div class="form-group">
<label for="e_d">Employee Department</label>
<input type="text" id="e_d" name="e_dept" class="form-control">
</div>

<div class="form-group">
<label for="e_e">Employee Email</label>
<input type="text" id="e_e" name="e_email" class="form-control">
</div>

<button type="submit " class="btn btn-success">Insert Record</button>


</form>

</body>
</html>