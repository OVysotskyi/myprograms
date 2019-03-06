<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Guest book Book</title>
</head>
<style>
    select {
        width: 100%;
    }
</style>
<body>
<center>
    <form method="post" action="guestbook">
        <table cellspacing="0" cellpadding="4">
            <tr>
                <td align="right" width="100">Enter your name:</td>
                <td><input type="text" name="name" size="55" required></td>
            </tr>
            <tr>
                <td align="right">Your rating:</td>
                <td>
                    <select name="rating" required>
                        <option avtofocus>-</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right" valign="top">Your comment:</td>
                <td><textarea name="comment" cols="55" rows="10" required></textarea></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Comment"></td>
            </tr>
        </table>
    </form>
    <table border="1">
        <tr>
            <th>№</th>
            <th>Name</th>
            <th>Rating</th>
            <th>Comment</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${feedbacks}" var="item">
            <tr>
                <td style="text-align: center;"><c:out value="${item.id}"></c:out></td>
                <td><c:out value="${item.name}"></c:out></td>
                <td style="text-align: center;"><c:out value="${item.rank}"></c:out></td>
                <td style="width: 350px; word-wrap: break-word;"><c:out value="${item.text}"></c:out></td>
                <td>
                    <fmt:parseDate value="${item.date}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="HH:mm dd.MM.yyyy" value="${ parsedDateTime }" />
                </td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>