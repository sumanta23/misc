package arithmetic.parser;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;


public class APGUI {
	JFrame frame = new JFrame("ArithMetic Parser");
	JPanel panel = new JPanel();
	JTextField tf1=new JTextField();
	JTextField tf2=new JTextField();
	JButton jb1=new JButton("Evaluate");
	/*String LOGO="C:\\Documents and Settings\\tcsnasu\\My Documents\\java\\WinSCP.ico";
	java.net.URLClassLoader cl =(java.net.URLClassLoader)frame.getClass().getClassLoader();
	ImageIcon logoIcon = new javax.swing.ImageIcon(cl.findResource(LOGO));
	Image img=Toolkit.getDefaultToolkit().getImage(LOGO);*/
	
	public APGUI()
	{
		try{
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}catch(Exception e){}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		
		tf1.setBounds(50, 10, 200, 20);
		jb1.setBounds(100, 40, 100, 20);
		jb1.setBackground(Color.gray);
		jb1.setForeground(Color.blue);
		panel.add(tf1);
		panel.add(jb1);
		frame.add(panel);
		frame.setSize(300,200);
		frame.setResizable(false);
		frame.setLocation(500, 250);
		frame.setVisible(true);
		//frame.setIconImage(logoIcon.getImage());
		frame.setIconImage(loadImageIcon("biscuit.GIF").getImage());
		
		jb1.setToolTipText("click Me or Drag Me And watch Magic");
		tf1.setToolTipText("Enter the Arithmetic Expression");
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String argument=tf1.getText();
				if(argument.equals("")||argument.matches("[a-zA-Z]"))
				{
					JOptionPane.showMessageDialog(jb1, "Enter Some Value any try Again");
					System.exit(0);
				}
					
				ArithMeticParser ap=new ArithMeticParser(argument);
				tf2.setText(String.valueOf(ap.process()));
				tf2.setBounds(50, 100, 200, 20);
				tf2.setEditable(false);
				panel.add(tf2);
			}
		});
		
		tf1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e))
				{
					/*SwingUtilities.invokeLater(new Runnable() {
						public void run() {
						new APGUI();
						}
						});*/
					new APGUI();
				}
				if (e.getClickCount() == 2) 
					{
						Runtime r=Runtime.getRuntime();
						try{
						r.exec("notepad");
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		MouseMotionListener mml=new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				 if(e.getSource() instanceof JButton) {
					 jb1.setBounds(e.getXOnScreen()-frame.getX()-15,e.getYOnScreen()-40-frame.getY(),100,20);
				}
				 if(e.getSource() instanceof JTextField) {
					 tf1.setBounds(e.getXOnScreen()-frame.getX()-15,e.getYOnScreen()-40-frame.getY(),200,20);
				}
				
			}
		};
		
	jb1.addMouseMotionListener(mml);
	tf1.addMouseMotionListener(mml);
	
	}


	
	private static ImageIcon loadImageIcon(String path) {
        URL imgURL = APGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	
	
	public static void  main(String args[]) {
		APGUI a=new APGUI();
	}
	
}
