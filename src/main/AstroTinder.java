package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import Panels.CompatibilityPanel;
import Panels.HelpPanel;
import Panels.HoroscopePanel;
import Panels.MenuPanel;
import Panels.Panel;
import javax.swing.JComboBox;

public class AstroTinder {

	private JFrame frame;
	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int BUTTON_WIDTH = 400;
	public static final int BUTTON_HEIGHT = 55;
	public static final int BUTTON_X = (int)(Panel.PANEL_WIDTH - BUTTON_WIDTH)/2;
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public AstroTinder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		final MenuPanel menuPanel = new MenuPanel();
		frame.getContentPane().add(menuPanel);
		menuPanel.setVisible(true);
		
		final HelpPanel helpPanel = new HelpPanel();
		frame.getContentPane().add(helpPanel);
		helpPanel.setVisible(false);
		
		final CompatibilityPanel compatibilityPanel = new CompatibilityPanel();
		frame.getContentPane().add(compatibilityPanel);
		compatibilityPanel.setVisible(false);
		
		final HoroscopePanel horoscopePanel = new HoroscopePanel();
		frame.getContentPane().add(horoscopePanel);		
		horoscopePanel.setVisible(false);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(130, 215, 89, 23);
		helpPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(81, 325, 89, 23);
		helpPanel.add(btnNewButton_1);
		helpPanel.setVisible(true);
		
		
//		#######################  Menu Panel Buttons  #######################
		
		JButton horoscopeButton = new JButton("Horoscope");
		horoscopeButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		horoscopeButton.setBounds(BUTTON_X, 184, BUTTON_WIDTH, BUTTON_HEIGHT);
		horoscopeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				horoscopePanel.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		menuPanel.add(horoscopeButton);
		
		JButton compatibilityButton = new JButton("Compatibility");
		compatibilityButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		compatibilityButton.setBounds(BUTTON_X, 269, BUTTON_WIDTH, BUTTON_HEIGHT);
		compatibilityButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				compatibilityPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		menuPanel.add(compatibilityButton);
		
		JButton helpButton = new JButton("Help");
		helpButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		helpButton.setBounds(BUTTON_X, 354, BUTTON_WIDTH, BUTTON_HEIGHT);
		helpButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				helpPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		menuPanel.add(helpButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		quitButton.setBounds(BUTTON_X, 439, BUTTON_WIDTH, BUTTON_HEIGHT);
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		menuPanel.add(quitButton);

		
		
	}
}
