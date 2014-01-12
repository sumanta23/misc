package org.sumanta.util;

import javax.swing.JMenuItem;


public class TabDetails {

	private int id;
	private Object object;
	public JMenuItem jm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	public JMenuItem getJm() {
		return jm;
	}
	public void setJm(JMenuItem jm) {
		this.jm = jm;
	}
	public TabDetails(int id,Object obj,JMenuItem jm) {
		setId(id);
		setObject(obj);
		setJm(jm);
	}
	
}
