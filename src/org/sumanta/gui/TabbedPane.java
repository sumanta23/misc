package org.sumanta.gui;


/*
 * TabbedPane.java requires one additional file:
 */

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.sumanta.gui.panel.LoginPanel;
import org.sumanta.util.TabDetails;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class TabbedPane extends JPanel implements ActionListener {
	
	ArrayList tabdetails=new ArrayList<TabDetails>();
	
	private static JMenuBar mb=new JMenuBar();
    private static JMenu file=new JMenu("File");
    private static JMenu edit=new JMenu("Edit");
    private static JMenuItem newtab=new JMenuItem("New Tab");
    private static JMenu closetab=new JMenu("Close Tab");
    
    private static JMenuItem exit=new JMenuItem("Exit");
    private static JMenuItem cut=new JMenuItem("Cut");
    private static JMenuItem copy=new JMenuItem("Copy");
    private static JMenuItem paste=new JMenuItem("Paste");
	
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon icon = createImageIcon("terminal.gif");
    
    public TabbedPane() {
        super(new GridLayout(1, 1));
        
        
        
        //JComponent panel1 = makeTextPanel("Panel #1");
        
        tabbedPane.addTab("Tab 1", icon, new LoginPanel(),"Still does nothing");
        
        tabdetails.add(new TabDetails(1,"Tab 1",new JMenuItem("Close Tab "+1)));
        //tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension s = toolkit.getScreenSize();
        setPreferredSize(new Dimension(400, 300)); 
        
        
        newtab.addActionListener(this);
        
        closetab.add(((TabDetails)tabdetails.get(0)).getJm());
		((TabDetails)tabdetails.get(0)).getJm().addActionListener(this);
        
		exit.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
    
    	if(e.getSource()==newtab)
    	{
    		LoginPanel lp=new LoginPanel();
    		int size=tabdetails.size();
		if(size!=0){
            		int lastaddedid=((TabDetails)tabdetails.get(size-1)).getId();
            		tabdetails.add(new TabDetails(lastaddedid+1,lp,new JMenuItem("Close Tab "+(1+lastaddedid))));
            		tabbedPane.addTab("Tab "+(lastaddedid+1), icon, lp, "new dynamic tab");
    		}
		else{
			tabdetails.add(new TabDetails(1,lp,new JMenuItem("Close Tab "+1)));
                	tabbedPane.addTab("Tab "+1, icon, lp, "new dynamic tab");
            	}
    		closetab.add(((TabDetails)tabdetails.get(size)).getJm());
    		((TabDetails)tabdetails.get(size)).getJm().addActionListener(this);
    	}
    	else if (e.getSource().toString().contains("Close")) {
    		int i=-1;
    		Iterator itr = tabdetails.iterator();
    	      while(itr.hasNext()) {
    	    	  i=i+1;
    	         TabDetails element = (TabDetails)itr.next();
    	         if(element.getJm().equals(e.getSource()))
    	         {
    	        	 tabbedPane.remove(i);
    	        	 closetab.remove(i);
    	        	 break;
    	         }
    	      }
			tabdetails.remove(i);
			
		}
    	else if (e.getSource()==exit) {
			System.exit(0);
		}
    }
   /* protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }*/
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPane.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
    	file.add(newtab);
    	file.add(closetab);
        file.add(exit);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        mb.add(file);
        mb.add(edit);
        
        mb.setBounds(0,0,10,20);
        
    	
    	JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Terminal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(mb,BorderLayout.NORTH);
        //Add content to the window.
        frame.add(new TabbedPane(), BorderLayout.CENTER);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
