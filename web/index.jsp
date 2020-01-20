<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 11/19/2019
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <sql:setDataSource var ="connection" driver = "com.mysql.jdbc.Driver"
  url = "jdbc:mysql://localhost:3306/hospital2"
  user= "root" password="bnm678hjk." />

  <div>
    <a href="/login">Login Patient</a>
  </div>
  <div>
    <a href="/logindoctor.jsp">Login Doctors</a>
  </div>
  <div>
    <a href="${pageContext.request.contextPath}/manager_login">Login Managers</a>
  </div>
  <div>
    <a href="/login_nurse.jsp">Login nurses</a>
  </div>
  </body>
</html>