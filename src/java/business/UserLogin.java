/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.io.Serializable;

/**
 *
 * @author Jabal
 */
public class UserLogin implements Serializable{

    private String userName;
    private String password;
    private String securityQuestion;
    private String answer;
    private int confirmation_code;
    private String confirmation_status;

    public int getConfirmation_code() {
        return confirmation_code;
    }

    public void setConfirmation_code(int confirmation_code) {
        this.confirmation_code = confirmation_code;
    }

    public String getConfirmation_status() {
        return confirmation_status;
    }

    public void setConfirmation_status(String confirmation_status) {
        this.confirmation_status = confirmation_status;
    }
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
