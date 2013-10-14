package Data;
/**
 * 
 * @author fr0609
 */
public abstract class User {

	private String name;
	private String id;
	private String password;

public abstract int getType();
/**
 * 
 * @param name
 * @param id
 * @param password 
 */
    public User(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }
/**
 * 
 * @return 
 */
    public String getName() {
        return name;
    }
/**
 * 
 * @param name 
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * 
 * @return 
 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
/**
 * 
 * @return 
 */
    public String getPassword() {
        return password;
    }
/**
 * 
 * @param password 
 */
    public void setPassword(String password) {
        this.password = password;
    }

 

}
