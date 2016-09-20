package movietickets.model;

import java.io.Serializable;

public class User implements Serializable {

	private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;

    public User(int id, String firstName, String lastName, String emailId, String password) {
    	
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.emailId = emailId;
    	this.password = password;
    }
    
    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
