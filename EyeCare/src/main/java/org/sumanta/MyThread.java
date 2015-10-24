package org.sumanta;


public class MyThread implements Runnable {

	//Date date=new Date();
	@Override
	public void run() {
		Eye e=new Eye();
		e.startRun();
		while(true)
		{
		try
		{
			e.popup();
			Thread.sleep(Eye.time*60000);
		}
		catch(Exception te)
		{
			te.printStackTrace();
		}
		}
	}

	

}
