<%-- 
    Document   : markReport
    Created on : Jul 5, 2022, 6:06:43 PM
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
            *{
                margin: 0;
                box-sizing: border-box;
                font-family: sans-serif;
            }
            .header {
                background-color: rgb(226, 223, 223);
                color:white;
                overflow: auto;
                line-height: 30px;
                width: 90%;
                margin: 30px auto;

            }
            .header .left{
                float: left;
                padding-left: 20px;
            }
            .header .right{
                float: right;
                padding-right: 100px;
            }
            .header .right a{
                text-decoration: none;
                color:white;
                background-color: rgb(76, 238, 143);
            }
            .container{
                margin: 0 auto;
                width: 90%;
                padding-top: 50px;
            }
            .display_grade{
                margin:0 auto auto;
                width: 90%;
            }
            a{
                text-decoration: none;
            }
        </style>
    </head>
    <body>
    <body>
        <div class="grade-report">
            <div class="header">
                <div class="left">
                    <a href="home.jsp" style="color:rgb(115, 201, 252)">Home</a>
                </div>
                <div class="right">
                    <c:if test="${sessionScope.account != null}">
                        <a>${sessionScope.account.username}</a>
                        | 
                        <a href="logout">logout</a>

                    </c:if>
                </div>
            </div>
            <div class="container">
                <c:if test="${sessionScope.account != null}">
                    <h2>Grade report for <strong style="color: red">${sessionScope.account.username}</strong> </h2></c:if>
                <h3 style="margin-top:50px;margin-bottom: 20px">Select a term, course... </h3>
                <table border="1" style="width: inherit">
                    <thead>
                        <tr>
                            <th>Term</th>
                            <th>Course</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <div class="term">
                                    <table>
                                        <tbody>
                                            <c:forEach items="${requestScope.listSE}" var="s">
                                                <tr>
                                                    <td><a href="semester?seid=${s.seid}"> ${s.name}</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </td>
                            <td valign="top">
                                <div class="course">
                                    <table >
                                        <tbody>
                                            <c:forEach items="${requestScope.listCO}" var="c">
                                                <tr>
                                                    <td><a href=""> ${c.cName}</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </td>

                            </div>

                            </td>
                        </tr>

                    </tbody>
                </table>

            </div>
        </div>

        <div class="display_grade"  >
            <caption></caption>
            <table >

                <thead>
                <th>Grade Category</th>
                <th>Grade Item</th>
                <th>Weight</th>
                <th>Value</th>
                <th>Comment</th>
                </thead>
                <tbody>
                    <tr>
                        <td rowspan="3">Assignment</td>
                        <td>Assignment1</td>
                        <td>10%</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>

                        <td>Assignment2</td>
                        <td>10%</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td >Total</td>
                        <td>20%</td>

                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td rowspan="3">ProgressTest</td>
                        <td>ProgressTest1</td>
                        <td>10%</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>

                        <td>ProgressTest1</td>
                        <td>10%</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>

                        <td>Total</td>
                        <td>20%</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td rowspan="2">Practise Exam</td>
                        <td>Practice Exam</td>
                        <td>30%</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Total</td>
                        <td>30%</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td rowspan="2">Final Exam</td>
                        <td>Final Exam</td>
                        <td>30%</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Total</td>
                        <td>30%</td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td rowspan="2">Course Total</td>
                        <td>Average</td>
                        <td>0.0</td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td>Studying</td>
                        <td></td>
                        <td></td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </body>
</html>
