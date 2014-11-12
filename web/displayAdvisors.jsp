<%-- 
    Document   : displayAdvisors
    Created on : Nov 10, 2014, 9:40:24 PM
    Author     : Jabal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
<main class="content">
    <table class="pure-table">
        <thead>
            <tr>
                <th>Advisors</th>
        </thead>
        </tr>
        <c:forEach var="advisorUsername" items="${advisorUsernames}">
            <tr>
                <td>${advisorUsername}</td>
            </tr>
        </c:forEach>
        <form action="advisorRegistration.jsp" method="get">
            <tr>
                <td align="center"><input type="submit" value="Insert"</td>
            </tr>
        </form>
    </table>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>