<%-- 
    Document   : recommendedCourses
    Created on : Dec 8, 2014, 11:39:09 AM
    Author     : Jabal
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="includes/header.jsp" %>
<main class="content">
    <table class="pure-table">
        <c:forEach var="recommendedCourse" items="${recommendedCourses}" begin="0" end="5">
            <tr>
                <td>${recommendedCourse.category}</td>
                <td>${recommendedCourse.require}</td>
            </tr> 
        </c:forEach>
    </table>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>