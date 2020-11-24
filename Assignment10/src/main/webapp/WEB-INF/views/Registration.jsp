<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style= "text-align:center;">Register</h1>

<table style = "margin-left: autp; margin-right: auto;">
<form action="/auth/login.html" method="post">
<tr>
<td>UserName
</td>
<td><input type="text" name="userName" /><div>${userName }</div>
</tr>
<tr>
<td>Password
</td>
<td><input type="text" name="password" /><div>${password }</div>
</tr><tr>
<td><label for="position">Choose your position:</label>

<select name="position" id="position">
  <option value="Development">Development</option>
  <option value="Production">Production</option>
  <option value="Testing">Testing</option>
</select></td></tr>
<tr>
<td><input type="submit"/></td>
</tr>
</table>


</body>
</html>