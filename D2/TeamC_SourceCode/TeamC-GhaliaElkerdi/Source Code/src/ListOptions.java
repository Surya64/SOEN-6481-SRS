import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ListOptions {

	JFrame frame;

	/**
	 * Create the basic application which will basically
	 * render the language options on the screen.
	 */
	public ListOptions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame: IGo supports two languages
	 * English and French.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.PINK);
		frame.setBounds(100, 100, 528, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel welcomeLabel = new JLabel("Welcome to IGo");
		welcomeLabel.setBackground(Color.BLUE);
		welcomeLabel.setFont(new Font("Calibri", Font.BOLD, 32));
		welcomeLabel.setBounds(145, 11, 240, 39);
		frame.getContentPane().add(welcomeLabel);

		JRadioButton englishOption = new JRadioButton("English");
		englishOption.setBounds(59, 121, 133, 23);
		frame.getContentPane().add(englishOption);

		JRadioButton frenchOption = new JRadioButton("Francais");
		frenchOption.setBounds(59, 159, 133, 23);
		frame.getContentPane().add(frenchOption);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(englishOption);
		buttonGroup.add(frenchOption);

		JButton btnNewButton = new JButton("Next Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean noOptSelected = false;
				//default 
				String language = "English";
                if (frenchOption.isSelected()) {
                	language = "Francais";
				} else {
					if (! englishOption.isSelected()) {
						noOptSelected = true ;
					}
				}
				if (! noOptSelected) {
					BilingualOptionsList bilingualOptionsList = new BilingualOptionsList(language);
					//System.out.println("Setting languageOfChoice to: " + language);
					frame.setVisible(false);
					bilingualOptionsList.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Please select a language to proceed..");
				}

			}
		});

		btnNewButton.setBounds(346, 253, 103, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel languageSelection = new JLabel("Please select language");
		languageSelection.setFont(new Font("Calibri", Font.PLAIN, 16));
		languageSelection.setBounds(22, 80, 240, 14);
		frame.getContentPane().add(languageSelection);
	}
}
