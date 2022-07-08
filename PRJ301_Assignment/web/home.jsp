<%-- 
    Document   : home
    Created on : Jul 8, 2022, 12:21:37 AM
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
        <div class="header">
            <c:if test="${sessionScope.account != null}">
                
                <a>${sessionScope.account.username}</a>
                    | 
                <a href="logout">logout</a>
                
            </c:if>
            
        </div>
        <div class="container" style="margin-top: 20px">
            <a href="semester">Grade Report</a> <br>
            <a href="">Grade Transcript</a>
        </div>
    </body>
</html>
