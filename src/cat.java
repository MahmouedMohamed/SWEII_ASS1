import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextArea;

public class cat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cat frame = new cat();
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
	public cat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		Client client = ClientBuilder.newClient();
		WebTarget target =client.target("https://www.poemist.com/api/v1/randompoems");
		String all=(target.request(MediaType.APPLICATION_JSON).get(String.class));
		String[] arrOfStr =all.split(",\"");
		String title=arrOfStr[0].substring(10);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setBounds(10, 0, 414, 23);
		contentPane.add(lblNewLabel);
		
		
		String content=arrOfStr[1].substring(10);
		String arr[]=content.split(",\n");
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		for (int s = 0; s < arr.length; s++)
		{
		    textArea.append(arr[s]);
		}
		textArea.setBounds(10, 34, 414, 387);
		contentPane.add(textArea);
		//System.out.print(all);
	}
}
