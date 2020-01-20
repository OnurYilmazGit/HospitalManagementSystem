<%@ page import = "java.sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 12/20/2019
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>make appointment</title>
</head>
<body>
<form action="/make_ap" method ="post">
    <%  Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "bnm678hjk.");
    %>

    <div>
        <Label> PLEASE ENTER YOUR DOCTOR USERNAME
            <input type="text" name="d_username">
        </label>
    </div>

    <div>
        <Label> PLEASE ENTER A TIME
            <select name="time">
                <option value="08:00:00">8</option>
                <option value="09:00:00">9</option>
                <option value="10:00:00">10</option>
                <option value="11:00:00">11</option>
                <option value="12:00:00">12</option>
                <option value="13:00:00">13</option>
                <option value="14:00:00">14</option>
                <option value="15:00:00">15</option>
                <option value="16:00:00">16</option>
                <option value="17:00:00">17</option>
            </select>
            </Label>
    </div>
    <div>
        <Label> PLEASE ENTER A Date
            <select name="DOBDay">
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
            </select>
            <select name="DOBMonth">
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
            <select name="DOBYear">
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
            </select>
        </label>
    </div>

    <div>
        <Label> Department:
            <select> Expertise:
                <%
                    try{
                        String query = "SELECT distinct expertise FROM doctor;";
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        while(rs.next()){

                %>
                <option value="<%=rs.getString("expertise")%>">
                    <%=rs.getString("expertise")%>
                </option>

                <%  }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                %>

            </select>
        </label>
    </div>



    <div>
        <input type = "submit" value = "save">
    </div>
</form>
</body></html>
