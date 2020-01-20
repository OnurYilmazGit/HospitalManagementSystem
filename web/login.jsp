<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 11/19/2019
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<form action="${pageContext.request.contextPath}/login" method ="post">

       <div>
        <Label>  USERNAME
       <input type="text" name="username">
        </label>
            </div>
        <div>
        <Label> PASSWORD
        <input type="password" name="password">
        </label>
        </div>
        <div>
            <input type = "submit" value = "login">
        </div>
</form>

<div>
    <a href="/reg_pat">register patients</a>
</div>


<% String status= (String) request.getAttribute("status");%>

<% if(status != null &&status.equals("fail")) {%>
<div>
    <p>
        <% out.print(status); %>
    </p>

    Your username or password is wrong
</div>

  <%}%>

</body>
</html>
