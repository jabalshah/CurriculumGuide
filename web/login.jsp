<%@ include file="includes/header.jsp" %>
                <main class="content">
                    <form id="form1" action="login" method="post">
                        <p class="message">${message}</p>
                            <ul>
                                <li>
                                    <label for="userName">User Name:</label>
                                    <input type="text" name="userName" placeholder="jdoe" required value=${user.userName}>   @uncc.edu
                                </li>
                                <li>
                                    <label for="password">Password:</label>
                                    <input type="password" name="password" placeholder="Enter the Password" required>
                                    <span class="form_hint">Enter at least 1 number, 1 lowercase, 1 Uppercase 8 character long</span>
                                </li>
                                <li>
                                    <input type="submit" value="Login">
                                </li>
                            </ul>
                    </form>
                </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>