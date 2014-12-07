/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import business.CourseRating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jabal
 */
public class CourseRatingDB {
    public static int insert(CourseRating courseRating)
    {   
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = 
                "INSERT INTO courserating (courseid, username, usefulness, difficulty) " +
                "VALUES (?, ?, ?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, courseRating.getCourseID());
            ps.setString(2, courseRating.getUserName());
            ps.setDouble(3, courseRating.getUsefulness());
            ps.setDouble(4, courseRating.getDifficulty());
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Double> getUsefulnessRatings(String courseID){
        ArrayList<Double> usefulnessRatings = new ArrayList<Double>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT usefulness FROM courserating Where courseid=?";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, courseID);
            rs = ps.executeQuery();
            while (rs.next()){
                usefulnessRatings.add(rs.getDouble("usefulness"));
            }
            return usefulnessRatings;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Double> getDifficultyRatings(String courseID){
        ArrayList<Double> difficultyRatings = new ArrayList<Double>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT difficulty FROM courserating Where courseid=?";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, courseID);
            rs = ps.executeQuery();
            while (rs.next()){
                difficultyRatings.add(rs.getDouble("difficulty"));
            }
            return difficultyRatings;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
