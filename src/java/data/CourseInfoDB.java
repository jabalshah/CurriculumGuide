/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.CourseInfo;
import business.Registration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lechegaray
 */
public class CourseInfoDB {
     public static ArrayList<CourseInfo> selectAll()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM cs_courses_only";
        
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
                courseInfo.setPrerequisites(rs.getString("prerequiste"));
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
}
