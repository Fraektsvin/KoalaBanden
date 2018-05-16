package Acquaintance;

import java.util.Collection;
import java.util.Map;

public interface IBusiness {

    public abstract void injectData(IData data);

    public Map<Integer, ICase> getCases();
    
    public Map<String, IUser> getUsers();

    public ICaseworker getCaseworker();

    public void createCaseworker(String username, String password, String email, int SSN, AccessLevel accesslevel);

    IData getData();
    
    public IUser login(String userName, String password);
    
    public boolean createUser(String username, String password, String email, String SSN, AccessLevel accessLevel);
    
    public Collection getAccessLevels();
    
    public void deleteUser(String username);
    
    public AccessLevel getCurrentAccessLevel();
    
    public IUser getUser(String userName, String password);
    
    public String getCurrentUsername();
}
