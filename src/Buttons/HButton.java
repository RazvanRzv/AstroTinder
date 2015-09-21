package Buttons;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class HButton extends JButton {

	public HButton(ActionListener handler) {
		super();
		super.setEnabled(false);
		super.setOpaque(false);
		super.setContentAreaFilled(false);
		super.setBorderPainted(false);
		super.addActionListener(handler);
	}

	public void setIcon(String button) {
		super.setIcon(new ImageIcon(getClass()
				.getResource("/Buttons/" + button + "Button" + ".png")));

	}

}
