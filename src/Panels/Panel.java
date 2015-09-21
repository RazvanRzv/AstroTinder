package Panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Panel extends JPanel {

	protected JLabel		background;
	public static final int	PANEL_WIDTH		= 1074;
	public static final int	PANEL_HEIGHT	= 574;

	public Panel() {
		this.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		this.setLayout(null);
	}

	public abstract void init();

	public void setBackground(String path) {
		background = new JLabel();
		background.setIcon(new ImageIcon(getClass().getResource(path)));
		background.setBounds(0, 0, 1080, 603);
		this.add(background);
	}

}
