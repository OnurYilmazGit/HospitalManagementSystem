<%--
  Created by IntelliJ IDEA.
  User: ezelaleynaguloglu
  Date: 28.12.2019
  Time: 00:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 12/16/2019
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<body>
<form action="/searchdoctime" method ="post">

    <div>
        <Label> ENTER A DATE WITH TIME
            <input type="text" name="DATE">
        </label>
    </div>

    <div>
        <input type = "submit" value = "SHOW">
    </div>
</form>
<% ArrayList<ArrayList<String>> dataout= (ArrayList<ArrayList<String>>) request.getAttribute("doctor");%>
<div>
    <p>
        <% out.print("[USERNAME,FIRST NAME,LAST NAME, EXPERTISE]"); %>
    </p>
    <p>
        <%out.print(String.valueOf(dataout)); %>
    </p>

</div>


</body>
</html>

