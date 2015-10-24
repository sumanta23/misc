package org.sumanta;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class Eye {
	final static TrayIcon trayIcon =
            new TrayIcon(createImage("bulb.gif", "tray icon"));
	final static SystemTray tray = SystemTray.getSystemTray();
	
	static int time=3;
	
    public static void startRun() {
        /* Use an appropriate Look and Feel */
        try {
        	//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event-dispatching thread:
        //adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    
    
    private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        
        
        MenuItem moveitem = new MenuItem("Mouse Move");
        MenuItem timeSheduler=new MenuItem("TimeInterval");
        MenuItem exitItem = new MenuItem("Exit");
        popup.add(timeSheduler);
        popup.add(moveitem);
        popup.add(exitItem);
        trayIcon.setPopupMenu(popup);
        trayIcon.setImageAutoSize(true);
        timeSheduler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int t=Integer.parseInt(JOptionPane.showInputDialog("hi"));
				Eye.time=t;
			}
		});
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        }); 
        
    
        moveitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                try {
							new MoveMouse().move();
						} catch (Exception e) {
							e.printStackTrace();
						}
		            }
		        });
				
			}
		});
        
        
        try {
            tray.add(trayIcon);
             Eye eye=new Eye();
             //eye.popup();
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
    }
    	
    
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = Eye.class.getResource(path);
        
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

    public void popup()
    {
    	//trayIcon.displayMessage("Eye Care","GIVE A REST TO YOUR EYES ", TrayIcon.MessageType.WARNING);
    	JOptionPane.showMessageDialog(null, "GIVE A REST TO YOUR EYES", "",1);
    }
    
}
