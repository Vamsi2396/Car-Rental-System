<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
<h2>Update Profile</h2>


<form action=" " method="post">
<table style="width: 50%">
	<tr>
		<td>User Name</td>
		<td><input type="text" name="user_name" id="username"/></td>
	</tr>
	
	<tr>
		<td>Full Name</td>
		<td><input type="text" name="name" id="fullname"/></td>
	</tr>
	

<tr>
		<td>Email</td>
		<td><input type="email" name="Emai" id="email"/></td>
	</tr>	
	
	<tr>
		<td>Phone Number:</td>
		<td><input type="text" name="phno" id="phoneno"/></td>
	</tr>
	
<tr>
		<td>Address</td>
		<td><input type="textarea" rows="4" columns="5" name="addr" id="address"/></td>
	</tr>
<tr>
		<td>Current Password</td>
		<td><input type="password" name="password" id="currentpassword"/></td>
	</tr>
	<tr>
		<td>New Password</td>
		<td><input type="password" name="password" id="newpassword"/></td>
	</tr>
	<tr>
		<td>Confirm Password</td>
		<td><input type="password" name="password" id="confirmpassword"/></td>
	</tr>



</table>
<br>
<br>
<br>
<input type="submit"  name = "submit" value = "Update Profile" /></form>
</body>
</html>