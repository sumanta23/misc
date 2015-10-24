package org.sumanta.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainGUI {
	
	private JPanel jpnl1=new JPanel();
	
	
	private JTextArea tarea=new JTextArea("", 20, 30);
	
	private JMenuBar mb=new JMenuBar();
	private JMenu file=new JMenu("File");
	private JMenu edit=new JMenu("Edit");
	private JMenuItem save=new JMenuItem("Save");
	private JMenuItem exit=new JMenuItem("Exit");
	private JMenuItem cut=new JMenuItem("Cut");
	private JMenuItem copy=new JMenuItem("Copy");
	private JMenuItem paste=new JMenuItem("Paste");
	private JScrollPane jScrollPane1;
	 
	public MainGUI()
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
	        JFrame frm=new JFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(400, 300);
		frm.setVisible(true);
		frm.setLocation(100, 100);
		frm.setLayout(new BorderLayout());
		
		
		Cursor c=new Cursor(2);
		tarea.setCursor(c);
		tarea.setLineWrap(true);
		tarea.setWrapStyleWord(true);
		jpnl1.add(tarea);
		
		file.add(save);
		file.add(exit);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		mb.add(file);
		mb.add(edit);
		
		mb.setBounds(0,0,10,20);
		//jScrollPane1 = new JScrollPane(tarea);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String myString = tarea.getText();
				StringSelection stringSelection = new StringSelection (myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
		});
		paste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				Transferable contents = clpbrd.getContents(null);
				try {
					tarea.setText((String)contents.getTransferData(DataFlavor.stringFlavor));
				} catch (UnsupportedFlavorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		frm.add(mb,BorderLayout.BEFORE_FIRST_LINE);
		frm.add(jpnl1,BorderLayout.CENTER);
	}
	
	public static void main(String s[])
	{
		MainGUI m=new MainGUI();
	}

}
