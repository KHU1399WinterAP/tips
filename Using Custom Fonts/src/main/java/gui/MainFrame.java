package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFrame extends JFrame {
	private JPanel mainPanel;
	private JLabel label;
	
	private Font pacifico;
	
	public MainFrame() {
		super("Using Custom Fonts");
		
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		pack();
		setLocationRelativeTo(null);
		
		initFonts();
		initComponentProperties();
	}
	
	private void initFonts() {
		try {
			String FONT_FILE_PATH = "main/resources/fonts/Pacifico.ttf";
			
			var stream = getClass().getClassLoader().getResourceAsStream(FONT_FILE_PATH);
			if (stream == null)
				throw new FileNotFoundException();
			
			pacifico = Font.createFont(Font.TRUETYPE_FONT, stream);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initComponentProperties() {
		label.setFont(pacifico.deriveFont(Font.PLAIN, 36));
	}
}
