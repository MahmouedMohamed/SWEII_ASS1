import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class omdbgui1 extends JFrame {

	private JPanel contentPane;
	static omdb obj=new omdb();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					omdbgui1 frame = new omdbgui1(obj);
					frame.setSize(1000,1000);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void get(omdb obj)
	{			 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setLayout(new BorderLayout());

	    JPanel panel = new JPanel();
	    panel.setSize(500, 500);
	    panel.setBackground(new Color(0,0,0,64));

	    Image image = null;
	    URL url = null;
	    try {
	    	String x=obj.getposter().substring(1, obj.getposter().length()-1);
	        url = new URL(x);
	        image = ImageIO.read(url);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL");
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
	    panel.setLayout(null);
	    panel.setBackground(new Color(0,0,0,64));

	    JLabel label = new JLabel(new ImageIcon(image));
	    label.setBounds(0, 0, 227, 199);
	    panel.add(label);
	    this.getContentPane().add(panel, BorderLayout.CENTER);
	    JLabel lblNewLabel_1 = new JLabel("Title: " +obj.gettitle());
	    lblNewLabel_1.setBounds(249, 5, 381, 41);
	    panel.add(lblNewLabel_1);
	    
	    JLabel label_1 = new JLabel("Year: "+obj.getyear());
	    label_1.setBounds(249, 57, 381, 41);
	    panel.add(label_1);
	    
	    JLabel label_2 = new JLabel("Rate: "+obj.getrated());
	    label_2.setBounds(249, 90, 381, 41);
	    panel.add(label_2);
	    
	    JLabel label_3 = new JLabel("Release Date: "+obj.getrelease());
	    label_3.setBounds(249, 130, 381, 41);
	    panel.add(label_3);
	    
	    JLabel label_4 = new JLabel("Runtime: "+obj.getruntime());
	    label_4.setBounds(249, 171, 381, 41);
	    panel.add(label_4);
	    
	    JLabel label_9 = new JLabel("Genre: "+obj.getgenre());
	    label_9.setBounds(249, 372, 381, 41);
	    panel.add(label_9);
	    
	    JLabel label_10 = new JLabel("Director: "+obj.getdirector());
	    label_10.setBounds(249, 291, 381, 41);
	    panel.add(label_10);
	    
	    JLabel label_11 = new JLabel("Writer: "+obj.getwriter());
	    label_11.setBounds(249, 251, 381, 41);
	    panel.add(label_11);
	    
	    JLabel label_12 = new JLabel("Actors: "+obj.getactors());
	    label_12.setBounds(249, 212, 381, 41);
	    panel.add(label_12);
	    
	    JLabel label_5 = new JLabel("Plot: "+obj.getplot());
	    label_5.setBounds(249, 494, 381, 41);
	    panel.add(label_5);
	    
	    JLabel label_6 = new JLabel("Language: "+obj.getlanguage());
	    label_6.setBounds(249, 454, 381, 41);
	    panel.add(label_6);
	    
	    JLabel label_7 = new JLabel("Country: "+obj.getcountry());
	    label_7.setBounds(249, 413, 381, 41);
	    panel.add(label_7);
	    
	    JLabel label_8 = new JLabel("Awards: "+obj.getaward());
	    label_8.setBounds(249, 333, 381, 41);
	    panel.add(label_8);
	    this.setVisible(true);

	}
	/**
	 * Create the frame.
	 */
	public omdbgui1(omdb obj) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		get(obj);
	}

}
