package org.sumanta.main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.sumanta.gui.TabbedPane;

public class Main {
	public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		TabbedPane.createAndShowGUI();
            }
        });
    }
}
