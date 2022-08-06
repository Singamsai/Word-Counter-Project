import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class WordCounter extends JFrame implements ActionListener {
 
	JLabel lb1,lb2;
	JTextArea ta;
	JButton b;
	JButton pad,text;
	
	WordCounter(){
		super("Character and word counter");
		
		lb1=new JLabel("Characters:");
		lb1.setBounds(50, 50, 100, 20);
		
		lb2=new JLabel("Words:");
		lb2.setBounds(50,80,100,20);
		
		ta =new JTextArea();
		ta.setBounds(50, 110, 300, 200);
		
		b = new JButton("Click");
		b.setBounds(50,320,80,30);
		b.addActionListener(this);
		
		pad = new JButton("Pad Color");
		pad.setBounds(140, 320, 110, 30);
		pad.addActionListener(this);
		
		text = new JButton("Text Color");
		text.setBounds(260,320,110,30);
		text.addActionListener(this);
		
		add(lb1);add(lb2);add(ta);add(b);add(pad);add(text);
		
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(320,190); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b) {
			String text =  ta.getText();
			int freq=0;
			for(int i=0;i<text.length();i++) {
				if(text.charAt(i)==' ')
					continue;
				freq++;
			}
			lb1.setText("Characters:"+freq);
			
			int count=0;
			int k=text.length()-1;
			while(k-->=0) {
				if(text.charAt(k)!=' ')
					break;
			}
			for(int i=1;i<=k;i++) {
//			String word[]=text.split(" ");
				if(text.charAt(i-1)==text.charAt(i) && text.charAt(i)==' ') {
				continue;
				}
				if(text.charAt(i)==' ')
					count++;
			}
			if(text.length()==0)
				lb2.setText("Words:"+count);
			else
				lb2.setText("Words:"+(count+1));
		}
		else if(e.getSource()==pad) {
		Color c =JColorChooser.showDialog(this, "Choose color", Color.BLACK);
		ta.setBackground(c);
		
		}
		else if(e.getSource()==text) {
		Color c =JColorChooser.showDialog(this, "Choose color", Color.BLACK);
		ta.setForeground(c);
		}
	}
	
	public static void main(String[] args) {
		new WordCounter();
	}
}
