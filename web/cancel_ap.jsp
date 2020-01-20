<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 12/21/2019
  Time: 1:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>make appointment</title>
</head>
<body>
<form action="/cancel_ap" method ="post">

    <div>
        <Label> PLEASE ENTER YOUR DOCTOR USERNAME
            <input type="text" name="d_username">
        </label>
    </div>
    <div>
        <Label> APPOINTMENT DATE[yyyy/mm/dd]
            <input type="text" name="date" placeholder="YYYY-MM-DD" required>
        </label>

        <Label> APPOINTMENT TIME[hh:mm:ss]
            <input type="text" name="time" placeholder="hh:mm:ss" required>
        </label>
    </div>
    <div>
        <input type = "submit" value = "save">
    </div>
</form>
</body></html>