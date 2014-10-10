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

/**
 *
 * @author Jabal
 */
public class UserDB {
    public static User selectUser(String userName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        //Setting up query that will retrieve the records where username matches
        String query = "SELECT * FROM user" +
                       "WHERE username = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            User user = new User();
            
            //If record exist, setting up values in Customer object
            if (rs.next())
            {
                user.setUserName(rs.getString("username"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setDob(rs.getDate("dob"));
                user.setLevel(rs.getString("level"));
                user.setMajor(rs.getString("major"));
                user.setConcentration(rs.getString("concentration"));
                user.setGraduationdate(rs.getDate("graduationdate"));
            }
            //Finally return the Customer object
            return user;
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
}
