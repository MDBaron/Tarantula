package crawler;

public class Driver {


	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			    public void run() {
				//DatabasePlug plug = new DatabasePlug();
				//plug.establishConnection();
			    UserInterface.createAndShowGUI();
			}//run
			}); // while
		
		
	}//Main
	
}
