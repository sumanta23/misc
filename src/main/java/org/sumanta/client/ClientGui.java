package org.sumanta.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.sumanta.common.WebPing;

public class ClientGui {

	/**
	 * @param args
	 */
	
	
	JFrame frame = new JFrame("Chat Client");
	JPanel panel = new JPanel();
	JLabel servername=new JLabel("Enter Server Address");
	JLabel clientname=new JLabel("Chat Client Address");
	JTextField serverAddress=new JTextField();
	JTextField chatClient=new JTextField();
	JButton connect=new JButton("Connect");
	static JTextArea chatHistory=new JTextArea("");
	JScrollPane scroll;
	JTextField text=new JTextField();
	
	public ClientGui()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
			
		servername.setBounds(10, 10, 160, 30);
		serverAddress.setBounds(170, 10, 165, 30);
		clientname.setBounds(10, 50, 160, 30);
		chatClient.setBounds(170, 50, 165, 30);
		connect.setBounds(140, 90, 100, 25);
		//chatHistory.setBounds(20,125,300,200);
		text.setBounds(20,380,300,30);
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub
				chatHistory.setText(chatHistory.getText()+"\n"
						+getdate()+":me : "+text.getText());
				Client.sendClientRequest(serverAddress.getText(),text.getText());
				text.setText(null);
			}
		});
		text.setEnabled(false);
		chatHistory.setEditable(false);
		chatHistory.setEnabled(false);
		
		chatHistory.setLineWrap(true);
		scroll = new JScrollPane (chatHistory);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	          
	    scroll.setBounds(20,125,300,250);    
	    
	    connect.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==connect)
				{
					if(!(serverAddress.getText().length()==0) && !(chatClient.getText().length()==0))
					{
						
						final boolean res=WebPing.ping(serverAddress.getText(), 25000);
						if(res)
						{
							chatHistory.setText(chatHistory.getText()+"\n"
								+getdate()+": "+"Connetcted to "+serverAddress.getText());
							
							serverAddress.setEnabled(false);
							chatClient.setEnabled(false);
							chatHistory.setEnabled(true);
							text.setEnabled(true);
							connect.setEnabled(false);
							final ClientListener listen=new ClientListener();
							listen.start();
						}
						else
						{
							chatHistory.setText(chatHistory.getText()+"\n"
									+getdate()+": "+"Sorry Could not able to connetct "+serverAddress.getText());
							Client.unBind();
						}
						
						
					}
				}
				
			}
		});
		
		panel.add(servername);
		panel.add(clientname);
		panel.add(serverAddress);
		panel.add(chatClient);
		panel.add(connect);
		panel.add(scroll);
		//panel.add(chatHistory);
		panel.add(text);
	
		frame.add(panel);
		
		frame.setSize(350,450);
		frame.setResizable(false);
		frame.setLocation(500, 250);
		frame.setVisible(true);
		
		
	}
	
	public static String getdate()
	{
		final DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		   final Date date = new Date();
		   return dateFormat.format(date);

	}
	
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		new ClientGui();
	}

}
