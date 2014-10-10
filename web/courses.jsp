<%@ include file="includes/header.jsp" %>
                <main class="content">
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <c:forEach var="student" items="${registrations.item}">
                        
                        
                    </c:forEach>
                    


                </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>