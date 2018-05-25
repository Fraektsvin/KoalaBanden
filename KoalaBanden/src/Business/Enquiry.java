/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IEnquiry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author finch
 */

public class Enquiry implements IEnquiry{
    
    private int id; 
    private String source;
    private Date date;
    private String description;
    private int citizenCPR;
    
   
    public Enquiry(int id, String source, Date date, String description) {
        this.id = id;
        this.source = source;
        this.date = date;
        this.description = description; 
        
    }
    
     public Enquiry(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.source = rs.getString("source");
        this.date = rs.getDate("date");
        this.description = rs.getString("description");     
}
     
    public int getID() {
        return id;
    }
    
     public String getSource() {
        return source; 
    }

    public Date getDate() {
        return date;
    }


    public String getDescription() {
        return description;
    }
    
    public int getCitizenCPR() {
        return citizenCPR;
    }
    
}
    
    
   


