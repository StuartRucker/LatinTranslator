import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {
	
	
	public static void main(String[] args){
		final int VERTMARGIN = 70;
		final int DEFWIDTH = 400;
		final int BUFFER = 10;
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		final int WIDTH = (int) d.getWidth();
		final int HEIGHT = (int) d.getWidth();
		JFrame mainPanel = new JFrame("Exeter Latin");
		mainPanel.setSize(WIDTH-DEFWIDTH-BUFFER, HEIGHT - VERTMARGIN);
		
		
		//frame with the definitions
		JFrame definitions = new JFrame("Definitions");
		definitions.setSize(DEFWIDTH, (int) (d.getHeight()-VERTMARGIN));
		definitions.setLocation((int)d.getWidth()-DEFWIDTH, 0);
		Definitions search = new Definitions(DEFWIDTH);
		definitions.add(search);
		definitions.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		definitions.setVisible(true);
		
		//panel which asks for latin to be pasted
		JPanel optionHolder = new Starter(search, mainPanel,WIDTH-DEFWIDTH-BUFFER-10, HEIGHT - VERTMARGIN);
		mainPanel.add(optionHolder);
		
		mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setVisible(true);
		//main

	}
	
	
	
}
