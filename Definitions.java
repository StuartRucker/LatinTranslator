import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Definitions extends JPanel{
	JComboBox dictOpt;
	JTextField search;
	JTextArea def;
	Wiktionairy wik;

	public Definitions(int width){
		
		wik = new Wiktionairy();
		
		String[] dicts = { "Wiktionairy" };
		dictOpt = new JComboBox(dicts);
		this.add(dictOpt);
		
		search = new JTextField(20);
		search.addKeyListener(new KeyAdapter() {
		      public void keyReleased(KeyEvent e) {
		        if(e.getKeyCode() == KeyEvent.VK_ENTER && search.getText().length() > 1){
		        	updateDef(search.getText());
		        	
		        }
		      }

		      public void keyTyped(KeyEvent e) {
		      }

		      public void keyPressed(KeyEvent e) {
		      }
		    });
		  
		this.add(search);
		
		
		def = new JTextArea();
		def.setEditable(false);
		JScrollPane areaScrollPane = new JScrollPane(def);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(width-20, 400));
		this.add(areaScrollPane);
	}
	public void updateDef(String a){
		def.setText(wik.search(a));
	}
	
}
