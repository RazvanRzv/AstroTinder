package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import Panels.CompatibilityPanel;
import Panels.HelpPanel;
import Panels.HoroscopePanel;
import Panels.MenuPanel;
import Panels.Panel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Color;

public class AstroTinder {
	
	private JFrame frame;
	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int BUTTON_WIDTH = 400;
	public static final int BUTTON_HEIGHT = 55;
	public static final int BUTTON_X = (int)((Panel.PANEL_WIDTH - BUTTON_WIDTH)/2);

	Handler handler;
	
	// #########  Panels  #########
	
	private HoroscopePanel horoscopePanel;
	private MenuPanel menuPanel;
	private HelpPanel helpPanel;
	private CompatibilityPanel compatibilityPanel; 
	
	// #########  Buttons  #########
	
	JButton horoscopeButton; 
	JButton compatibilityButton;
	JButton helpButton;
	JButton quitButton;
	
	JButton helpBackButton;
	JButton compBackButton;
	JButton horoBackButton;	
	
	
	JButton btnNewButton;
	JProgressBar progressBar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AstroTinder window = new AstroTinder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AstroTinder() {
		init();
	}

	private void init() {
		
		frame = new JFrame();
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		handler = new Handler();
		
		compatibilityPanel = new CompatibilityPanel();
		frame.getContentPane().add(compatibilityPanel);
		compatibilityPanel.setVisible(false);
		
//		#######################  Compatibility Panel Button  #######################
		
		compBackButton = new JButton("Back");
		compBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		compBackButton.setBounds(984, 549, 90, 25);
		compBackButton.addActionListener(handler);
		compatibilityPanel.add(compBackButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 170, 150, 30);
		compatibilityPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(100, 250, 150, 30);
		compatibilityPanel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(804, 170, 150, 30);
		compatibilityPanel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(804, 250, 150, 30);
		compatibilityPanel.add(comboBox_3);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds((int)((Panel.PANEL_WIDTH - 180)/2), 494, 180, 40);
		btnNewButton.addActionListener(handler);;
		compatibilityPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select his birthday:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(100, 100, 170, 25);
		compatibilityPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Day");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(100, 140, 50, 25);
		compatibilityPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Month");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(100, 220, 80, 25);
		compatibilityPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("His sign is:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(100, 335, 100, 25);
		compatibilityPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(200, 335, 100, 25);
		compatibilityPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("HisImage");
		lblNewLabel_5.setBounds(100, 390, 100, 100);
		compatibilityPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Select her birthday:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(804, 100, 170, 25);
		compatibilityPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Day");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(804, 140, 50, 25);
		compatibilityPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Month");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_8.setBounds(804, 220, 80, 25);
		compatibilityPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Her sign is:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_9.setBounds(804, 335, 100, 25);
		compatibilityPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("herImage");
		lblNewLabel_10.setBounds(804, 390, 100, 100);
		compatibilityPanel.add(lblNewLabel_10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(300, 120, 474, 280);
		compatibilityPanel.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.PINK);
		progressBar.setStringPainted(true);
		progressBar.setBounds(474, 420, 300, 30);
		compatibilityPanel.add(progressBar);
		
		JLabel lblNewLabel_11 = new JLabel("You are compatible:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(300, 425, 170, 25);
		compatibilityPanel.add(lblNewLabel_11);
		
		horoscopePanel = new HoroscopePanel();
		frame.getContentPane().add(horoscopePanel);		
		
		helpPanel = new HelpPanel();
		frame.getContentPane().add(helpPanel);
		helpPanel.setVisible(false);
		
		JComboBox<String> dayBox = new JComboBox<String>();
		dayBox.setBounds(100, 135, 150, 30);
		for(int i=1; i<=31; i++){
			dayBox.addItem(Integer.toString(i));
		}
		horoscopePanel.add(dayBox);
		
		JComboBox<String> monthBox = new JComboBox<String>();
		monthBox.setBounds(380, 135, 150, 30);
		for(int i=1; i<=12; i++){
			monthBox.addItem(Integer.toString(i));
		}
		horoscopePanel.add(monthBox);
		
		JLabel selectLabel = new JLabel("Select Date");
		selectLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		selectLabel.setBounds(40, 90, 100, 25);
		horoscopePanel.add(selectLabel);
		
		JLabel dayLabel = new JLabel("Day:");
		dayLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dayLabel.setBounds(40, 135, 50, 25);
		horoscopePanel.add(dayLabel);
		
		JLabel monthLabel = new JLabel("Month:");
		monthLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		monthLabel.setBounds(300, 135, 70, 25);
		horoscopePanel.add(monthLabel);
		
		JButton healthButton = new JButton("Health");
		healthButton.setEnabled(false);
		healthButton.setBounds(100, 404, 120, 120);
		horoscopePanel.add(healthButton);
		
		JButton proffesionButton = new JButton("profesion");
		proffesionButton.setBounds(100, 224, 120, 120);
		proffesionButton.setEnabled(false);
		horoscopePanel.add(proffesionButton);
		
		JButton loveButton = new JButton("love");
		loveButton.setBounds(854, 224, 120, 120);
		loveButton.setEnabled(false);
		horoscopePanel.add(loveButton);
		
		JButton personalityButton = new JButton("personality");
		personalityButton.setBounds(854, 404, 120, 120);
		personalityButton.setEnabled(false);
		horoscopePanel.add(personalityButton);
		
		JLabel ysiLabel = new JLabel("Your sign is:");
		ysiLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ysiLabel.setBounds(778, 136, 100, 25);
		horoscopePanel.add(ysiLabel);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(900, 25, 100, 100);
		horoscopePanel.add(imageLabel);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		calculateButton.setBounds(590, 135, 110, 30);
		horoscopePanel.add(calculateButton);
		
		JLabel signLabel = new JLabel("");
		signLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		signLabel.setBounds(900, 136, 100, 25);
		horoscopePanel.add(signLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(270, 224, 534, 300);
		horoscopePanel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		horoscopePanel.setVisible(false);
		
		menuPanel = new MenuPanel();
		frame.getContentPane().add(menuPanel);
		menuPanel.setVisible(true);
		
		
//		#######################  Menu Panel Buttons  #######################
		
		horoscopeButton = new JButton("Horoscope");
		horoscopeButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		horoscopeButton.setBounds(BUTTON_X, 184, BUTTON_WIDTH, BUTTON_HEIGHT);
		horoscopeButton.addActionListener(handler);
		menuPanel.add(horoscopeButton);
		
		compatibilityButton = new JButton("Compatibility");
		compatibilityButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		compatibilityButton.setBounds(BUTTON_X, 269, BUTTON_WIDTH, BUTTON_HEIGHT);
		compatibilityButton.addActionListener(handler);
		menuPanel.add(compatibilityButton);
		
		helpButton = new JButton("Help");
		helpButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		helpButton.setBounds(BUTTON_X, 354, BUTTON_WIDTH, BUTTON_HEIGHT);
		helpButton.addActionListener(handler);
		menuPanel.add(helpButton);
		
		quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		quitButton.setBounds(BUTTON_X, 439, BUTTON_WIDTH, BUTTON_HEIGHT);
		quitButton.addActionListener(handler);
		menuPanel.add(quitButton);
		
		
//		#######################  Help Panel Buttons #######################
		
		helpBackButton = new JButton("Back");
		helpBackButton.setFont(new Font("Times New Roman", Font.BOLD, 45));
		helpBackButton.setBounds((int)((Panel.PANEL_WIDTH - 200)/2), 480, 200, 50);
		helpBackButton.addActionListener(handler);
		helpPanel.add(helpBackButton);

		
//		#######################  Horoscope Panel Button  #######################
		
		horoBackButton = new JButton("Back");
		horoBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		horoBackButton.setBounds(984, 549, 90, 25);
		horoBackButton.addActionListener(handler);
		horoscopePanel.add(horoBackButton);
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == horoscopeButton){
				horoscopePanel.setVisible(true);
				menuPanel.setVisible(false);
			}
			if(e.getSource() == compatibilityButton){
				compatibilityPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
			if(e.getSource() == helpButton){
				helpPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
			if(e.getSource() == quitButton){
				System.exit(0);
			}
			if(e.getSource() == helpBackButton){
				menuPanel.setVisible(true);
				helpPanel.setVisible(false);
			}
			if(e.getSource() == compBackButton){
				menuPanel.setVisible(true);
				compatibilityPanel.setVisible(false);
			}
			if(e.getSource() == horoBackButton){
				menuPanel.setVisible(true);
				horoscopePanel.setVisible(false);
			}
			if(e.getSource() == btnNewButton){
				new Thread(new Runnable(){
					@Override
					public void run() {
						int x = 0;
						while(x <= 100){
							x++;
							progressBar.setValue(x);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					
				}).start();;
		    }
		}
	}
}
