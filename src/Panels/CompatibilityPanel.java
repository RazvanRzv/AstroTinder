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
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Helper.Sign;

@SuppressWarnings("serial")
public class CompatibilityPanel extends Panel {

	private String				titleText	= "Compatibility";
	private Font				titleFont;
	private int					textWidth;
	private AffineTransform		affinetransform;
	private FontRenderContext	frc;

	private Handler handler;

	private Sign	hisSign;
	private Sign	herSign;

	private String[]	signsArray;
	private String[][]	filesMatrix;

	// ########## Buttons ##########
	private JButton			calculateButton;
	private JRadioButton	hisSignButton;
	private JRadioButton	hisBirthButton;
	private JRadioButton	herSignButton;
	private JRadioButton	herBirthButton;

	// ########## Labels ##########
	private JLabel	titleLabel;
	private JLabel	hisBLabel;
	private JLabel	hisDLabel;
	private JLabel	hisMLabel;
	private JLabel	hisSILabel;
	private JLabel	hisSignLabel;
	private JLabel	hisImage;
	private JLabel	herBLabel;
	private JLabel	herDLabel;
	private JLabel	herMLabel;
	private JLabel	herSILabel;
	private JLabel	herSignLabel;
	private JLabel	herImage;
	private JLabel	yacLabel;
	private JLabel	hisSLabel;
	private JLabel	herSLabel;

	// ########## ComboBoxes ##########
	private JComboBox<String>	hisDay;
	private JComboBox<String>	hisMonth;
	private JComboBox<String>	herDay;
	private JComboBox<String>	herMonth;
	private JComboBox<String>	hisSignBox;
	private JComboBox<String>	herSignBox;

	// ########## Others ##########
	private JScrollPane		scrollPane;
	private JTextArea		textArea;
	private JProgressBar	bar;
	private String			hisString;
	private String			herString;
	private int				compatibility;

