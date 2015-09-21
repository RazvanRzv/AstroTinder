package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class HelpPanel extends Panel {

	private String				text	= "Help";
	private Font				titleFont;
	private int					textWidth;
	private AffineTransform		affinetransform;
	private FontRenderContext	frc;

	private JLabel	titleText;
	private JLabel	helpArea;

	public HelpPanel() {
		super();
		init();
	}

	@Override
	public void init() {

		titleText = new JLabel(text);
		affinetransform = new AffineTransform();
		frc = new FontRenderContext(affinetransform, true, true);
		titleFont = new Font("Impact", Font.BOLD, 50);
		textWidth = (int) (titleFont.getStringBounds(text, frc).getWidth());
		titleText.setForeground(new Color(12193282));
		titleText.setFont(titleFont);
		titleText.setBounds((int) ((PANEL_WIDTH - textWidth) / 2), 70, 562, 50);
		this.add(titleText);

		helpArea = new JLabel();
		helpArea.setText(
				"<html><font size=\"7\",font color = \"#AD4A03\">Horoscope<br><font size=\"4\""
						+ ", font color = \"#9E3406\">Select your day and the month of your "
						+ "birthday.Four buttons will be enabled and you will can "
						+ "choose one of the following:<ul> <li>The guy in the suit, "
						+ "the profession button: will give you information about sign's "
						+ "future professions</li><li>The plus sign, the health button: "
						+ "will give you information about sign's health condition and "
						+ "predisposition to certain diseases </li><li>The hearth, the love "
						+ "button: will give you information about sign's love life</li><li>"
						+ "The thinking man, the personality button: will give you information "
						+ "about sign's personality </li></ul></font><font size=\"7\",font color "
						+ "= \"#AD4A03\">Compatibility </font><br> <font size=\"4\", font color "
						+ "= \"#9E3406\">Choose your zodiac sign or your birthday. Do the same for "
						+ "your partener and calculate the compatibility with each other</font></html>");
		helpArea.setBounds(100, 130, 700, 300);
		this.add(helpArea);
	}

}
