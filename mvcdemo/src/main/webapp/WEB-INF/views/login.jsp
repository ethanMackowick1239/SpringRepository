<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style= "text-align: center">Login Page</h1>

<table  style="margin-left:auto; margin-right:auto; border: 1px solid black">
<form action="/auth/login.html" method="post">
<tr>
<td >User Name:</td>
<td><input type="text" name="userName" /><div>${userName }</div>
</tr>
<tr>
<td>Password: </td>
<td><input type="text" name="password" style="text-align:center" /><div>${password }</div>
</tr><tr>
<td><input type="submit"/></td></tr>
</form>
</table>
</body>
</html>