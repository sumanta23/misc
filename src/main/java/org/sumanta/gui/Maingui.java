package org.sumanta.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.net.URL;
import javax.swing.*;

import org.sumanta.common.Common;
import org.sumanta.common.SshInterface;

public class Maingui {
	final static TrayIcon TRAYICON =
            new TrayIcon(createImage("bulb.gif", "tray icon"));
	final static SystemTray TRAY = SystemTray.getSystemTray();
	
	static int time=3;
	
    public void startRun() {
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
        	final PrintStream out=System.out;
            out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        
        
        final MenuItem sourcedestination=new MenuItem("Source:Destination");
        final MenuItem pull=new MenuItem("Pull");
        final MenuItem push=new MenuItem("Push");
        final MenuItem exitItem = new MenuItem("Exit");
        popup.add(sourcedestination);
        popup.add(pull);
        popup.add(push);
        popup.add(exitItem);
        TRAYICON.setPopupMenu(popup);
        TRAYICON.setImageAutoSize(true);
        sourcedestination.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final String option=JOptionPane.showInputDialog(null,"Give Source and Destination",
						"git@192.168.150.139:/home/git/ C:/Users/Sumanta/Dropbox/ParentRepository password");
				if(option!=null && option.split(" ").length==3){
					Common.setSource(option.split(" ")[0].split(":")[1]);
					Common.setDestination(option.split(" ")[1]);
					Common.setIporhostname(option.split(" ")[0].split("@")[1].split(":")[0]);
					Common.setUser(option.split(" ")[0].split("@")[0]);
					Common.setPasswd(option.split(" ")[2].trim());
				}
				else{
					JOptionPane.showMessageDialog(null, "Give Source and Destination properly");
				}
			}
		});
        pull.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SshInterface.pull();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
        push.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					SshInterface.push();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TRAY.remove(TRAYICON);
                System.exit(0);
            }
        }); 
        
    
        
        
        
        try {
            TRAY.add(TRAYICON);
        } catch (AWTException e) {
        	final PrintStream out=System.out;
            out.println("TrayIcon could not be added.");
            return;
        }
    }
    	
    
    //Obtain the image URL
    protected static Image createImage(final String path,final String description) {
        final URL imageURL = Maingui.class.getResource(path);
        
        if (imageURL == null) {
        	final PrintStream out=System.err;
            out.println("Resource not found: " + path);
            return null;
        } else {
            return new ImageIcon(imageURL, description).getImage();
        }
    }
    
}
