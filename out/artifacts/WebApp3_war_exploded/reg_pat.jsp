<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 12/10/2019
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<body>
<form action="/reg_pat" method ="post">

    <div>
        <Label> ENTER A USERNAME
            <input type="text" name="username">
        </label>
    </div>
    <div>
        <Label> PLEASE ENTER A PASSWORD
            <input type="password" name="password">
        </label>
    </div>
    <div>
        <Label> FIRST NAME
            <input type="text" name="fname">
        </label>
    </div>
    <div>
        <Label> LAST NAME
            <input type="text" name="lname">
        </label>
    </div>
    <div>
        <input type = "submit" value = "register">
    </div>
</form>
</body>
</html>
