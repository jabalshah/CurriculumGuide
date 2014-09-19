<%-- 
    Document   : registration
    Created on : Sep 19, 2014, 1:57:57 PM
    Author     : Jabal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curriculum Guide - Registration </title>
        <link rel="stylesheet" type="text/css" href="css/registration.css" media="screen">
    </head>
    <body>
        <h2>Registration Form</h2>
        <div id="registrationForm">
            <form class="form1" id="form1" action="addToRegistration" method="post">
                <p class="message">${message}</p>
                <ul>
                    <li>
                        <label for="userName">User Name:</label>
                        <input type="text" name="userName" placeholder="jdoe" required value=${user.userName}>   @uncc.edu
                    </li>
                    <li>
                        <label for="password">Password:</label>
                        <input type="password" name="password" placeholder="Enter atleast 8 character" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" onchange="form.repassword.pattern = this.value;">
                        <span class="form_hint">Enter at least 1 number, 1 lowercase, 1 Uppercase 8 character long</span>
                    </li>
                    <li>
                        <label for="repassword">Confirm Password:</label>
                        <input type="password" name="repassword" placeholder="Re Enter your password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
                        <span class="form_hint">Re enter your password</span> 
                    </li>
                    <li>
                        <label for="securityQuestion">Security Question:</label>
                        <select name="securityQuestion">
                        <option value="sq01" selected>What was your first pet name?</option>
                        <option value="sq02">What is your maiden name?</option>
                        <option value="sq03">Which town you were born in?</option>
                        </select>
                    </li>
                    <li>
                        <label for="answer">Answer:</label>
                        <input type="text" name="answer" placeholder="Enter your answer" required value=${customerLogin.answer}>
                    </li>
                    <li>
                        <input type="submit" value="Register">
                    </li>
                </ul>
            </form>
        </div>
    </body>
    
</html>
