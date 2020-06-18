<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer create</title>
</head>
<body>
<form action="CustomerCreateServlet" method="post">
<table>

<tr>
<td>Customer SSN Id</td>
<td><input type="text" name="ssnid" /></td>
</tr>

<tr>
<td>Customer Name</td>
<td><input type="text" name="name" /></td>
</tr>

<tr>
<td>AGE</td>
<td><input type="text" name="age" /></td>
</tr>

<tr>
<td>Address</td>
<td><input type="type" name="address" /></td>
</tr>

<tr><td>
<label for="state">State:</label>
  <select name="state" id="cars">
    <option value="kerala">kerala</option>
    <option value="tamilnad">tamilnad</option>
    <option value="karnatakaa">karnataka</option>
    <option value="up">UP</option>
  </select></td></tr>
  <br>
  
  <tr><td>
<label for="city">State:</label>
  <select name="city" id="cars">
    <option value="kerala">kerala</option>
    <option value="tamilnad">tamilnad</option>
    <option value="karnatakaa">karnataka</option>
    <option value="up">UP</option>
  </select></td></tr>
  <br>

<tr>
<td><input type="submit" name="submit" value="submit" /></td>
<td><input type="reset" /></td>
</tr>

</table>
</form>

</body>
</html>