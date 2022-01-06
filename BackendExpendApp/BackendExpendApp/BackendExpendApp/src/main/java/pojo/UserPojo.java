package pojo;

public class UserPojo {
	private int userId;
	private String  firstname;
	private String  lastname;
	private String  email;
	private String username;
	private String  password;
	private String accessLevel;
	private boolean userRemoved;
	
	public UserPojo() {
		super();
	}
	
	
	public UserPojo(int userId, String firstname, String lastname, String email, String username,
			String password, String accessLevel, boolean userRemoved) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accessLevel = accessLevel;
		this.userRemoved = userRemoved;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAccessLevel() {
		return accessLevel;
	}


	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}


	public boolean isUserRemoved() {
		return userRemoved;
	}


	public void setUserRemoved(boolean userRemoved) {
		this.userRemoved = userRemoved;
	}


	@Override
	public String toString() {
		return "UserInformation [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", username=" + username + ", password=" + password + ", accessLevel=" + accessLevel
				+ ", userRemoved=" + userRemoved + "]";
	}
	

}
