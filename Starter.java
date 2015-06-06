import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Starter extends JPanel{
	JLabel s;
	JTextArea a;
	JButton goOn;
	int w;
	int h;
	JFrame latinSlide;
	Definitions search;
	public Starter(Definitions asdf, JFrame q,int width, int height){
		search = asdf;
		latinSlide = q;
		w = width;
		h = height;
		
		s = new JLabel("Paste in the latin you are going to translate");
		this.add(s);
		a = new JTextArea();
		JScrollPane areaScrollPane = new JScrollPane(a);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(width-20, 400));
		this.add(areaScrollPane);
		
		goOn = new JButton("start Translateing");
		goOn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			    createTranslation();
			  }
			});
		this.add(goOn);
	}
	public void createTranslation(){
		char[] delimeters = {';','.'};
		String latin = a.getText();
		
		ArrayList<String> sentences = new ArrayList<String>();
		int indexLastPeriod = 0;
		for(int i = 0; i < latin.length(); i ++){
			//System.out.println(i);
			for(char del: delimeters){
				if(del == latin.charAt(i)){
					sentences.add(latin.substring(indexLastPeriod,i+1));
					indexLastPeriod = i+1;
				}
			}	
		}
		if(indexLastPeriod +2 < latin.length()){
			sentences.add(latin.substring(indexLastPeriod));
		}
		for(int i = 0; i < sentences.size(); i ++){
			sentences.set(i, sentences.get(i).replaceAll("\n"," "));
		}
		this.setVisible(false);
		latinSlide.add(new TextEditing(search, sentences, w, h));
	}
	

}
