<%-- 
    Document   : advisorRegistration
    Created on : Nov 11, 2014, 8:53:31 PM
    Author     : Jabal
--%>

<%@ include file="includes/header.jsp" %>
<main class="content">
    <h2>Registration Form</h2>
    <div id="registrationForm">
        <form class="pure-form pure-form-stacked" id="form1" action="addToRegistration" method="post">
            <p class="message">${message}</p>
            <fieldset>
                <label for="userName">Advisor User Name:</label>
                <input type="text" name="userName" placeholder="jdoe" required value=${user.userName}>@uncc.edu

                <label for="password">Password:</label>
                <input type="password" name="password" placeholder="Enter at least 8 character" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" onchange="form.repassword.pattern = this.value;">
                <span class="form_hint">Enter at least 1 number, 1 lowercase, 1 Uppercase 8 character long</span>

                <label for="repassword">Confirm Password:</label>
                <input type="password" name="repassword" placeholder="Re Enter your password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
                <span class="form_hint">Re-enter your password</span>

                <input type="hidden" name="role" value="advisor">

                <input class="pure-button pure-button-primary" type="submit" value="Register">

            </fieldset>
        </form>
    </div>
</main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>
