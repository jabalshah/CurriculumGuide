<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
                <main class="content">
                    <p>${user.firstname} ${user.lastname}</p>
                    <p>Date of Birth: ${user.dob}</p>
                    <p>Level: ${user.level}</p>
                    <p>Major: ${user.major}</p>
                    <p>Focus Area: ${user.concentration}</p>
                    <p>Advisor: ${user.advisor}</p>
                    <p>Graduation Date: ${user.graduationdate}</p>
                    
                    <p>Current Classes</p>
                    <ul>
                        <c:forEach var="course" items="${registrations}">
                            <c:if test="${course.grade == NULL}">
                                <li>${course.course_id}</li>
                            </c:if>
                        </c:forEach>
                    </ul>
                    
                    <img alt ="cat pickture" src="http://placekitten.com/200/400">
                    
                    
                </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>