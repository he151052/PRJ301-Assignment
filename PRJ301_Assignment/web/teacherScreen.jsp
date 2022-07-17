<%-- 
    Document   : teacherScreen
    Created on : Jul 8, 2022, 11:49:27 PM
    Author     : oki
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width: 80%; margin: 0 auto">
            <c:if test="${sessionScope.account != null}">
                <a href="logout">logout</a>
                <p style="font-size: 30px">Lecturer <strong> ${sessionScope.account.username}</a></strong> </p>
            </c:if>

            <div style="text-align: center;margin-bottom: 20px">
                <span><strong style="font-size: 25px"> Group:</strong> </span>
                <form action="group" method="POST">
                    <select name="gid">
                        <c:forEach items="${requestScope.group}" var="g"> 

                            <option 
                                <c:if test="${g.gid eq requestScope.gid}">
                                    selected="selected"
                                </c:if>
                                value="${g.gid}">${g.name}
                            </option>

                        </c:forEach>
                    </select>
                    <input type="submit" value="Select">
                </form>
            </div>
            <!--            <a href="#" style="float:right">Update</a>-->
            <table border="1" style="width: 100%;line-height: 2">
                <thead>
                    <tr>
                        <th>Student Code</th>
                        <th>Name</th>
                        <th>Assignment 1</th>
                        <th>Assignment 2</th>
                        <th>Workshop 1</th>
                        <th>Workshop 2 </th>
                        <th>Progresstest 1</th>
                        <th>Progresstest 2</th>
                        <th> PE</th>
                        <th>FE</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.student}" var="s">
                        <tr>
                            <td>${s.sid}</td>
                            <td>${s.name}</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>
    </body>
</html>
