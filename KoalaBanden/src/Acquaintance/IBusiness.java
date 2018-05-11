package Acquaintance;

import java.util.Map;

public interface IBusiness {

    public abstract void injectData(IData data);

    public Map<Integer, ICase> getCases();

    public ICaseworker getCaseworker();

    public void createCaseworker(String username, String password, String email, int SSN, int accesslevel);

    IData getData();
    
    public int login(String userName, String password);
}
