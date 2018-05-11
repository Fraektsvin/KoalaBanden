package Acquaintance;

import Business.User;
import java.util.Collection;
import java.util.Map;

public interface IBusiness {

    public abstract void injectData(IData data);

    public Map<Integer, ICase> getCases();
    
    public Map<String, IUser> getUsers();

    public ICaseworker getCaseworker();

    public void createCaseworker(String username, String password, String email, int SSN, int accesslevel);

    IData getData();
    
    public int login(String userName, String password);
    
    public boolean createUser(String username, String password, String email, String SSN, String accessLevel);
    
    public Collection getAccessLevels();
    
    public void deleteUser(String username);
    
    public int getCurrentAccessLevel();
}
