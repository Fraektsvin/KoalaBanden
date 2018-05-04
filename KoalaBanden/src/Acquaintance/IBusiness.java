package Acquaintance;

import java.util.Map;

public interface IBusiness {

    public abstract void injectData(IData data);
    public Map<Integer, ICase> getCases(); 
    public void createCase(int citizenSSN);
    IData getData();
}
