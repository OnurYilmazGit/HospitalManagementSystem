<%--
  Created by IntelliJ IDEA.
  User: onur_yilmaz
  Date: 24.12.2019
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<form action="/statistic" method="post">
<body>

<div>
    <a href="${pageContext.request.contextPath}/facilities_utilization">Show Which department use facilities more</a>
</div>

<div>
    <a href="${pageContext.request.contextPath}/patientandtime">Show Number of Patient on a time Period</a>
</div>

</body>
</form>
</html>
