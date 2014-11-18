<%-- 
    Document   : displayAdvisees
    Created on : Nov 17, 2014, 7:18:34 PM
    Author     : Jabal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
<main class="content">
    <c:set var="advisor" value="${advisorAdvisees[0].advisor}" />
    <h2>Advisor: ${advisor}</h2>
    <table class="pure-table">
        <thead>
            <tr>
                <th>Students</th>
        </thead>
        </tr>
        <c:forEach var="advisorAdvisee" items="${advisorAdvisees}">
            <tr>
                <td>${advisorAdvisee.advisee}</td>
                <td></td>
            </tr>
        </c:forEach>
        <form action="insertAdvisee" method="post">
            <input type="hidden" name ="advisor" value="${advisor}">
            <tr>
                <td><input type="text" name="advisee"></td>
                <td align="center"><input type="submit" value="Insert"</td>
            </tr>
        </form>
    </table>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>
