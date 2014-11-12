<%-- 
    Document   : displayCurriculum
    Created on : Nov 8, 2014, 6:04:52 PM
    Author     : Jabal
--%>
<script type="text/javascript">
    function check(){
        return confirm("Are you sure?");
    }
</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
<main class="content">
    <table class="pure-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Sub-Category</th>
                <th>Priority</th>
                <th colspan="2"></th>
        </thead>
        </tr>
        <c:forEach var="curriculumCourse" items="${curriculumCourses}">
            <tr>
                <td>${curriculumCourse.id}</td>
                <td>${curriculumCourse.category}</td>
                <td>${curriculumCourse.requires}</td>
                <td>${curriculumCourse.priority}</td>
                <td><a href="displayCurriculumCourse?id=${curriculumCourse.id}">Update</a></td>
                <td><a href="deleteCurriculumCourse?id=${curriculumCourse.id}" onclick='return check()'>Delete</a></td>
            </tr>
        </c:forEach>
        <form action="insertCurriculumCourse" method="get">
            <tr>
                <td></td>
                <td><input type="text" name="category"></td>
                <td><input type="text" name="requires"></td>
                <td><input type="text" name="priority"></td>
                <td colspan="2" align="center"><input type="submit" value="Insert"</td>
            </tr>
        </form>
    </table>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>
