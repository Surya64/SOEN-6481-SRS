
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class FareQuantity {

	JFrame frame;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	JRadioButton rdbtnNewRadioButton_3;
	JRadioButton rdbtnNewRadioButton_4;
	private JButton btnPreviousPage;
	String selectedFare;
	String quantity = "";
	String quantityPrice = "";

	/**
	 * Create the application.
	 */
	public FareQuantity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 484, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSelectFareQuantity = new JLabel("Select Fare Quantity");
		lblSelectFareQuantity.setFont(new Font("Cambria", Font.BOLD, 13));
		lblSelectFareQuantity.setBounds(21, 29, 143, 14);
		frame.getContentPane().add(lblSelectFareQuantity);

		rdbtnNewRadioButton = new JRadioButton("1 Fare - $Dynamic");
		rdbtnNewRadioButton.setBounds(43, 70, 133, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("2 Fare - $Dynamic");
		rdbtnNewRadioButton_1.setBounds(43, 104, 133, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("3 Fare - $Dynamic");
		rdbtnNewRadioButton_2.setBounds(43, 141, 133, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("4 Fare - $Dynamic");
		rdbtnNewRadioButton_3.setBounds(215, 70, 133, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);

		rdbtnNewRadioButton_4 = new JRadioButton("5 Fare - $Dynamic");
		rdbtnNewRadioButton_4.setBounds(215, 104, 133, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_3);
		buttonGroup.add(rdbtnNewRadioButton_4);

		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean noSelection = true;
				String temp[] = null;
				if (rdbtnNewRadioButton.isSelected()) {
					temp = rdbtnNewRadioButton.getText().split("\\$");
					quantity = "1";
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					quantity = "2";
					temp = rdbtnNewRadioButton_1.getText().split("\\$");
				} else if (rdbtnNewRadioButton_2.isSelected()) {
					temp = rdbtnNewRadioButton_2.getText().split("\\$");
					quantity = "3";
				} else if (rdbtnNewRadioButton_3.isSelected()) {
					temp = rdbtnNewRadioButton_3.getText().split("\\$");
					quantity = "4";
				} else if (rdbtnNewRadioButton_4.isSelected()) {
					temp = rdbtnNewRadioButton_4.getText().split("\\$");
					quantity = "5";
				} else {
					noSelection = false;
				}
				if (noSelection) {
					System.out.println(quantity);
					quantityPrice = temp[1];
					String output = "Fare Type : " + selectedFare
							+ "\nQuantity : " + quantity + "\nTotal Price : $" + quantityPrice;

					SummaryPage summaryPage = new SummaryPage();
					frame.setVisible(false);

					summaryPage.textArea.setText(output);
					summaryPage.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Please select the option to proceed..");
				}
			}
		});
		btnNextPage.setBounds(306, 210, 109, 23);
		frame.getContentPane().add(btnNextPage);

		btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransitPurchase transitPurchase = new TransitPurchase();
				frame.setVisible(false);
				transitPurchase.frame.setVisible(true);
			}
		});
		btnPreviousPage.setBounds(43, 210, 133, 23);
		frame.getContentPane().add(btnPreviousPage);
	}

}
