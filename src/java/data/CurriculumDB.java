/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import business.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Jabal
 */
public class CurriculumDB {
    public static ArrayList<String> getRequires(String category){
        ArrayList<String> requiredCourses = new ArrayList<String>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT requires FROM curriculum Where category=?";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, category);
            rs = ps.executeQuery();
            while (rs.next()){
                requiredCourses.add(rs.getString("requires"));
            }
            return requiredCourses;
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
    
    public static ArrayList<RemainingCourse> getAllRequires(){
        ArrayList<RemainingCourse> requiredCourses = new ArrayList<RemainingCourse>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM curriculum_guide.curriculum order by priority, category, requires;";
        
        try{
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                RemainingCourse remainingCourse = new RemainingCourse();
                remainingCourse.setCategory(rs.getString("category"));
                remainingCourse.setRequire(rs.getString("requires"));
                remainingCourse.setPriority(rs.getInt("priority"));
                requiredCourses.add(remainingCourse);
            }
            return requiredCourses;
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
    
    public static ArrayList<String> getCategories(){
        ArrayList<String> categories = new ArrayList<String>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "Select Distinct category from curriculum;";
        
        try{
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                categories.add(rs.getString("category"));
            }
            return categories;
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
    
    public static ArrayList<Curriculum> selectAll(){
        ArrayList<Curriculum> curriculumCourses = new ArrayList<Curriculum>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "Select * from curriculum;";
        
        try{
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Curriculum curriculumCourse = new Curriculum();
                curriculumCourse.setId(rs.getInt("id"));
                curriculumCourse.setCategory(rs.getString("category"));
                curriculumCourse.setRequires(rs.getString("requires"));
                curriculumCourse.setPriority(rs.getInt("priority"));
                curriculumCourses.add(curriculumCourse);
            }
            return curriculumCourses;
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
    
    public static Curriculum selectCurriculumCourseById(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM curriculum " +
                       "WHERE id=?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Curriculum curriculumCourse = null;
            if (rs.next())
            {
                curriculumCourse = new Curriculum();
                curriculumCourse.setId(rs.getInt("id"));
                curriculumCourse.setCategory(rs.getString("category"));
                curriculumCourse.setRequires(rs.getString("requires"));
                curriculumCourse.setPriority(rs.getInt("priority"));
            }
            return curriculumCourse;
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
    
    public static int update(Curriculum curriculumCourse){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE curriculum SET " +
                "category = ?, " +
                "requires = ?, " +
                "priority = ? " +
                "WHERE id = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, curriculumCourse.getCategory());
            ps.setString(2, curriculumCourse.getRequires());
            ps.setInt(3, curriculumCourse.getPriority());
            ps.setInt(4,curriculumCourse.getId());

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
    
    public static int delete(Curriculum curriculumCourse)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM curriculum WHERE id=?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, curriculumCourse.getId());
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
    
    public static int insert(Curriculum curriculumCourse)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO curriculum (category, requires, priority) " +
                "VALUES (?, ?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, curriculumCourse.getCategory());
            ps.setString(2, curriculumCourse.getRequires());
            ps.setInt(3, curriculumCourse.getPriority());
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
