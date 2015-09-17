package Panels;

import javax.swing.JPanel;

public abstract class Panel extends JPanel{

	public static final int PANEL_WIDTH = 1074;
	public static final int PANEL_HEIGHT = 574;
	
	public Panel(){
		this.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		this.setLayout(null);
	}
	
	public abstract void init();
	
}
