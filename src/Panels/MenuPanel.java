package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuPanel extends Panel{

	public MenuPanel(){
		super();
		init();
	}
	
	public void init(){
		this.setBackground(Color.CYAN);
		
		JLabel lblNewLabel = new JLabel("Welcome to AstroTinder");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Impact", Font.BOLD, 50));
		lblNewLabel.setBounds((int)((PANEL_WIDTH - 562) / 2), 68, 562, 50);
		
		this.add(lblNewLabel);
	}
	
}
