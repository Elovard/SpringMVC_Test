<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<a href="/calc">Calculator</a>
<br>
<a href="/history">History</a>
<br>
<form action="/calc" method="post">
    <input type="number" name="num1" value="num1">
    <input type="number" name="num2" value="num2">
    <input type="text" name="operation">
    <button>Result</button>
</form>
<h3>Here's your result:</h3>
${result}
</body>
</html>
