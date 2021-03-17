package main.java.database;

import main.java.models.Theme;

import java.sql.*;

public class Database {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ap_tips";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";
	
	public static Connection connection = null;
	
	static {
		try {
			connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	public static Theme selectThemeByUsername(String username) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT theme.* FROM user, settings, theme WHERE user.username=? AND user.settingsId=settings.id AND settings.themeId=theme.id;");
			statement.setString(1, username);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next())
				return convertResultSetToTheme(resultSet);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return null;
	}
	
	public static Theme selectThemeById(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM theme WHERE id=?");
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next())
				return convertResultSetToTheme(resultSet);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return null;
	}
	
	public static void updateThemeByUsername(String username, int themeId) {
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE user, settings SET settings.themeId=? WHERE user.username=? AND user.settingsId=settings.id;");
			statement.setInt(1, themeId);
			statement.setString(2, username);
			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	private static Theme convertResultSetToTheme(ResultSet resultSet) throws SQLException {
		Theme theme = new Theme();
		theme.id = resultSet.getInt("id");
		theme.primaryBackground = resultSet.getString("primaryBackground");
		theme.primaryText = resultSet.getString("primaryText");
		theme.successBackground = resultSet.getString("successBackground");
		theme.successText = resultSet.getString("successText");
		theme.dangerBackground = resultSet.getString("dangerBackground");
		theme.dangerText = resultSet.getString("dangerText");
		theme.background = resultSet.getString("background");
		theme.text = resultSet.getString("text");
		theme.defaultButtonBackground = resultSet.getString("defaultButtonBackground");
		theme.defaultButtonText = resultSet.getString("defaultButtonText");
		
		return theme;
	}
}
