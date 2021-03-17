package main.java.models;

public class Settings {
	public int id;
	public int themeId;
	
	public Settings(int id, int themeId) {
		this.id = id;
		this.themeId = themeId;
	}
	
	@Override
	public String toString() {
		return "Settings{" +
				"id=" + id +
				", themeId=" + themeId +
				'}';
	}
}
