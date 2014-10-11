<%-- 
    Document   : coursesByCategory
    Created on : Oct 11, 2014, 9:13:40 AM
    Author     : Jabal
--%>
<%@page import="data.RegistrationDB,business.Registration,java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>
    <main class="content">
    <table>
        <tr>
            <th></th>
            <th>Course Id</th>
            <th>Semester</th>
            <th>Year</th>
            <th>Grade</th>
        </tr>
    <%
        String[] categories = {"Analytic","Capstone","CCI Elective","Communication","Core Computer Science","CS Focus Area","General Education","Outside Concentration","Programming", "Unknown"};
        String userName = (String)session.getAttribute("userName");
        ArrayList<Registration> courses = new ArrayList<Registration>();
        for(String category: categories){
            courses = RegistrationDB.selectCategory(userName, category);
            if(!courses.isEmpty()){%>
            <tr>
                <td colspan="5"><%=category%></td>
            </tr>
                <%for(Registration course: courses){
                    %><tr>
                        <td></td>
                        <td><%=course.getCourse_id()%></td>
                        <% int season = course.getSemester() % 100;
                        switch(season){
                            case 0:
                                %><td>Transfer</td><%
                                break;
                            case 10:
                                %><td>Spring</td><%
                                break;
                            case 50:
                                %><td>1st Summer</td><%
                                break;
                            case 70:
                                %><td>2nd Summer</td><%
                                break;
                            case 80:
                                %><td>Fall</td><%
                                break;
                        }%>
                        <td><%=course.getSemester() / 100%></td>
                        <td><%=course.getGrade()%></td>
                    </tr>
                    <%
                }
            }
        }
    %>
    </table>
    </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>