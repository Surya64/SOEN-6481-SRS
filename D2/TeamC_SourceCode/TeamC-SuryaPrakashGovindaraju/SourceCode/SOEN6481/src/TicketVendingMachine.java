import java.awt.EventQueue;

public class TicketVendingMachine {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransitPurchase transitPurchase = new TransitPurchase();
					transitPurchase.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
