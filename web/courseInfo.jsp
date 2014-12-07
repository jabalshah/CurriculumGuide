<%-- 
    Document   : courseInfo
    Created on : Dec 6, 2014, 5:15:30 PM
    Author     : Jabal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="includes/header.jsp" %>
<main class="content">
    <table class="pure-table">
        <tr>
            <td>Course ID</td>
            <td>${courseInfo.courseID}</td>
        </tr>
        <tr>
            <td>Course Name</td>
            <td>${courseInfo.courseName}</td>
        </tr>
        <tr>
            <td>Description</td>
            <td>${courseInfo.description}</td>
        </tr>
        <tr>
            <td>Prerequisites</td>
            <td>${courseInfo.prerequisites}</td>
        </tr>
        <tr>
            <td>Rotation</td>
            <td>${courseInfo.rotation}</td>
        </tr>
        <tr>
            <td>Usefulness</td>
            <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${courseInfo.usefulness}" /> out of 5</td>
        </tr>
        <tr>
            <td>Difficulty</td>
            <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${courseInfo.difficulty}" /> out of 5</td>
        </tr>
    </table>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>
