import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainFrame extends JFrame {
	
	 private JPanel contentPane;
	 private JButton button1;
	 private JLabel label;
	 
	 public MainFrame()  {
	    	
	        super("9 Mens Morris");
	        setSize(new Dimension(600, 500));
	        setLocationRelativeTo(null);
	        screenContents();

	        setVisible(true);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }
	 
	 
	 
	 private void screenContents(){
		Container MyContentFrame = getContentPane();
		JLabel title = new JLabel("Nine Mens Morris",SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.NORTH);
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		MyContentFrame.add(title);
		 
	 }
	 
	 
		public static void main(String[]args) throws FileNotFoundException{
			

			//new JTableUsage().start();
			new MainFrame();
	}
}
