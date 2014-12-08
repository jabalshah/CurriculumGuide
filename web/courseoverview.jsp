<%@ include file="includes/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <main class="content">
                    <h3>Basic Skills</h3>
                    <table width="100%">
          <thead>
                <tr>
                    <th>Course Id</th>
                    <th>Course Name</th>
                    <th>Usefulness</th>
                    <th>Difficulty</th>
                </tr>
            </thead>
            <tbody>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.courseID}</span></td>
                <td><span data-tooltip aria-haspopup="true" class="has-tip tip-left" title="${course.description}<br /><br />Pre-reqs:<br />${course.prerequisites}<br /><br />Rotation<br />${course.rotation}">${course.courseName}</span></td>
                <td>${course.usefulness}</span></td>
                <td>${course.difficulty}</span></td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
                </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>