package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuPanel extends Panel {

	private String				text	= "Welcome to AstroTinder";
	private Font				titleFont;
	private int					textWidth;
	private AffineTransform		affinetransform;
	private FontRenderContext	frc;

	private JLabel titleText;

	public MenuPanel() {
		super();
		init();
	}

	public void init() {

		titleText = new JLabel(text);
		affinetransform = new AffineTransform();
		frc = new FontRenderContext(affinetransform, true, true);
		titleFont = new Font("Impact", Font.BOLD, 50);
		textWidth = (int) (titleFont.getStringBounds(text, frc).getWidth());
		titleText.setForeground(new Color(16383821));
		titleText.setFont(titleFont);
		titleText.setBounds((int) ((PANEL_WIDTH - textWidth) / 2), 68, 562, 50);

		this.add(titleText);
	}

}
