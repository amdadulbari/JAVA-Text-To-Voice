package me.amdadulbari.com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.sound.midi.VoiceStatus;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UIView {

	private JFrame frame;
	private JTextField textField;
	private JButton btnFilechooser;

	/**
	 * Launch the application.
	 */
	
	//contact: me@amdadulbari.com
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (Exception e) {
			// TODO: handle exception
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIView window = new UIView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Text To Speech");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		lblNewLabel.setBounds(347, 0, 291, 121);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(45, 135, 657, 527);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Speak");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voice voice;
				VoiceManager voiceManager = VoiceManager.getInstance();
				voice = voiceManager.getVoice("kevin");
				voice.allocate();
				voice.speak(textField.getText());
				
			}
		});
		btnNewButton.setBounds(745, 323, 101, 89);
		frame.getContentPane().add(btnNewButton);
		
		btnFilechooser = new JButton("FileChooser");
		btnFilechooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton open = new JButton();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("C:\\Users\\Super\\Desktop"));
				if(fileChooser.showOpenDialog(open)==JFileChooser.APPROVE_OPTION){
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					String path = fileChooser.getSelectedFile().getPath();
					Filex filex = new Filex();
					try {
						filex.fileReaderFunc(path);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						
					}
				}
				
				
			}
		});
		btnFilechooser.setBounds(745, 135, 101, 89);
		frame.getContentPane().add(btnFilechooser);
		
		JLabel lblamdadulbaricom = new JLabel("@amdadulbari.com");
		lblamdadulbaricom.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblamdadulbaricom.setBounds(426, 674, 252, 32);
		frame.getContentPane().add(lblamdadulbaricom);
	}
}
