
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

public class TransitPurchase {

	JFrame frame;

	/**
	 * Create the application.
	 */
	public TransitPurchase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 528, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWelcomeToIgo = new JLabel("Welcome to IGo");
		lblWelcomeToIgo.setBackground(Color.LIGHT_GRAY);
		lblWelcomeToIgo.setFont(new Font("Cambria", Font.BOLD, 32));
		lblWelcomeToIgo.setBounds(145, 11, 240, 39);
		frame.getContentPane().add(lblWelcomeToIgo);

		JLabel lblTransitFarePurchase = new JLabel("Transit Fare Purchase");
		lblTransitFarePurchase.setFont(new Font("Calibri", Font.BOLD, 16));
		lblTransitFarePurchase.setBounds(22, 61, 189, 14);
		frame.getContentPane().add(lblTransitFarePurchase);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("IGo 2 trips - $6.50");
		rdbtnNewRadioButton.setBounds(59, 121, 133, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("IGo 1 trip - $3.50");
		rdbtnNewRadioButton_1.setBounds(59, 159, 133, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("IGo 3 consec. days - $19.50");
		rdbtnNewRadioButton_2.setBounds(220, 159, 215, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("IGo Unlimited Weekend - $14.00");
		rdbtnNewRadioButton_3.setBounds(220, 121, 215, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("IGo 1 day - $10.00");
		rdbtnNewRadioButton_4.setBounds(59, 198, 133, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);

		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("IGo Unlimited evening - $5.50");
		rdbtnNewRadioButton_5.setBounds(220, 198, 215, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_5);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_3);
		buttonGroup.add(rdbtnNewRadioButton_4);

		JButton btnNewButton = new JButton("Next Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String qual = "";
				boolean noSelection = true;
				if (rdbtnNewRadioButton.isSelected()) {
					qual = "IGo 2 trips - $6.50";
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					qual = "IGo 1 trip - $3.50";
				} else if (rdbtnNewRadioButton_2.isSelected()) {
					qual = "IGo 3 consec. days - $19.50";
				} else if (rdbtnNewRadioButton_3.isSelected()) {
					qual = "IGo Unlimited Weekend - $14.00";
				} else if (rdbtnNewRadioButton_4.isSelected()) {
					qual = "IGo 1 day - $10.00";
				} else if (rdbtnNewRadioButton_5.isSelected()) {
					qual = "IGo Unlimited evening - $5.50";
				} else {
					noSelection = false;
				}
				if (noSelection) {
					System.out.println(qual);
					String[] price = qual.split("\\$");
					FareQuantity fareQuantity = new FareQuantity();
					frame.setVisible(false);
					fareQuantity.selectedFare = qual;
					fareQuantity.rdbtnNewRadioButton.setText("1 Fare - $" + price[1]);
					fareQuantity.rdbtnNewRadioButton_1.setText("2 Fare - $" + Double.parseDouble(price[1]) * 2);
					fareQuantity.rdbtnNewRadioButton_2.setText("3 Fare - $" + Double.parseDouble(price[1]) * 3);
					fareQuantity.rdbtnNewRadioButton_3.setText("4 Fare - $" + Double.parseDouble(price[1]) * 4);
					fareQuantity.rdbtnNewRadioButton_4.setText("5 Fare - $" + Double.parseDouble(price[1]) * 5);
					fareQuantity.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Please select the option to proceed..");
				}

			}
		});

		btnNewButton.setBounds(346, 253, 103, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblPleaseSelectYour = new JLabel("Please select your option to proceed.");
		lblPleaseSelectYour.setFont(new Font("Cambria", Font.PLAIN, 13));
		lblPleaseSelectYour.setBounds(22, 80, 240, 14);
		frame.getContentPane().add(lblPleaseSelectYour);
	}
}
