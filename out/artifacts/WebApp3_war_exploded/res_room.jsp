<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 12/16/2019
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>res room</title>
</head>
<body>
<form action="/res_room" method ="post">

    <div>
        <Label> ENTER A ROOM NO
            <input type="number" name="no">
        </label>
    </div>
    <div>
        <Label> PLEASE ENTER A DATE
            <input type="text" name="date">
        </label>
    </div>
    <div>
        <Label> START TIME
            <input type="number" name="stime">
        </label>
    </div>
    <div>
        <Label> END TIME
            <input type="number" name="etime">
        </label>
    </div>
    <div>
        <input type = "submit" value = "reserve">
    </div>
</form>


</body></html>
