<%@ include file="includes/header.jsp" %>
        <main class="content">
            <h2>Registration Form</h2>
            <div id="registrationForm">
                <form id="form1" action="addToRegistration" method="post">
                    <p class="message">${message}</p>
                    <fieldset>
                            <label for="userName">User Name:</label>
                            <input type="text" name="userName" placeholder="jdoe@uncc.edu" required value=${user.userName}>
                        
                            <label for="password">Password:</label>
                            <input type="password" name="password" placeholder="8 character long. 1 number, 1 lowercase, 1 Uppercase" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" onchange="form.repassword.pattern = this.value;">
                        
                            <label for="repassword">Confirm Password:</label>
                            <input type="password" name="repassword" placeholder="Re-enter your password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
                        
                        
                            <label for="securityQuestion">Security Question:</label>
                            <select name="securityQuestion">
                            <option value="sq01" selected>What was your first pet name?</option>
                            <option value="sq02">What is your maiden name?</option>
                            <option value="sq03">Which town you were born in?</option>
                            </select>
                        
                        
                            <label for="answer">Answer:</label>
                            <input type="text" name="answer" placeholder="Enter your answer" required value=${customerLogin.answer}>
                            
                            <input type="hidden" name="role" value="student">
                        
                            <input class="button" type="submit" value="Register">
                        
                    </fieldset>
                </form>
            </div>
        </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>