import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BilingualOptionsList {

	String languageOfChoice = "English";
	JFrame frame;
	JRadioButton singleFare;
	JRadioButton roundtripFare;
	JRadioButton singleDayFare;
	JRadioButton weeklyFare;
	JRadioButton monthlyFare;

	/**
	 * Create the application to show all the fare options.
	 */
	public BilingualOptionsList(String lang) {
		this.languageOfChoice = lang;
		initialize();
	}

	/**
	 * Initialize the contents of the frame based on what 
	 * language has actually been selected.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.PINK);
		frame.setBounds(100, 100, 504, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// The default language of the TVM is English 
		// so initialize and populate text as such
		JLabel listOfAllOptions = new JLabel();
		String headerSentence = "All Options Available";
		String singleFareStr = "Single Pass";
		String roundtripFareStr = "Roundtrip Pass";
		String fullDayPassStr = "Full Day Pass";
		String weeklyPassStr = "Weekly Pass";
		String monthlyPassStr = "Monthly Pass";
		String backButtonStr = "Back";
		
		// if language is French, manually translate the options 
		// as required
		// *NOTE: this level of hardcoding is acceptable as these options
		// do not so often change (i.e compromising on the dynamic configuration of it is acceptable) 
		if(languageOfChoice.equals("Francais")) {
			headerSentence = "Toutes Les Options";
			singleFareStr = "Passe Unique";
			roundtripFareStr = "Passe Aller-Retour";
			fullDayPassStr = "Journée Entière";
			weeklyPassStr = "Hebdomadaire";
			monthlyPassStr = "Passe Mensuelle";
			backButtonStr = "Retour";
		}
		
		singleFare = new JRadioButton(singleFareStr);
		singleFare.setBounds(43, 70, 133, 23);
		frame.getContentPane().add(singleFare);

		roundtripFare = new JRadioButton(roundtripFareStr);
		roundtripFare.setBounds(43, 104, 133, 23);
		frame.getContentPane().add(roundtripFare);

		singleDayFare = new JRadioButton(fullDayPassStr);
		singleDayFare.setBounds(43, 141, 133, 23);
		frame.getContentPane().add(singleDayFare);

		weeklyFare = new JRadioButton(weeklyPassStr);
		weeklyFare.setBounds(215, 70, 133, 23);
		frame.getContentPane().add(weeklyFare);

		monthlyFare = new JRadioButton(monthlyPassStr);
		monthlyFare.setBounds(215, 104, 133, 23);
		frame.getContentPane().add(monthlyFare);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(singleFare);
		buttonGroup.add(roundtripFare);
		buttonGroup.add(singleDayFare);
		buttonGroup.add(weeklyFare);
		buttonGroup.add(monthlyFare);
		
		listOfAllOptions = new JLabel(headerSentence);
		listOfAllOptions.setFont(new Font("Calibri", Font.BOLD, 24));
		listOfAllOptions.setBounds(124, 25, 266, 32);
		frame.getContentPane().add(listOfAllOptions);

		JButton backButton = new JButton(backButtonStr);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListOptions transitPurchase = new ListOptions();
				frame.setVisible(false);
				transitPurchase.frame.setVisible(true);
			}
		});
		backButton.setBounds(372, 88, 81, 27);
		frame.getContentPane().add(backButton);
	}
}
