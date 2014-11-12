<%-- 
    Document   : displayCurriculumCourse
    Created on : Nov 8, 2014, 7:58:43 PM
    Author     : Jabal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
<main class="content">
    <form action="updateCurriculumCourse" method="post">
        <table cellspacing="5" border="0">
            <tr>
                <td align="right">Id:</td>
                <td><input type="text" name="id" 
                           value="${curriculumCourse.id}" disabled>
                </td>
            </tr>
            <tr>
                <td align="right">Category:</td>
                <td><input type="text" name="category" 
                           value="${curriculumCourse.category}">
                </td>
            </tr>
            <tr>
                <td align="right">Sub-Category:</td>
                <td><input type="text" name="requires" 
                           value="${curriculumCourse.requires}">
                </td>
            </tr>
            <tr>
                <td align="right">Priority:</td>
                <td><input type="text" name="priority" 
                           value="${curriculumCourse.priority}">
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="Submit" onclick="this.form.submit();"></td>
            </tr>
        </table>
    </form>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>
