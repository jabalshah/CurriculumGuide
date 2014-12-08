<%-- 
    Document   : coursesBySemester
    Created on : Oct 11, 2014, 11:07:47 AM
    Author     : Jabal
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
    <main class="content">
         <h2>Courses Completed by Semester</h2>
        <table width="100%" class="pure-table">
            <thead>
            <tr>
                <th>Period</th>
                <th>Year</th>
                <th>Course ID</th>
                <th>Grade</th>
                <th>Category</th>
            </thead>
            </tr>
        <c:set var="current" value="" />
        <c:forEach var="course" items="${registrations}">
            <c:choose>
                <c:when test="${course.semester != current}">
                    <tr>
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
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><a href="displayCourseInfo?courseID=${course.course_id}">${course.course_id}</a></td>
                        <td>${course.grade}</td>
                        <td>${course.category}</td>
                    </tr>
                    <c:set var="current" value="${course.semester}" />
                </c:when>
                <c:otherwise>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><a href="displayCourseInfo?courseID=${course.course_id}">${course.course_id}</a></td>
                        <td>${course.grade}</td>
                        <td>${course.category}</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        </table>
    </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>
