import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DeleteErrorException;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class dropboxgui extends JFrame {

	private JPanel contentPane;
	private static final String ACCESS_TOKEN = "KFVPE20FCzAAAAAAAAAAEmcZiPe2gbeWrvZi2t59WCMFZPfdhiabH5af0SA1s13N";
	private JTextField textField;
	
	/**
	 * Launch the application.
	 * @throws DbxException 
	 * @throws DbxApiException 
	 */
	public static void main(String[] args) throws DbxApiException, DbxException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dropboxgui frame = new dropboxgui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws DbxException 
	 * @throws DbxApiException 
	 */
	public dropboxgui() throws DbxApiException, DbxException {
		DbxRequestConfig config = DbxRequestConfig.newBuilder("").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        FullAccount account = client.users().getCurrentAccount();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ListFolderResult result = client.files().listFolder("");
		Vector list=new Vector();
		while (true) {
            for (Metadata metadata : result.getEntries()) {
            	list.add(metadata.getPathLower());
            }
            	

            if (!result.getHasMore()) {
                break;
            }

            
        }
		JList textArea = new JList(list);
    	//textArea.append("\n");
    	textArea.setBounds(203, 11, 221, 209);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Choose a directory to save your file: ");
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (jfc.getSelectedFile().isFile()) {
						int io=0;
						String path=jfc.getSelectedFile().toString();
						try (InputStream in = new FileInputStream(jfc.getSelectedFile())) {
							for(int i=0;i<path.length();i++)
							{
								if(path.charAt(i)=='\\')
								{
									io=i;
								}
							}
							String sub=path.substring(io);
				           FileMetadata metadata = client.files().upload("/"+sub.substring(1))
				        		  
				                .uploadAndFinish(in);
				        } catch (DbxException |IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setBounds(33, 27, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i= textArea.getSelectedIndex();
				String s= (String) list.elementAt(i);
				try {if(s!=null)
				{FileMetadata meta=(FileMetadata) client.files().delete(s);
				//FileMetadata meta1=client.files().propertiesUpdate(s,other);
				}} catch (DeleteErrorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DbxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(33, 93, 89, 23);
		contentPane.add(btnDelete);
		
		
        
		}
	}

