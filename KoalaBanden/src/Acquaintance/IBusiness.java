package Acquaintance;

import Business.User;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface IBusiness {

    public abstract void injectData(IData data);

    public Map<Integer, ICase> getCases();
    
    public HashMap<Integer, User> getUsers();

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
}
