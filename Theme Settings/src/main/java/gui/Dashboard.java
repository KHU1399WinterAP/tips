package main.java.gui;

import main.java.database.Database;
import main.java.models.User;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Dashboard extends JFrame {
	private JPanel mainPanel;
	private JButton primaryButton;
	private JButton toggleThemeButton;
	private JButton exitButtonButton;
	
	private final User activeUser = new User("BijanProgrammer", "1234", 0);
	private boolean isDarkTheme = Objects.requireNonNull(Database.selectThemeByUsername(activeUser.username)).id == 2;
	
	public Dashboard() {
		super("Theme Settings");
		
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		pack();
		setLocationRelativeTo(null);
		
		applyTheme();
		initListeners();
	}
	
	private void initListeners() {
		initToggleThemeButtonListeners();
	}
	
	private void initToggleThemeButtonListeners() {
		toggleThemeButton.addActionListener(
				e -> {
					isDarkTheme = !isDarkTheme;
					Database.updateThemeByUsername(activeUser.username, isDarkTheme ? 2 : 1);
					applyTheme();
				}
		);
	}
	
	private void applyTheme() {
		var theme = Database.selectThemeByUsername(activeUser.username);
		if (theme == null)
			return;
		
		mainPanel.setBackground(Color.decode(theme.background));
		mainPanel.setForeground(Color.decode(theme.text));
		
		primaryButton.setBackground(Color.decode(theme.primaryBackground));
		primaryButton.setForeground(Color.decode(theme.primaryText));
		
		toggleThemeButton.setBackground(Color.decode(theme.defaultButtonBackground));
		toggleThemeButton.setForeground(Color.decode(theme.defaultButtonText));
		
		exitButtonButton.setBackground(Color.decode(theme.dangerBackground));
		exitButtonButton.setForeground(Color.decode(theme.dangerText));
	}
}
