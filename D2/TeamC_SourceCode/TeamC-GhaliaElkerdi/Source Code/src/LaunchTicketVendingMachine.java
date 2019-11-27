import java.awt.EventQueue;

public class LaunchTicketVendingMachine {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListOptions listOptions = new ListOptions();
					listOptions.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
