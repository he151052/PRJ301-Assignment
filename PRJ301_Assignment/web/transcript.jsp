<%-- 
    Document   : transcript
    Created on : Jul 13, 2022, 11:56:03 PM
    Author     : oki
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .transcipt{
                width: 90%;
                margin: 0 auto;
                line-height: 2;
            }
            td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="transcipt">
            <div class="header">
                <a href="">Home</a>
            </div>
            <div>
                <h3>Grade Transcript Report for he151052</h3>
            </div>
            <div class="">
                <table border="1" style="width: 90%">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Semester</th>
                            <th>Subject Name</th>
                            <th>Credit</th>
                            <th>Grade</th>
                            <th>Status</th>        
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.tran}" var="t">
                            <tr>
                                <td>${t.no}</td>
                                <td>${t.name}</td>
                                <td>${t.course.cName}</td>
                                <td>${t.course.credit}</td> 
                                
                                
                            <td>${avg}</td>
                            <td>${status}</td>
                                </tr>
                        </c:forEach>
                    </tbody>

                </table>

            </div>
        </div>
    </body>
</html>