	public CompatibilityPanel() {
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
		titleLabel.setForeground(new Color(4571647));
		titleLabel.setFont(titleFont);
		titleLabel.setBounds((int) ((PANEL_WIDTH - textWidth) / 2), 20,
				textWidth + 10, 50);
		this.add(titleLabel);

		hisSignButton = new JRadioButton("Zodiac Sign");
		hisSignButton.setBounds(100, 100, 120, 30);
		hisSignButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		hisSignButton.setOpaque(false);
		hisSignButton.addActionListener(handler);
		hisSignButton.setForeground(Color.CYAN);
		this.add(hisSignButton);

		hisBirthButton = new JRadioButton("Birthday date");
		hisBirthButton.setSelected(true);
		hisBirthButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		hisBirthButton.setBounds(100, 70, 120, 30);
		hisBirthButton.setOpaque(false);
		hisBirthButton.addActionListener(handler);
		hisBirthButton.setForeground(Color.CYAN);
		this.add(hisBirthButton);

		hisBLabel = new JLabel("Select his birthday:");
		hisBLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hisBLabel.setBounds(100, 140, 170, 25);
		hisBLabel.setForeground(Color.CYAN);
		this.add(hisBLabel);

		hisDLabel = new JLabel("Day");
		hisDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hisDLabel.setBounds(100, 180, 50, 25);
		hisDLabel.setForeground(Color.CYAN);
		this.add(hisDLabel);

		hisDay = new JComboBox<String>();
		hisDay.setBounds(100, 210, 150, 30);
		for (int i = 1; i <= 31; i++) {
			hisDay.addItem(Integer.toString(i));
		}
		this.add(hisDay);

		hisMLabel = new JLabel("Month");
		hisMLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hisMLabel.setBounds(100, 260, 80, 25);
		hisMLabel.setForeground(Color.CYAN);
		this.add(hisMLabel);

		hisMonth = new JComboBox<String>();
		hisMonth.setBounds(100, 290, 150, 30);
		for (int i = 1; i <= 12; i++) {
			hisMonth.addItem(Integer.toString(i));
		}
		this.add(hisMonth);

		hisSILabel = new JLabel("His sign is:");
		hisSILabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hisSILabel.setBounds(100, 335, 100, 25);
		hisSILabel.setForeground(Color.CYAN);
		this.add(hisSILabel);

		hisSignLabel = new JLabel("");
		hisSignLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hisSignLabel.setBounds(200, 335, 100, 25);
		hisSignLabel.setForeground(Color.CYAN);
		this.add(hisSignLabel);

		hisImage = new JLabel("");
		hisImage.setBounds(100, 390, 100, 100);
		this.add(hisImage);

		herSignButton = new JRadioButton("Zodiac Sign");
		herSignButton.setBounds(804, 100, 120, 30);
		herSignButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		herSignButton.setOpaque(false);
		herSignButton.addActionListener(handler);
		herSignButton.setForeground(Color.CYAN);
		this.add(herSignButton);

		herBirthButton = new JRadioButton("Birthday date");
		herBirthButton.setSelected(true);
		herBirthButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		herBirthButton.setBounds(804, 70, 120, 30);
		herBirthButton.setOpaque(false);
		herBirthButton.addActionListener(handler);
		herBirthButton.setForeground(Color.CYAN);
		this.add(herBirthButton);

		herBLabel = new JLabel("Select her birthday:");
		herBLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		herBLabel.setBounds(804, 140, 170, 25);
		herBLabel.setForeground(Color.CYAN);
		this.add(herBLabel);

		herDLabel = new JLabel("Day");
		herDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		herDLabel.setBounds(804, 180, 50, 25);
		herDLabel.setForeground(Color.CYAN);
		this.add(herDLabel);

		herDay = new JComboBox<String>();
		herDay.setBounds(804, 210, 150, 30);
		for (int i = 1; i <= 31; i++) {
			herDay.addItem(Integer.toString(i));
		}
		this.add(herDay);

		herMLabel = new JLabel("Month");
		herMLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		herMLabel.setBounds(804, 260, 80, 25);
		herMLabel.setForeground(Color.CYAN);
		this.add(herMLabel);

		herMonth = new JComboBox<String>();
		herMonth.setBounds(804, 290, 150, 30);
		for (int i = 1; i <= 12; i++) {
			herMonth.addItem(Integer.toString(i));
		}
		this.add(herMonth);

		herSILabel = new JLabel("Her sign is:");
		herSILabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		herSILabel.setBounds(804, 335, 100, 25);
		herSILabel.setForeground(Color.CYAN);
		this.add(herSILabel);

		herSignLabel = new JLabel("");
		herSignLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		herSignLabel.setBounds(904, 335, 100, 25);
		herSignLabel.setForeground(Color.CYAN);
		this.add(herSignLabel);

		herImage = new JLabel("");
		herImage.setBounds(804, 390, 100, 100);
		this.add(herImage);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 120, 464, 280);
		this.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		bar = new JProgressBar();
		bar.setForeground(Color.PINK);
		bar.setStringPainted(true);
		bar.setBounds(474, 420, 300, 30);
		this.add(bar);

		yacLabel = new JLabel("You are compatible:");
		yacLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		yacLabel.setBounds(300, 425, 170, 25);
		yacLabel.setForeground(Color.CYAN);
		this.add(yacLabel);

		calculateButton = new JButton("Calculate");
		calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		calculateButton.setBounds((int) ((Panel.PANEL_WIDTH - 180) / 2), 494,
				180, 40);
		calculateButton.addActionListener(handler);
		this.add(calculateButton);

		// Set signs array
		signsArray = new String[12];
		filesMatrix = new String[12][12];
		populateArray();

		// Populate a matrix with names of the file that will be used in
		// textArea
		for (int i = 0; i < 12; i++) {
			for (int j = i; j < 12; j++) {
				filesMatrix[i][j] = signsArray[i] + "_" + signsArray[j]
						+ ".txt";
				filesMatrix[j][i] = signsArray[i] + "_" + signsArray[j]
						+ ".txt";
			}
		}

		hisSLabel = new JLabel("Select his sign:");
		hisSLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		hisSLabel.setBounds(100, 180, 170, 30);
		hisSLabel.setVisible(false);
		this.add(hisSLabel);

		hisSignBox = new JComboBox<String>();
		hisSignBox.setVisible(false);
		hisSignBox.setBounds(100, 240, 150, 30);
		addSigns(hisSignBox);
		this.add(hisSignBox);

		herSLabel = new JLabel("Select her sign:");
		herSLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		herSLabel.setBounds(804, 180, 170, 30);
		herSLabel.setVisible(false);
		this.add(herSLabel);

