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
public class RegistrationDB {
    
    public static ArrayList<Registration> selectAll(String userName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM registration Where username = ? ORDER BY semester";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            ArrayList<Registration> registrations = new ArrayList<Registration>();
            while (rs.next()){
                Registration registration = new Registration();
                registration.setIdregistration(rs.getInt("idregistration"));
                registration.setUserName(rs.getString("username"));
                registration.setCourse_id(rs.getString("course_id"));
                registration.setSemester(rs.getInt("semester"));
                registration.setGrade(rs.getString("grade"));
                registration.setCategory(rs.getString("category"));
                registration.setSatisfies(rs.getString("satisfies"));
                registrations.add(registration);
            }
            return registrations;
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
    
    public static ArrayList<Registration> selectCurrent(String userName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM registration Where username = ? AND grade IS NULL";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            ArrayList<Registration> registrations = new ArrayList<Registration>();
            while (rs.next()){
                Registration registration = new Registration();
                registration.setIdregistration(rs.getInt("idregistration"));
                registration.setUserName(rs.getString("username"));
                registration.setCourse_id(rs.getString("course_id"));
                registration.setSemester(rs.getInt("semester"));
                registration.setGrade(rs.getString("grade"));
                registration.setCategory(rs.getString("category"));
                registration.setSatisfies(rs.getString("satisfies"));
                registrations.add(registration);
            }
            return registrations;
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
    
    public static ArrayList<Registration> selectCategory(String userName, String category)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM registration WHERE username = ? AND category = ? ORDER BY semester";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, category);
            rs = ps.executeQuery();
            ArrayList<Registration> registrations = new ArrayList<Registration>();
            while (rs.next()){
                Registration registration = new Registration();
                registration.setIdregistration(rs.getInt("idregistration"));
                registration.setUserName(rs.getString("username"));
                registration.setCourse_id(rs.getString("course_id"));
                registration.setSemester(rs.getInt("semester"));
                registration.setGrade(rs.getString("grade"));
                registration.setCategory(rs.getString("category"));
                registration.setSatisfies(rs.getString("satisfies"));
                registrations.add(registration);
            }
            return registrations;
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
    
    public static ArrayList<Registration> selectCompleted(String userName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM registration Where username = ? AND grade IS NOT NULL ORDER BY semester";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            ArrayList<Registration> registrations = new ArrayList<Registration>();
            while (rs.next()){
                Registration registration = new Registration();
                registration.setIdregistration(rs.getInt("idregistration"));
                registration.setUserName(rs.getString("username"));
                registration.setCourse_id(rs.getString("course_id"));
                registration.setSemester(rs.getInt("semester"));
                registration.setGrade(rs.getString("grade"));
                registration.setCategory(rs.getString("category"));
                registration.setSatisfies(rs.getString("satisfies"));
                registrations.add(registration);
            }
            return registrations;
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
