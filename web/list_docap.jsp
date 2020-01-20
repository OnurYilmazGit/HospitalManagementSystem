<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 12/20/2019
  Time: 4:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% ArrayList<ArrayList<String>> dataout= (ArrayList<ArrayList<String>>) request.getAttribute("dataout");%>

<div>

    <p>
        <% out.print("you have appointments at this time"); %>
    </p>
    <p>
        <%out.print(dataout); %>
    </p>



</div>



</body>
</html>
