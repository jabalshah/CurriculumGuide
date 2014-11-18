/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import business.AdvisorAdvisee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jabal
 */
public class AdvisorAdviseeDB {
    
    public static ArrayList<AdvisorAdvisee> getAdvisee(String category){
        ArrayList<AdvisorAdvisee> advisorAdvisees  = new ArrayList<AdvisorAdvisee>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM advisoradvisee Where advisor=?";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, category);
            rs = ps.executeQuery();
            while (rs.next()){
                AdvisorAdvisee advisorAdvisee = new AdvisorAdvisee();
                advisorAdvisee.setIdadvisoradvisee(rs.getInt("idadvisoradvisee"));
                advisorAdvisee.setAdvisor(rs.getString("advisor"));
                advisorAdvisee.setAdvisee(rs.getString("advisee"));
                advisorAdvisees.add(advisorAdvisee);
            }
            return advisorAdvisees;
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
    
    public static int insert(AdvisorAdvisee advisorAdvisee)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO advisoradvisee (advisor, advisee) " +
                "VALUES (?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, advisorAdvisee.getAdvisor());
            ps.setString(2, advisorAdvisee.getAdvisee());
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
