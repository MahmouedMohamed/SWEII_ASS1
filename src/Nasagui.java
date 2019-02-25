import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window.Type;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.media.VideoTrack;

public class Nasagui extends JFrame {

	private JPanel contentPane;
	public static Nasa obj=new Nasa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nasagui frame = new Nasagui(obj);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void get(Nasa obj)
	{			 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setLayout(new BorderLayout());

	    JPanel panel = new JPanel();
	    panel.setSize(500, 500);
	    panel.setBackground(new Color(0,0,0,64));

	    Image image = null;
	    URL url = null;
	    try {
	    	String x=obj.gethdurl().substring(1, obj.gethdurl().length()-1);
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
	    label.setBounds(0, 0, 572, 563);
	    panel.add(label);
	    this.getContentPane().add(panel, BorderLayout.CENTER);
	    JLabel lblNewLabel_1 = new JLabel("copyright: "+obj.getcopyright());
	    lblNewLabel_1.setBounds(582, 0, 381, 41);
	    panel.add(lblNewLabel_1);
	    
	    JLabel lblDate = new JLabel("date: "+obj.getdate());
	    lblDate.setBounds(582, 39, 381, 41);
	    panel.add(lblDate);
	    
	    JLabel lblExplanation = new JLabel("explanation: "+obj.getexplanation());
	    lblExplanation.setBounds(0, 575, 998, 164);
	    panel.add(lblExplanation);
	    
	   
	}
	/**
	 * Create the frame.
	 */
	public Nasagui(Nasa obj) {
		setType(Type.UTILITY);
		setTitle("Nasa API");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		get(obj);
	}

}
