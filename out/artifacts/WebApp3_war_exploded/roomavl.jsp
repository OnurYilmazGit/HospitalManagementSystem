<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 12/16/2019
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/roomavl" method ="post">

</form>
<% ArrayList<ArrayList<String>> dataout= (ArrayList<ArrayList<String>>) request.getAttribute("dataout");%>

<div>

    <p>
        <% out.print("these rooms are booked at this time"); %>
    </p>
    <p>
        <% out.print("[ROOM NO, DATE, START TIME, END TIME]"); %>
    </p>
    <% for(int i =0; i<dataout.size();i++){%>
    <p>
        <%out.print(String.valueOf(dataout.get(i))); %>
    </p>
        <%}%>


</div>
</body>
</html>
