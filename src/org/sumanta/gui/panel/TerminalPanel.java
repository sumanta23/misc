package org.sumanta.gui.panel;

public class TerminalPanel Panel {

	public TerminalPanel() {
		// TODO Auto-generated constructor stub
		JLabel ta=new JLabel();
		this.setLayout(null);
        ta.setEnabled(false);
        JScrollPane scroll = new JScrollPane (ta);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          
    scroll.setBounds(0,0,TabbedPane.tabbedPane.getSelectedComponent().getWidth(),TabbedPane.tabbedPane.getSelectedComponent().getHeight());
    ta.setSize(400, 300);
    this.add(scroll);
    ta.setText("jk");
	}
}
