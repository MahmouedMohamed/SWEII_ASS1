import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OMDB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				omdbgui In=new omdbgui();
				In.setVisible(true);
			}
		});
		btnNewButton.setBounds(163, 47, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nasa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Nasa obj=new Nasa();
				Nasagui In=new Nasagui(obj);
				In.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(163, 119, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnPoems = new JButton("Poems");
		btnPoems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cat In=new cat();
				In.setVisible(true);
			}
		});
		btnPoems.setBounds(163, 191, 89, 23);
		contentPane.add(btnPoems);
	}

}
