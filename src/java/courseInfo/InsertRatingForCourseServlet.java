/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courseInfo;

import business.CourseRating;
import data.CourseInfoDB;
import data.CourseRatingDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jabal
 */
public class InsertRatingForCourseServlet extends HttpServlet {

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
        double usefultotal=0, usefulavg=0, difficultytotal=0, difficultyavg=0;
        CourseRating courseRating = new CourseRating();
        courseRating.setCourseID(request.getParameter("courseID"));
        courseRating.setUserName(request.getParameter("username"));
        courseRating.setUsefulness(Double.parseDouble(request.getParameter("usefulness")));
        courseRating.setDifficulty(Double.parseDouble(request.getParameter("difficulty")));
        
        CourseRatingDB.insert(courseRating);
        ArrayList<Double> usefulnessRatings = CourseRatingDB.getUsefulnessRatings(courseRating.getCourseID());
        ArrayList<Double> difficultyRatings = CourseRatingDB.getDifficultyRatings(courseRating.getCourseID());
        
        for(Double temp: usefulnessRatings)
            usefultotal += temp;
        usefulavg = usefultotal / usefulnessRatings.size();
        for(Double temp: difficultyRatings)
            difficultytotal += temp;
        difficultyavg = difficultytotal / difficultyRatings.size();
        
        CourseInfoDB.updateRatings(courseRating.getCourseID(), usefulavg, difficultyavg);
        String url = "/userProfile.jsp";
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
