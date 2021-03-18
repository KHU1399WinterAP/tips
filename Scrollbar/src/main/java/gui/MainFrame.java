package main.java.gui;

import javax.swing.*;

public class MainFrame extends JFrame {
	private JScrollPane mainPanel;
	
	public MainFrame() {
		super("Scrollbar");
		
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		pack();
		setLocationRelativeTo(null);
	}
}
