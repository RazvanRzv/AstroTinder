package main;

// Add birthday year chooser
// Add Capricorn Profession
// Add background photos
// Add license
// Add help
// Change diacritics in compatibility folder
// Change titles colors
// Bug: calculate button from compatibility panel pressed many times

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Panels.CompatibilityPanel;
import Panels.HelpPanel;
import Panels.HoroscopePanel;
import Panels.MenuPanel;
import Panels.Panel;

public class AstroTinder {

	private JFrame			frame;
	public static final int	WIDTH			= 1080;
	public static final int	HEIGHT			= WIDTH / 16 * 9;
	public static final int	BUTTON_WIDTH	= 400;
	public static final int	BUTTON_HEIGHT	= 55;
	public static final int	BUTTON_X		= (int) ((Panel.PANEL_WIDTH
			- BUTTON_WIDTH) / 2);

	private Handler handler;

	// ######### Panels #########

	private HoroscopePanel		horoscopePanel;
	private MenuPanel			menuPanel;
	private HelpPanel			helpPanel;
	private CompatibilityPanel	compatibilityPanel;

	// ######### Buttons #########

	private JButton	horoscopeButton;
	private JButton	compatibilityButton;
	private JButton	helpButton;
	private JButton	quitButton;

	private JButton	helpBackButton;
	private JButton	compBackButton;
	private JButton	horoBackButton;

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

		menuPanel = new MenuPanel();
		frame.getContentPane().add(menuPanel);
		menuPanel.setVisible(true);

		horoscopePanel = new HoroscopePanel();
		frame.getContentPane().add(horoscopePanel);
		horoscopePanel.setVisible(false);

		compatibilityPanel = new CompatibilityPanel();
		frame.getContentPane().add(compatibilityPanel);
		compatibilityPanel.setVisible(false);

		helpPanel = new HelpPanel();
		frame.getContentPane().add(helpPanel);
		helpPanel.setVisible(false);

		// ####################### Menu Panel Buttons #######################

		horoscopeButton = new JButton("Horoscope");
		horoscopeButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		horoscopeButton.setBounds(BUTTON_X, 184, BUTTON_WIDTH, BUTTON_HEIGHT);
		horoscopeButton.addActionListener(handler);
		menuPanel.add(horoscopeButton);

		compatibilityButton = new JButton("Compatibility");
		compatibilityButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		compatibilityButton.setBounds(BUTTON_X, 269, BUTTON_WIDTH,
				BUTTON_HEIGHT);
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

		// #################### Horoscope Panel Button ####################

		horoBackButton = new JButton("Back");
		horoBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		horoBackButton.setBounds(984, 549, 90, 25);
		horoBackButton.addActionListener(handler);
		horoscopePanel.add(horoBackButton);

		// ################### Compatibility Panel Button ###################

		compBackButton = new JButton("Back");
		compBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		compBackButton.setBounds(984, 549, 90, 25);
		compBackButton.addActionListener(handler);
		compatibilityPanel.add(compBackButton);

		// ####################### Help Panel Buttons #######################

		helpBackButton = new JButton("Back");
		helpBackButton.setFont(new Font("Times New Roman", Font.BOLD, 45));
		helpBackButton.setBounds((int) ((Panel.PANEL_WIDTH - 200) / 2), 480,
				200, 50);
		helpBackButton.addActionListener(handler);
		helpPanel.add(helpBackButton);

		menuPanel.setBackground("/Backgrounds/MenuBackground.png");
		horoscopePanel.setBackground("/Backgrounds/HoroscopeBackground.png");
		compatibilityPanel
				.setBackground("/Backgrounds/CompatibilityBackground.png");
		helpPanel.setBackground("/Backgrounds/HelpBackground.png");
	}

	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == horoscopeButton) {
				horoscopePanel.setVisible(true);
				menuPanel.setVisible(false);
			}
			if (e.getSource() == compatibilityButton) {
				compatibilityPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
			if (e.getSource() == helpButton) {
				helpPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
			if (e.getSource() == quitButton) {
				System.exit(0);
			}
			if (e.getSource() == helpBackButton) {
				menuPanel.setVisible(true);
				helpPanel.setVisible(false);
			}
			if (e.getSource() == compBackButton) {
				menuPanel.setVisible(true);
				compatibilityPanel.setVisible(false);
			}
			if (e.getSource() == horoBackButton) {
				menuPanel.setVisible(true);
				horoscopePanel.setVisible(false);
			}
		}
	}
}