		herSignBox = new JComboBox<String>();
		herSignBox.setVisible(false);
		herSignBox.setBounds(804, 240, 150, 30);
		addSigns(herSignBox);
		this.add(herSignBox);

		hisSign = new Sign(hisDay, hisMonth, hisSignBox);
		herSign = new Sign(herDay, herMonth, herSignBox);

	}

	private void populateArray() {
		signsArray[0] = "Aries";
		signsArray[1] = "Taurus";
		signsArray[2] = "Gemini";
		signsArray[3] = "Cancer";
		signsArray[4] = "Leo";
		signsArray[5] = "Virgo";
		signsArray[6] = "Libra";
		signsArray[7] = "Scorpio";
		signsArray[8] = "Sagittarius";
		signsArray[9] = "Capricorn";
		signsArray[10] = "Aquarius";
		signsArray[11] = "Pisces";
	}

	private void addSigns(JComboBox<String> box) {
		for (int i = 0; i < 12; i++) {
			box.addItem(signsArray[i]);
		}
	}

	private int getSignPos(String sign) {
		if (sign.equals("Aries"))
			return 0;
		if (sign.equals("Taurus"))
			return 1;
		if (sign.equals("Gemini"))
			return 2;
		if (sign.equals("Cancer"))
			return 3;
		if (sign.equals("Leo"))
			return 4;
		if (sign.equals("Virgo"))
			return 5;
		if (sign.equals("Libra"))
			return 6;
		if (sign.equals("Scorpio"))
			return 7;
		if (sign.equals("Sagittarius"))
			return 8;
		if (sign.equals("Capricorn"))
			return 9;
		if (sign.equals("Aquarius"))
			return 10;
		if (sign.equals("Pisces"))
			return 11;

		return 12;
	}

	private void fillBar(final int limit) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				int x = 0;
				while (x < limit) {
					x++;
					bar.setValue(x);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private String readFile(String path) {
		StringBuilder toReturn = new StringBuilder();
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(path);
		BufferedReader reader = null;
		String line;
		reader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			this.compatibility = Integer.parseInt(reader.readLine());
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

	private void hisSignEnabled(boolean bool) {
		hisBLabel.setVisible(!bool);
		hisDLabel.setVisible(!bool);
		hisMLabel.setVisible(!bool);
		hisDay.setVisible(!bool);
		hisMonth.setVisible(!bool);
		hisSLabel.setVisible(bool);
		hisSignBox.setVisible(bool);
	}

	private void herSignEnabled(boolean bool) {
		herBLabel.setVisible(!bool);
		herDLabel.setVisible(!bool);
		herMLabel.setVisible(!bool);
		herDay.setVisible(!bool);
		herMonth.setVisible(!bool);
		herSLabel.setVisible(bool);
		herSignBox.setVisible(bool);
	}

	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == hisSignButton) {
				hisBirthButton.setSelected(false);
				hisSignButton.setSelected(true);
				hisSignEnabled(true);
			}
			if (e.getSource() == hisBirthButton) {
				hisSignButton.setSelected(false);
				hisBirthButton.setSelected(true);
				hisSignEnabled(false);
			}
			if (e.getSource() == herSignButton) {
				herBirthButton.setSelected(false);
				herSignButton.setSelected(true);
				herSignEnabled(true);
			}
			if (e.getSource() == herBirthButton) {
				herSignButton.setSelected(false);
				herBirthButton.setSelected(true);
				herSignEnabled(false);
			}
			if (e.getSource() == calculateButton) {
				if (hisBirthButton.isSelected()) {
					hisString = hisSign.getSignDate();
				}
				if (herBirthButton.isSelected()) {
					herString = herSign.getSignDate();
				}
				if (hisSignButton.isSelected()) {
					hisString = hisSign.getSign();
				}
				if (herSignButton.isSelected()) {
					herString = herSign.getSign();
				}

				hisSignLabel.setText(hisString);
				hisImage.setIcon(new ImageIcon(getClass()
						.getResource("/SignsImages/" + hisString + ".png")));

				herSignLabel.setText(herString);
				herImage.setIcon(new ImageIcon(getClass()
						.getResource("/SignsImages/" + herString + ".png")));

				textArea.setText(readFile("Compatibility/"
						+ filesMatrix[getSignPos(hisString)][getSignPos(
								herString)]));
				fillBar(compatibility);
			}
		}

	}

}
