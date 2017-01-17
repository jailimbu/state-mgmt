package models;

public class User {
	private String userName;
	private String password;
	
	public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getName()
    {
        return this.userName;
    }
    
	public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return this.password;
    }
}
