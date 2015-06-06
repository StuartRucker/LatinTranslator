import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TextEditing extends JPanel implements MouseListener{
	ArrayList<JTextField> latin;
	ArrayList<JTextArea> english;
	Definitions search;
	JButton finish;
	
	public TextEditing (Definitions searcher, ArrayList<String> latinLabel, int width, int height){
		
		search = searcher;
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		latin = new ArrayList<JTextField>();
		english = new ArrayList<JTextArea>();
		for(String text: latinLabel){
			JTextField tmp1 = new JTextField(text);
			tmp1.setAlignmentX(Component.LEFT_ALIGNMENT);
			tmp1.setBackground(new Color(230,230,230));
			tmp1.addMouseListener(this);
			tmp1.setEditable(false);
			latin.add(tmp1);
			main.add(tmp1);
			JTextArea tmp2 = new JTextArea(2,10);
			tmp2.setAlignmentX(Component.LEFT_ALIGNMENT);
			english.add(tmp2);
			main.add(tmp2);	
		}

		
		JScrollPane areaScrollPane = new JScrollPane(main);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(width,height/2));
		this.add(areaScrollPane);
		
		finish = new JButton("generate final text");
		finish.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			    JFrame s = new JFrame();
			    s.setVisible(true);
			    String finalTx = "";
			    for(int i = 0; i < latin.size(); i ++){
			    	finalTx += "<b>" + latin.get(i).getText() + "</b><br>" + english.get(i).getText() + "<br>";
			    }
			    JEditorPane textarea = new JEditorPane("text/html", "");
			    textarea.setText(finalTx);
			    s.add(textarea);
			  }
			});
		this.add(finish);
		
	
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("Clicked");
		for(JTextField s: latin){
			String selected = s.getSelectedText();
			if(selected != null){
				search.updateDef(selected);
			}
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
