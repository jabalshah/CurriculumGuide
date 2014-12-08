<%@ include file="includes/header.jsp" %>
                <main class="content">
                    <form id="form1" action="login" method="post">
                        <div class="row">
                            <div class="large-12 columns">
                        <p class="message">${message}</p>

                                    <label for="userName">User Name:</label>
                                    <input type="text" name="userName" placeholder="jdoe@uncc.edu" required value=${user.userName}>
                                    <label for="password">Password:</label>
                                    <input type="password" placeholder="Enter at least 1 number, 1 lowercase, 1 Uppercase 8 character long" name="password" placeholder="Enter the Password" required>
                                    <input class="button" type="submit" value="Login">
                                </div>
                        </div>
                    </form>
                </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>