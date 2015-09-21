package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Buttons.HButton;
import Helper.Sign;

@SuppressWarnings("serial")
public class HoroscopePanel extends Panel {

	private String				titleText	= "Horoscope";
	private Font				titleFont;
	private int					textWidth;
	private AffineTransform		affinetransform;
	private FontRenderContext	frc;

	private Handler	handler;
	private Sign	sign;

	// ######### Buttons #########
	private HButton	loveButton;
	private HButton	professionButton;
	private HButton	healthButton;
	private HButton	personalityButton;
	private JButton	calculateButton;

	// ######### Labels ##########
	private JLabel	titleLabel;
	private JLabel	selectLabel;
	private JLabel	dayLabel;
	private JLabel	monthLabel;
	private JLabel	ysiLabel;
	private JLabel	imageLabel;
	private JLabel	signLabel;

	// ######### ComboBoxes ##########
	private JComboBox<String>	dayBox;
	private JComboBox<String>	monthBox;

	// ######### Others ##########
	private JTextArea	textArea;
	private JScrollPane	scrollPane;

	public HoroscopePanel() {
		super();
		init();
	}

	@Override
	public void init() {

		handler = new Handler();

		titleLabel = new JLabel(titleText);
		affinetransform = new AffineTransform();
		frc = new FontRenderContext(affinetransform, true, true);
		titleFont = new Font("Impact", Font.BOLD, 50);
		textWidth = (int) (titleFont.getStringBounds(titleText, frc)
				.getWidth());
		titleLabel.setForeground(new Color(3735425));
		titleLabel.setFont(titleFont);
		titleLabel.setBounds((int) ((PANEL_WIDTH - textWidth) / 2), 20,
				textWidth + 10, 50);
		this.add(titleLabel);

		dayBox = new JComboBox<String>();
		dayBox.setBounds(100, 135, 150, 30);
		for (int i = 1; i <= 31; i++) {
			dayBox.addItem(Integer.toString(i));
		}
		this.add(dayBox);

		monthBox = new JComboBox<String>();
		monthBox.setBounds(380, 135, 150, 30);
		for (int i = 1; i <= 12; i++) {
			monthBox.addItem(Integer.toString(i));
		}
		this.add(monthBox);

		selectLabel = new JLabel("Select Date");
		selectLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		selectLabel.setBounds(40, 90, 150, 25);
		selectLabel.setForeground(Color.WHITE);
		this.add(selectLabel);

		dayLabel = new JLabel("Day:");
		dayLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dayLabel.setBounds(40, 135, 50, 25);
		dayLabel.setForeground(Color.WHITE);
		this.add(dayLabel);

		monthLabel = new JLabel("Month:");
		monthLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		monthLabel.setBounds(300, 135, 70, 25);
		monthLabel.setForeground(Color.WHITE);
		this.add(monthLabel);

		healthButton = new HButton(handler);
		healthButton.setBounds(100, 404, 120, 120);
		healthButton.setIcon("health");
		this.add(healthButton);

		professionButton = new HButton(handler);
		professionButton.setBounds(100, 224, 120, 120);
		professionButton.setIcon("profession");
		this.add(professionButton);

		loveButton = new HButton(handler);
		loveButton.setBounds(854, 224, 120, 120);
		loveButton.setIcon("love");
		this.add(loveButton);

		personalityButton = new HButton(handler);
		personalityButton.setBounds(854, 404, 120, 120);
		personalityButton.setIcon("personality");
		this.add(personalityButton);

		ysiLabel = new JLabel("Your sign is:");
		ysiLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ysiLabel.setBounds(778, 136, 100, 25);
		ysiLabel.setForeground(Color.WHITE);
		this.add(ysiLabel);

		imageLabel = new JLabel("");
		imageLabel.setBounds(900, 25, 100, 100);
		this.add(imageLabel);

		calculateButton = new JButton("Calculate");
		calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		calculateButton.setBounds(590, 135, 140, 30);
		calculateButton.addActionListener(handler);
		this.add(calculateButton);

		signLabel = new JLabel("");
		signLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		signLabel.setBounds(900, 136, 130, 25);
		signLabel.setForeground(Color.WHITE);
		this.add(signLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 224, 534, 300);
		this.add(scrollPane);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		sign = new Sign(dayBox, monthBox);

	}

	private String readFile(String path) {
		StringBuilder toReturn = new StringBuilder();
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(path);
		BufferedReader reader = null;
		String line;
		reader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			while ((line = reader.readLine()) != null) {
				toReturn.append(line);
				toReturn.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return toReturn.toString();
	}

	// Enable/Disable buttons
	private void setButtons(boolean bool1, boolean bool2, boolean bool3,
			boolean bool4) {
		loveButton.setEnabled(bool1);
		personalityButton.setEnabled(bool2);
		professionButton.setEnabled(bool3);
		healthButton.setEnabled(bool4);
	}

	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == calculateButton) {
				textArea.setText(null);
				if (!sign.isDateValid()) {
					setButtons(false, false, false, false);
					signLabel.setText("Invalid Date");
					imageLabel.setIcon(null);
				} else {
					setButtons(true, true, true, true);
					signLabel.setText(sign.getSignDate());
					imageLabel.setIcon(new ImageIcon(getClass().getResource(
							"/SignsImages/" + sign.getSignDate() + ".png")));

				}
			}
			if (e.getSource() == loveButton) {
				setButtons(false, true, true, true);
				textArea.setText(readFile("Horoscope/" + sign.getSignDate()
						+ "/" + sign.getSignDate() + "_love.txt"));
			}
			if (e.getSource() == personalityButton) {
				setButtons(true, false, true, true);
				textArea.setText(readFile("Horoscope/" + sign.getSignDate()
						+ "/" + sign.getSignDate() + "_personality.txt"));
			}
			if (e.getSource() == professionButton) {
				setButtons(true, true, false, true);
				textArea.setText(readFile("Horoscope/" + sign.getSignDate()
						+ "/" + sign.getSignDate() + "_profession.txt"));
			}
			if (e.getSource() == healthButton) {
				setButtons(true, true, true, false);
				textArea.setText(readFile("Horoscope/" + sign.getSignDate()
						+ "/" + sign.getSignDate() + "_health.txt"));
			}
		}

	}

}
