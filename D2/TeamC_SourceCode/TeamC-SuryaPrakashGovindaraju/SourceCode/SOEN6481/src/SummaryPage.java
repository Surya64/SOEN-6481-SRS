
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SummaryPage {

	JFrame frame;
	String selectedFare;
	JTextArea textArea;

	/**
	 * Create the application.
	 */
	public SummaryPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 504, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSummaryOfPurchase = new JLabel("Summary of Purchase");
		lblSummaryOfPurchase.setFont(new Font("Cambria", Font.BOLD, 24));
		lblSummaryOfPurchase.setBounds(124, 25, 266, 32);
		frame.getContentPane().add(lblSummaryOfPurchase);

		JLabel lblPleaseVerifyAnd = new JLabel("Please Verify and Proceed to Payment");
		lblPleaseVerifyAnd.setBounds(36, 110, 231, 14);
		frame.getContentPane().add(lblPleaseVerifyAnd);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(36, 135, 320, 87);
		frame.getContentPane().add(textArea);

		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransitPurchase transitPurchase = new TransitPurchase();
				frame.setVisible(false);
				transitPurchase.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(368, 84, 71, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
