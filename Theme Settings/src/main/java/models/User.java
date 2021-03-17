package main.java.models;

public class User {
	public String username;
	public String password;
	public int settingsId;
	
	public User(String username, String password, int settingsId) {
		this.username = username;
		this.password = password;
		this.settingsId = settingsId;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", settingsId=" + settingsId +
				'}';
	}
}
