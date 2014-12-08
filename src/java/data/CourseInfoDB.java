/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import business.CourseInfo;
import business.Curriculum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jabal
 */
public class CourseInfoDB {
    public static CourseInfo selectCurriculumCourseById(String courseID){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM courseinfo " +
                       "WHERE courseID=?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, courseID);
            rs = ps.executeQuery();
            CourseInfo courseInfo = null;
            if (rs.next())
            {
                courseInfo = new CourseInfo();
                courseInfo.setCourseID(rs.getString("courseID"));
                courseInfo.setCourseName(rs.getString("coursename"));
                courseInfo.setDescription(rs.getString("description"));
                courseInfo.setPrerequisites(rs.getString("prerequisites"));
                courseInfo.setUsefulness(rs.getDouble("usefulness"));
                courseInfo.setDifficulty(rs.getDouble("difficulty"));
                courseInfo.setRotation(rs.getString("rotation"));
            }
            return courseInfo;
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
    
    public static ArrayList<CourseInfo> selectAll()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM courseinfo";
        
        try{
            ps = connection.prepareStatement(query);
            //ps.setString(1, userName);
            rs = ps.executeQuery();
            ArrayList<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
            while (rs.next()){
                CourseInfo courseInfo = new CourseInfo();
                courseInfo.setCourseID(rs.getString("courseID"));
                courseInfo.setCourseName(rs.getString("courseName"));
                courseInfo.setDescription(rs.getString("description"));
                courseInfo.setPrerequisites(rs.getString("prerequisites"));
                courseInfo.setUsefulness(rs.getDouble("usefulness"));
                courseInfo.setDifficulty(rs.getDouble("difficulty"));
                courseInfo.setRotation(rs.getString("rotation"));
                courseInfos.add(courseInfo);
            }
            return courseInfos;
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
    
    public static int updateRatings(String courseID, double usefulness, double difficulty){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE courseinfo SET " +
                "usefulness = ?, " +
                "difficulty = ? " +
                "WHERE courseID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setDouble(1, usefulness);
            ps.setDouble(2, difficulty);
            ps.setString(3, courseID);
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
}
