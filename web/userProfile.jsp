<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
<main class="content">
    <table>
        <tbody>
            <tr>
                <td>Name</td>
                <td>${user.firstname} ${user.lastname}</td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td>${user.dob}</td>
            </tr>
            <tr>
                <td>Level</td>
                <td>${user.level}</td>
            </tr>
            <tr>
                <td>Major</td>
                <td>${user.major}</td>
            </tr>
            <tr>
                <td>Focus Area</td>
                <td>${user.concentration}</td>
            </tr>
            <tr>
                <td>Advisor</td>
                <td>${user.advisor}</td>
            </tr>
            <tr>
                <td>Graduation Date</td>
                <td>${user.graduationdate}</td>
            </tr>    
        </tbody>
    </table>
    <table>
        <tbody>
        <th>
            Current Classes 
        </th>
        <c:forEach var="course" items="${registrations}">
            <c:if test="${course.grade == NULL}">
                <tr>
                    <td>${course.course_id}</td>
                </tr>   
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>