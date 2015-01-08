package org.sumanta.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClientListener extends Thread {

	static String message;

	public void run() {
		InputStream is = null;
		InputStreamReader isr = null ;
		BufferedReader br = null;
		while (true) {
			try {
				this.sleep(5);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (Client.socket!=null && !Client.socket.isClosed()) {
					is = Client.socket.getInputStream();
					isr = new InputStreamReader(is);
					br = new BufferedReader(isr);
					System.out.println("jk");
					message = br.readLine();
					setMessage();
					System.out.println("Message received from the server : "
							+ message);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(br!=null) br.close();
					if(isr!=null) isr.close();
					if(is!=null) is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	public static void setMessage() {
		ClientGui.chatHistory.setText(ClientGui.chatHistory.getText() + "\n"
				+ ClientGui.getdate() + ": " + message);
	}

}
