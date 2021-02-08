<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
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
