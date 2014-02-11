/**
 * 
 */
package crawler;

/**
 * @author Matthew
 *
 */

import java.awt.*;
import java.awt.image.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.text.Style;
import javax.swing.JTabbedPane;

public class UserInterface extends JPanel implements ActionListener, MouseListener, MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JButton quitButton = new JButton("Quit");
	//private JButton toggle = new JButton("Layer");
	
	private JButton Left = new JButton("<");
	private JButton Right = new JButton(">");
	private JButton Home = new JButton("Home");
	
	/*
	private JButton NorthWest = new JButton("1");
	private JButton North = new JButton("2");
	private JButton NorthEast = new JButton("3");
	private JButton West = new JButton("4");
	private JButton East = new JButton("5");
	private JButton SouthWest = new JButton("6");
	private JButton South = new JButton("7");
	private JButton SouthEast = new JButton("8");
	*/
	
	private javax.swing.Timer timer = new javax.swing.Timer(10,this);
	
	int xPos;
	int yPos;
    private int height = 0;
    private int width = 0;
    private String name = "";
    
    private JMenuItem openItem;
    private JMenuItem exitItem;
    
    private JLabel welcome = new JLabel("WELCOME!");
    private JLabel heightSpace = new JLabel(" ");
    private JLabel widthSpace = new JLabel(" ");
    private JLabel coordsXY = new JLabel("X:  Y:  ");
    private JLabel nameStrip = new JLabel("Starter Model");
    
    JMenuBar mbar = new JMenuBar();
	
    
    
	public UserInterface(int x, int y, String s){
		setHeight(y);
		setWidth(x);
		setName(s);
		welcome.setText(s);
		heightSpace.setText(Integer.toString(y));
		widthSpace.setText(Integer.toString(x));
		coordsXY.setText("X: " + Integer.toString(x) + " Y: " + Integer.toString(y));
		nameStrip.setText(s);
		initialize();
	}//GUI constructor
	 public void update(int xPos,int yPos){
		 
		 String upH = "Y: " + Integer.toString(yPos);
		 String upW = "X: " + Integer.toString(xPos);
		 heightSpace.setText(upH);
		 widthSpace.setText(upW);
		 
		 coordsXY.setText("X: " + Integer.toString(xPos) + " Y: " + Integer.toString(yPos));
	 }//update infoz
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
public void splash(){
		
		Frame frame = new Frame("Without Title Bar Frame");
		Label lbl = new Label("Guild Wars 2 Tarantula",Label.CENTER);
		frame.setUndecorated(true);
		frame.add(lbl);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent we){
		Frame frame = (Frame)we.getSource();
		frame.dispose();
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//handle Interrupt
		frame.setVisible(false);
		
		}
		});
		
	}//splash screen
	
	private void initialize(){
		
		//initialize containers
        JPanel contentPaneWest = new JPanel();
        JPanel contentPaneEast = new JPanel();
        JPanel canvas = new JPanel();
        JPanel WestHeader = new JPanel();
        JPanel WestFooter = new JPanel();
        JPanel EastHeader = new JPanel();
        JPanel EastFooter = new JPanel();
        
        //new JTabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("");
        
        
        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Tab 1", icon, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", icon, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", icon, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", icon, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        //Add the tabbed pane to this panel.
        
        
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
       /* Canvas squib = new Canvas(); */
        
        //canvas.setBackground(Color.blue);
       /* squib.setBackground(Color.blue); */
        
        
        //set size of containers
       // contentPaneWest.setPreferredSize(new Dimension(750,1750));
       // contentPaneEast.setPreferredSize(new Dimension(750,1750));
        
        WestHeader.setPreferredSize(new Dimension(560,80));
        WestFooter.setPreferredSize(new Dimension(560,80));
        canvas.setPreferredSize(new Dimension());
        /*squib.setPreferredSize(new Dimension(400,500)); */
        EastHeader.setPreferredSize(new Dimension(1750,875));
        EastFooter.setPreferredSize(new Dimension(1750,875));
        this.setMinimumSize(new Dimension(350,350));
        
        //set button sizes
        
        /*
        NorthWest.setPreferredSize(new Dimension(50,50));
        North.setPreferredSize(new Dimension(50,50));
        NorthEast.setPreferredSize(new Dimension(50,50));
        West.setPreferredSize(new Dimension(50,50));
        East.setPreferredSize(new Dimension(50,50));
        SouthWest.setPreferredSize(new Dimension(50,50));
        South.setPreferredSize(new Dimension(50,50));
        SouthEast.setPreferredSize(new Dimension(50,50));
        */
        
        Font f = new Font(Font.SANS_SERIF, 8, 10);
        
        
        /*
        NorthWest.setFont(f);
        North.setFont(f);
        NorthEast.setFont(f);
        West.setFont(f);
        East.setFont(f);
        SouthWest.setFont(f);
        South.setFont(f);
        SouthEast.setFont(f);
        */
        
        
        this.setMaximumSize(new Dimension(3000,3000));
        
        //set layout for containers
        this.setLayout(new BorderLayout());
        contentPaneWest.setLayout(new BorderLayout());
        contentPaneEast.setLayout(new BorderLayout());
        
        canvas.setLayout(new BorderLayout());
        WestHeader.setLayout(new BorderLayout());
        WestFooter.setLayout(new BorderLayout());
        EastHeader.setLayout(new BorderLayout());
        EastFooter.setLayout(new BorderLayout());

        //add containers to frame
        this.add(contentPaneWest,BorderLayout.WEST);
        this.add(contentPaneEast,BorderLayout.EAST);
        
        contentPaneWest.add(WestHeader,BorderLayout.NORTH);
        contentPaneWest.add(canvas,BorderLayout.CENTER);
        contentPaneWest.add(WestFooter,BorderLayout.SOUTH);
        
        contentPaneEast.add(EastHeader,BorderLayout.NORTH);
        contentPaneEast.add(EastFooter,BorderLayout.SOUTH);
        
        /*
        WestHeader.add(NorthWest,BorderLayout.WEST);
        WestHeader.add(North,BorderLayout.CENTER);
        WestHeader.add(NorthEast,BorderLayout.EAST);
        canvas.add(West,BorderLayout.WEST);
        canvas.add(squib,BorderLayout.CENTER);
        canvas.add(East,BorderLayout.EAST);
        WestFooter.add(SouthWest,BorderLayout.WEST);
        WestFooter.add(South,BorderLayout.CENTER);
        WestFooter.add(SouthEast,BorderLayout.EAST);
        */
        
        
        contentPaneWest.setBorder(BorderFactory.createLineBorder(Color.black));
        contentPaneEast.setBorder(BorderFactory.createLineBorder(Color.black));
        EastHeader.setBorder(BorderFactory.createLineBorder(Color.black));
        EastFooter.setBorder(BorderFactory.createLineBorder(Color.black));
        //initialize text of labels
        welcome.setText("Graph of History");
        heightSpace.setText("Low: ");//TO-DO Add dynamic item low value
        widthSpace.setText("High: ");//TO-DO Add dynamic item high value
        nameStrip.setText("");//TO-DO Add dynamic items tags here

       
        EastFooter.add(tabbedPane);
        /*
        North.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		    
    		} // actionPerformed
    	    }); // actionListener
        
        South.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   
    		} // actionPerformed
    	    }); // actionListener
        
        
        East.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   

    		} // actionPerformed
    	    }); // actionListener
        
        West.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   

    		} // actionPerformed
    	    }); // actionListener
        
        
        NorthWest.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		  

    		} // actionPerformed
    	    }); // actionListener
        
        NorthEast.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    			

    		} // actionPerformed
    	    }); // actionListener
        
        SouthWest.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   

    		} // actionPerformed
    	    }); // actionListener
        
        SouthEast.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   

    		} // actionPerformed
    	    }); // actionListener
        
        */
        
        Home.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   

    		} // actionPerformed
    	    }); // actionListener
        
        Left.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   

    		} // actionPerformed
    	    }); // actionListener
        
        Right.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   

    		} // actionPerformed
    	    }); // actionListener
   /*     
        Slide.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    		   

    		} // actionPerformed
    	    }); // actionListener
            */
	}//initialize
	
	
	
	
	public void addComponent(Container container,
	         Component c, int x, int y, int w, int h)
	 {
	     c.setBounds(x,y,w,h);
	     container.add(c);
	 }
	
	public int getHeight(){
		return height;
	}//getHeight
	
	public void setHeight(int H){
		height = H;
	}//getHeight
	
	public int getWidth(){
		return width;
	}//getWidth
	
	public void setWidth(int W){
		width = W;
	}//setWidth
	
	public String getName(){
		return name;
	}//getName
	
	public void setName(String S){
		name = S;
	}//setName
    
	
	
