<%@ include file="includes/header.jsp" %>
                <main class="content">
                    <form id="form1" action="login" method="post">
                        <div class="row">
                            <div class="large-12 columns">
                        <p class="message">${message}</p>

                                    <label for="userName">User Name:</label>
                                    <input type="text" name="userName" placeholder="jdoe" required value=${user.userName}>   @uncc.edu
                                    <label for="password">Password:</label>
                                    <input type="password" name="password" placeholder="Enter the Password" required>
                                    <span class="form_hint">Enter at least 1 number, 1 lowercase, 1 Uppercase 8 character long</span>
                                    <input type="submit" value="Login">
                                </div>
                        </div>
                    </form>
                </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>