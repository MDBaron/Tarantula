package crawler;

public class Driver {


	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			    public void run() {
				
			    UserInterface.createAndShowGUI();
			}//run
			}); // while
		
		
	}//Main
	
}
