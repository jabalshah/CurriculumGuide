<%-- 
    Document   : courseInfoWithRating
    Created on : Dec 6, 2014, 5:16:35 PM
    Author     : Jabal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <td>${courseInfo.usefulness} out of 5</td>
        </tr>
        <tr>
            <td>Difficulty</td>
            <td>${courseInfo.difficulty} out of 5</td>
        </tr>
    </table>
    <p>We see you've taken this course, would you mind rating this</p>
    <table class="pure-table">
        <form action="insertRatingForCourse" method="post">
            <input type="hidden" name="courseID" value="${courseInfo.courseID}">
            <input type="hidden" name="username" value="${user.userName}">
            <tr>
                <td>Usefulness:</td>
                <td><input type="number" name="usefulness" min="0" max="5" step="0.5"></td>
            </tr>
            <tr>
                <td>Difficulty:</td>
                <td><input type="number" name="difficulty" min="0" max="5" step="0.5"></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </form>
    </table>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>
