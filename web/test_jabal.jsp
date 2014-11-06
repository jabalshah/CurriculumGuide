<%@ include file="includes/header.jsp" %>
                <main class="content">
                    <h2>HI GUYS</h2>
                    ${message}
                    <h3>NEW THING GUYs</h3>
                </main>
<%@ include file="includes/aside.jsp" %>
YUP
<%@ include file="includes/footer.jsp" %>



<c:when test="${remainingCourse.category ne current}">
                <tr>
                    <td colspan="2">${remainingCourse.category}</td>
                </tr>
                <tr>
                    <td></td>
                    <td>${remainingCourse.require}</td>
                </tr>
                <c:set var="current" value="${remainingCourse.category}" />
            </c:when>
            <c:otherwise>
                <tr>
                    <td></td>
                    <td>${remainingCourse.require}</td>
                </tr>
            </c:otherwise>