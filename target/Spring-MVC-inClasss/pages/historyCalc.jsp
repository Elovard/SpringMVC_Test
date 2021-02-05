<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/calc">Calculator</a>
<br>
<a href="/history">History</a>
<br>
<h3>Your history:</h3>
<div class="container">
    <ul>
        <table>
            <c:forEach var="result" items="${results}" >
                <tr><td><c:out value="${result}"/>
                </td></tr>
            </c:forEach>
        </table>
    </ul>
</div>
</body>
</html>
