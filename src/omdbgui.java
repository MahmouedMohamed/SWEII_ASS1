import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class omdbgui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	omdb obj=new omdb();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					omdbgui frame = new omdbgui();
					frame.setSize(250,250);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/*public void getimage()
	{			 
		JPanel panel = new JPanel();

	    Image image = null;
	    URL url = null;
	    try {
	        url = new URL("https://m.media-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg");
	        image = ImageIO.read(url);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL");
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
	    panel.setLayout(null);
	    JLabel label = new JLabel(new ImageIcon(image));
	    label.setBounds(0, 0, 300, 445);
	    panel.add(label);

	    this.getContentPane().add(panel, BorderLayout.CENTER);
	    this.pack();

	}*/
	public omdbgui() {
		setType(Type.UTILITY);
		setTitle("omdb API");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
	    
	    textField = new JTextField();
	    textField.setBounds(64, 24, 147, 23);
	    getContentPane().add(textField);
	    textField.setColumns(10);
	    
	    JButton btnNewButton = new JButton("Search");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				if(obj.getconnection(name)<0)
				{
					JOptionPane.showMessageDialog(null,"bad Request");
				}
				else
				{
					omdbgui1 In=new omdbgui1(obj);
					In.setVisible(true);
				}
	    	}
	    });
	    btnNewButton.setBounds(69, 95, 89, 23);
	    getContentPane().add(btnNewButton);
	    
	    JLabel lblName = new JLabel("Name");
	    lblName.setBounds(10, 28, 46, 14);
	    getContentPane().add(lblName);
	    
	}
}
