package org.sumanta.util.ssh;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

//import com.sshtools.daemon.SshServer;
import com.sshtools.j2ssh.SftpClient;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.session.SessionChannelClient;
import com.sshtools.j2ssh.sftp.SftpFile;
import com.sshtools.j2ssh.transport.IgnoreHostKeyVerification;

public class SshApi {
	
	public static SshClient sshClnt=new SshClient();
	
	
	public void connect(String ip,String uname,String pass) throws Exception 
	{
		sshClnt.connect(ip,new IgnoreHostKeyVerification());
		PasswordAuthenticationClient  pac = new PasswordAuthenticationClient();
		pac.setUsername(uname);
		pac.setPassword(pass);
		int result = sshClnt.authenticate(pac);
	}
	
	public void disconnect() throws Exception 
	{
		sshClnt.disconnect();
	}
	
	public InputStream Execute(String cmd) throws Exception {
		SessionChannelClient session = sshClnt.openSessionChannel();
		session.executeCommand(cmd);
		InputStream in = session.getInputStream();
        byte buffer[] = new byte[100000];
        int read;
        return in;
        //while ((read = in.read(buffer)) > 0) {

          //  System.out.write(buffer, 0, read);
        //}
	}
	
	public static void  getFiles(SftpClient sftp,String srcpath,String despath) throws Exception {
		sftp.cd(srcpath);
		sftp.lcd(despath);
		List list = sftp.ls();
		Iterator i = list.iterator();
		while(i.hasNext())
		{
		SftpFile file = (SftpFile)i.next();
		System.out.println(file.getFilename());
		if(!file.getFilename().equals(".") && !file.getFilename().equals(".."))
		{
			if(file.isFile())
			sftp.get(file.getFilename());
			else if (file.isDirectory())
			{
				SshApi.makeDir(despath,file);
				SshApi.getFiles(sftp,srcpath+"/"+((SftpFile)file).getFilename(),despath+"\\"+((SftpFile)file).getFilename());
				sftp.cd("../");
			}
	 	}
		}		
	}

	
	public static void makeDir(String path,SftpFile file) throws Exception {
		/*Runtime r=Runtime.getRuntime();
		String os=System.getProperty("os.name").toLowerCase();
		if(os.contains("win")){
			System.out.println("mkdir "+path+"\\"+((SftpFile)file).getFilename().toString());
			r.exec("mkdir "+path+"\\"+((SftpFile)file).getFilename().toString());
		}
		else if(os.contains("lin"))
		{
			r.exec("mkdir "+path+"/"+((SftpFile)file).getFilename());
		}*/
		File localdir = new File(path+"\\"+((SftpFile)file).getFilename());
		if (!localdir.exists()) {
			if (localdir.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}
	
	
}
