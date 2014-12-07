<%-- 
    Document   : coursesByCategory
    Created on : Oct 10, 2014, 9:13:40 PM
    Author     : Jabal
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
    <main class="content">
        <table>
          <thead>
                <tr>
                    <th>Course Id</th>
                    <th>Semester</th>
                    <th>Year</th>
                    <th>Grade</th>
                    <th>Category</th>
                </tr>
            </thead>
            <tbody>
        <c:forEach var="course" items="${registrations}">
            <tr>
                <td><a href="displayCourseInfo?courseID=${course.course_id}">${course.course_id}</a></td>
            <c:choose>
                <c:when test="${course.semester%100 == 10}">
                <td>Spring</td>
                </c:when>
                <c:when test="${course.semester%100 == 50}">
                <td>1st Summer</td>
                </c:when>
                <c:when test="${course.semester%100 == 70}">
                <td>2nd Summer</td>
                </c:when>
                <c:when test="${course.semester%100 == 80}">
                <td>Fall</td>
                </c:when>
                <c:when test="${course.semester%100 == 0}">
                <td>Transfer</td>
                </c:when>
            </c:choose>
                <fmt:parseNumber var="year" type="number" value="${course.semester / 100}" integerOnly="true"/>        
                <td>${year}</td>
                <td>${course.grade}</td>
                <td>${course.category}</td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
    </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>