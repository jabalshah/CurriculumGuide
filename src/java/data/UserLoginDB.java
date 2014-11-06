/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import business.UserLogin;
import java.sql.*;
/**
 *
 * @author Jabal
 */
public class UserLoginDB {
    public static int insert(UserLogin userLogin)
    {   
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        //Preparing query that will insert record into customer table
        String query = 
                "INSERT INTO userlogininfo (Username, Userpassword, Questioncode, Answer, confirmation_code, role) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, userLogin.getUserName());
            ps.setString(2, userLogin.getPassword());
            ps.setString(3, userLogin.getSecurityQuestion());
            ps.setString(4, userLogin.getAnswer());
            ps.setInt(5, userLogin.getConfirmation_code());
            ps.setString(6, userLogin.getRole());
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
    
    //This method returns true or false based on if username exist in the table
    public static boolean userNameExists(String userName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT Username FROM userlogininfo " +
                "WHERE Username = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    //This method returns the record if username is stored in table otherwise
    //returns empty record
    //record is stored is Customer object for easy use
    public static UserLogin selectUser(String userName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        //Setting up query that will retrieve the records where username matches
        String query = "SELECT * FROM userlogininfo " +
                       "WHERE username = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            UserLogin userLogin = new UserLogin();
            
            //If record exist, setting up values in Customer object
            if (rs.next())
            {
                userLogin.setUserName(rs.getString("username"));
                userLogin.setPassword(rs.getString("userpassword"));
                userLogin.setSecurityQuestion(rs.getString("questioncode"));
                userLogin.setAnswer(rs.getString("answer"));
                userLogin.setRole(rs.getString("role"));
            }
            //Finally return the Customer object
            return userLogin;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int updateConfirmation(UserLogin userLogin)
    {   
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        //Preparing query that will insert record into customer table
        String query = 
                "UPDATE userlogininfo SET confirmation_status = ?" +
                "WHERE username = ?";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, "true");
            ps.setString(2, userLogin.getUserName());
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