public static void createAndShowGUI() {
	JFrame gframe = new JFrame("Guild Wars 2 Market Crawler");
	gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	UserInterface proto = new UserInterface(3500,3500,"PsuedoViewer");
	gframe.add(proto);
	proto.splash();
	
	gframe.pack();
	gframe.setVisible(true);
	
	JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
		
}

@Override
public void mouseDragged(MouseEvent e) {
	 timer.start();
	/* JInternalFrame iframe = new JInternalFrame();
     Rectangle r = new Rectangle(iframe.getBounds());
     
     xPos = (int) (r.getX());
     yPos = (int) (r.getY());
     */
	 JInternalFrame iframe = new JInternalFrame();
			 Container c = iframe.getContentPane();
			 Rectangle r = c.getBounds();
			 r = SwingUtilities.convertRectangle(c.getParent(), r, iframe.getParent());
	 update(xPos,yPos);
}
@Override
public void mouseMoved(MouseEvent e) {
	
	
}
@Override
public void mouseClicked(MouseEvent e) {
	
}
@Override
public void mouseEntered(MouseEvent e) {
	
	
}
@Override
public void mouseExited(MouseEvent e) {
	
	
}
@Override
public void mousePressed(MouseEvent e) {
	
	
}
@Override
public void mouseReleased(MouseEvent e) {
	
	
}

protected JComponent makeTextPanel(String text) {
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel(text);
    filler.setHorizontalAlignment(JLabel.CENTER);
    panel.setLayout(new GridLayout(1, 1));
    panel.add(filler);
    return panel;
}

protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = UserInterface.class.getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}
}//GUI Class