package Acquaintance;

import Business.Enquiry;
import Business.User;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface IBusiness {

    public abstract void injectData(IData data);

    public HashMap<Integer, ICase> getCases();
    
    public HashMap<Integer, IUser> getUsers();

    public ICaseworker getCaseworker();

    public void createCaseworker(String username, String password, String email, int SSN, AccessLevel accesslevel);

    IData getData();
    
    public IUser login(String userName, String password);
    
    public boolean createUser(String username, String password, String email, String SSN, AccessLevel accessLevel);
    
    public Collection getAccessLevels();
    
    public void deleteUser(String username);
    
    public AccessLevel getCurrentAccessLevel();
    
    public IUser getUser(String userName, String password);
    
      public IUser getUser(String userName);
    
    public String getCurrentUsername();
    
    public void setUser(String Username);
    
    public HashMap<Integer, IEnquiry> getEnquiries();
    
    public HashMap<Integer, ICitizen> getCitizens() throws SQLException;
}
