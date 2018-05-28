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
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class Enquiry implements IEnquiry {

    // Data field 
    private final int id; // of an enquiry
    private final String source; // describes which source an enquiry is received from
    private final Date date; // describes which date an enquiry is created
    private final String description; // a destription of the citizens enquiry
    private final int citizenCPR; // cpr of a citizen connected to the enquiry

    // Constructors
    /**
     * Constructor creates an enquiry
     *
     * @param id of an enquiry
     * @param source of an enquiry
     * @param date of an enquiry
     * @param description of an enquiry
     * @param citizencpr cpr of a citizen connected to an enquiry
     */
    public Enquiry(int id, String source, Date date, String description, int citizencpr) {
        this.id = id;
        this.source = source;
        this.date = date;
        this.description = description;
        this.citizenCPR = citizencpr;
    }

    /**
     * Constructor creating an enquiry by using the resultset of the database to
     * set the attributes of the enquiry class
     *
     * @param rs
     * @throws SQLException
     */
    public Enquiry(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.source = rs.getString("source");
        this.date = rs.getDate("date");
        this.description = rs.getString("description");
        this.citizenCPR = rs.getInt("citizencpr");
    }

    /**
     *
     * @returns id of an enquiry
     */
    @Override
    public int getID() {
        return id;
    }

    /**
     *
     * @returns source of an enquiry
     */
    @Override
    public String getSource() {
        return source;
    }

    /**
     *
     * @return date of when an enquiry is created
     */
    @Override
    public Date getDate() {
        return date;
    }

    /**
     *
     * @returns description of an enquiry
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     *
     * @returns cpr of the citizen connected to an enquiry
     */
    @Override
    public int getCitizenCPR() {
        return citizenCPR;
    }

}
