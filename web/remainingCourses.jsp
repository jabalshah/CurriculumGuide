<%-- 
    Document   : remainingCourses
    Created on : Nov 3, 2014, 2:05:33 PM
    Author     : Jabal
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
<main class="content">
     <h2>Remaining Courses to Complete</h2>
    <table width="100%">
        <c:set var="current" value='nothing' />
        <c:forEach var="remainingCourse" items="${remainingCourses}">
            <tr>
                <td>${remainingCourse.category}</td>
                <td>${remainingCourse.require}</td>
            </tr>
        </c:forEach>
    </table>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>