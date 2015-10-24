package org.sumanta.gui.panel;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;

import org.sumanta.gui.TabbedPane;
import org.sumanta.util.IOUtils;
import org.sumanta.util.ssh.SshApi;

public class TerminalPanel extends Panel {

	
	JTextArea ta=new JTextArea();
	JTextField jl=new JTextField(20);
	public TerminalPanel(final SshApi ssh) {
		// TODO Auto-generated constructor stub
		ta.setFont(new Font("Terminal", Font.BOLD, 12));
		ta.setForeground(Color.BLACK);
		this.setLayout(null);
        	ta.setEnabled(true);
        	ta.setEditable(false);
        	JScrollPane scroll = new JScrollPane (ta);
    		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        	//ta.setCaretPosition(ta.getDocument().getLength());
    		scroll.setBounds(0,0,TabbedPane.tabbedPane.getSelectedComponent().getWidth(),TabbedPane.tabbedPane.getSelectedComponent().getHeight()-20);
    		ta.setSize(400, 300);
    		this.add(scroll);
    		//ta.setText("jk");
    		jl.setBounds(0,TabbedPane.tabbedPane.getSelectedComponent().getHeight()-20,
    				TabbedPane.tabbedPane.getSelectedComponent().getWidth(),
    				20);
    		this.add(jl);
    		jl.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						InputStream is=ssh.Execute(jl.getText());
						byte buffer[] = new byte[100000];
				        int read;
				        String myString = IOUtils.fromStream(is);
						while ((read = is.read(buffer)) > 0) {
							
					         System.out.write(buffer, 0, read);
					     }
						ta.setText(myString);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
    		
	}
}
