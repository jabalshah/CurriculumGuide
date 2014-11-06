/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import business.*;
import data.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jabal
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserLogin userLogin = new UserLogin();
        HttpSession session = request.getSession();
        ArrayList<Registration> registrations = new ArrayList<Registration>();
        User user = new User();
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        String url = "";
        String message = "";
        
        if(!UserLoginDB.userNameExists(userName)){
            message ="User Name doesnot exist, please enter correct username";
            url = "/login.jsp";
        }
        else{
            userLogin = UserLoginDB.selectUser(userName);
            try {
                //If password validates proceed to home screen after logging in 
                //successfully
                if (PasswordManager.validatePassword(password, userLogin.getPassword())) {
                    
                    Cookie userNameCookie = new Cookie("userNameCookie", userLogin.getUserName());
                    userNameCookie.setMaxAge(60 * 60 * 24);
                    userNameCookie.setPath("/");
                    response.addCookie(userNameCookie);

                    Cookie loginStatusCookie = new Cookie("loginStatusCookie", userLogin.getUserName());
                    loginStatusCookie.setMaxAge(60 * 30);
                    loginStatusCookie.setPath("/");
                    response.addCookie(loginStatusCookie);
                    if(userLogin.getRole().equals("student")){
                        user = UserDB.selectUser(userName);
                        url = "/userProfile.jsp";
                        session.setAttribute("user", user);
                    }
                    else
                        url = "/advisorDashboard.jsp";
                    registrations = RegistrationDB.selectAll(userName);
                    session.setAttribute("userLogin", userLogin);
                    session.setAttribute("userName", userName);
                } else {
                    message = "Password is incorrect for given UserName";
                    url = "/login.jsp";
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        session.setAttribute("registrations", registrations);
        session.setAttribute("userLogin", userLogin);
        request.setAttribute("message", message);
        session.setAttribute("login", "true");

        // forward the request and response to the view
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
