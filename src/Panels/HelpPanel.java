package Panels;

import java.awt.Color;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HelpPanel extends Panel{
	
	private JTextArea helpTextArea;
	
	public HelpPanel(){
		super();
		init();
	}

	@Override
	public void init() {
		this.setBackground(Color.YELLOW);
		
		helpTextArea = new JTextArea();
		helpTextArea.setText("asdwwq");
		helpTextArea.setBounds(73, 38, 816, 289);
		helpTextArea.setLineWrap(true);
		helpTextArea.setOpaque(false);
		helpTextArea.setEditable(false);
		
		this.add(helpTextArea);

	}

}
