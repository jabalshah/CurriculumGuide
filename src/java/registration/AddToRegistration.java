/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registration;

import business.PasswordManager;
import business.UserLogin;
import data.UserLoginDB;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jabal
 */
public class AddToRegistration extends HttpServlet {

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
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String securityQuestion = request.getParameter("securityQuestion");
        String answer = request.getParameter("answer");
        
        UserLogin userLogin = new UserLogin();
        userLogin.setUserName(userName);
        try {
            userLogin.setPassword(PasswordManager.createHash(password));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AddToRegistration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(AddToRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        userLogin.setSecurityQuestion(securityQuestion);
        userLogin.setAnswer(answer);
        
        String url;
        String message = "";
        if (UserLoginDB.userNameExists(userLogin.getUserName())) {
            message = "User Name already exist, please choose different User Name";
            url = "/registration.jsp";
        }
        else{
            UserLoginDB.insert(userLogin);
            url = "/index.jsp";
        }
        HttpSession session = request.getSession();
        session.setAttribute("userLogin", userLogin);
        request.setAttribute("message", message);
        
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
