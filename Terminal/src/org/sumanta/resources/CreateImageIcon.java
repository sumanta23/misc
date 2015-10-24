package org.sumanta.resources;

import javax.swing.ImageIcon;


public class CreateImageIcon {
	 /** Returns an ImageIcon, or null if the path was invalid. */
    public ImageIcon createImageIcon(String path) {
    	java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

