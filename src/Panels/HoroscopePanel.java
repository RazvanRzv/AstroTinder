package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class HoroscopePanel extends Panel{

	private String text = "Horoscope";
	private Font titleFont;
	private int textWidth;
	private AffineTransform affinetransform;
	private FontRenderContext frc;
	
	private Handler handler;
	
//	#########  Buttons  #########
	JButton calculateButton;
	JButton loveButton;
	JButton professionButton;
	JButton healthButton;
	JButton personalityButton;
	
//  #########  Strings #########
	String loveString;
	String professionString;
	String healthString;
	String personalityString;
	
	public HoroscopePanel (){
		super();
		init();
	}
	
	@Override
	public void init() {
		this.setBackground(Color.GREEN);
		
		handler = new Handler();
		
		JLabel titleText = new JLabel(text);
		affinetransform = new AffineTransform();     
		frc = new FontRenderContext(affinetransform,true,true);   
		titleFont = new Font("Impact", Font.BOLD, 50);
		textWidth = (int)(titleFont.getStringBounds(text, frc).getWidth());		
		titleText.setForeground(Color.RED);
		titleText.setFont(titleFont);
		titleText.setBounds((int)((PANEL_WIDTH - textWidth) / 2), 20, textWidth + 10, 50);
		
		this.add(titleText);
		
	}

	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == calculateButton){
				loveButton.setEnabled(true);
				personalityButton.setEnabled(true);
				professionButton.setEnabled(true);
				healthButton.setEnabled(true);
			}
		}
		
	}
	
}
