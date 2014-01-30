package org.sumanta.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.sumanta.gui.TabbedPane;
import org.sumanta.util.ssh.SshApi;

public class LoginPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6094741054553834833L;
	
	private JLabel nameLabel=new JLabel("Enter Tab name");
	private JTextField tabName=new JTextField(20);
	private JLabel urlLabel=new JLabel("Enter URL");
	private JTextField url=new JTextField(20);
	private JLabel userNameLabel=new JLabel("Enter UserName");
	private JTextField userName=new JTextField(20);
	private JLabel passwordLabel=new JLabel("Enter Password");
	private JPasswordField passWord=new JPasswordField();
	private JButton submit=new JButton("Connect");
	
	
	
	public  LoginPanel() {
		this.setLayout(null);
		nameLabel.setBounds(5, 5, 100, 20);
		tabName.setBounds(120, 5, 200, 20);
		urlLabel.setBounds(5, 40, 100, 20);
		url.setBounds(120, 40, 200, 20);
		userNameLabel.setBounds(5, 75, 100,20);
		userName.setBounds(120, 75, 200, 20);
		passwordLabel.setBounds(5, 110, 100, 20);
		passWord.setBounds(120, 110, 200, 20);
		submit.setBounds(70, 145, 200, 20);
		this.add(nameLabel);
		this.add(tabName);
		this.add(urlLabel);
		this.add(url);
		this.add(userNameLabel);
		this.add(userName);
		this.add(passwordLabel);
		this.add(passWord);
		this.add(submit);
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SshApi ssh=new SshApi();
				try {
					ssh.connect(url.getText(), userName.getText(), passWord.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				TerminalPanel tp=new TerminalPanel(ssh);
				int in=TabbedPane.tabbedPane.getSelectedIndex();
				TabbedPane.tabbedPane.setComponentAt(in, tp);
				
			}
		});
	}
	
}
