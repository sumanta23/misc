package org.sumanta.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.SliderUI;

import com.sshtools.j2ssh.FileTransferProgress;
import com.sshtools.j2ssh.DirectoryOperation;
import com.sshtools.j2ssh.SftpClient;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.session.SessionChannelClient;
import com.sshtools.j2ssh.sftp.SftpFile;
import com.sshtools.j2ssh.transport.IgnoreHostKeyVerification;

public class Utility {
	
	public static SshClient sshClnt=new SshClient();
	
	
	public static void connect(String ip,String uname,String pass) throws Exception 
	{
		sshClnt.connect(ip,new IgnoreHostKeyVerification());
		final PasswordAuthenticationClient  pac = new PasswordAuthenticationClient();
		pac.setUsername(uname);
		pac.setPassword(pass);
		sshClnt.authenticate(pac);
	}
	
	public static void disconnect() throws Exception 
	{
		sshClnt.disconnect();
	}
	
	public static void  getFiles(SftpClient sftp,String srcpath,String despath) throws Exception {
		sftp.cd(srcpath);
		sftp.lcd(despath);
		final List list = sftp.ls();
		final Iterator i = list.iterator();
		while(i.hasNext())
		{
		final SftpFile file = (SftpFile)i.next();
		if(!file.getFilename().equals(".") && !file.getFilename().equals(".."))
		{
			if(file.isFile()){
				sftp.get(file.getFilename());
			}
			else if (file.isDirectory())
			{
				Utility.makeDir(despath,file);
				Utility.getFiles(sftp,srcpath+"/"+((SftpFile)file).getFilename(),despath+"\\"+((SftpFile)file).getFilename());
				sftp.cd("../");
				sftp.lcd("../");
			}
	 	}
		}		
	}

	public static void  putFiles(SftpClient sftp,String srcpath,String despath) throws Exception {
		sftp.cd(srcpath);
		sftp.lcd(despath);
		final File nfile=new File(despath);
		final String[] list=nfile.list();
		for (final String sf : list)
		{
		final File file = new File(despath+"\\"+sf);
		if(!file.getName().equals(".") && !file.getName().equals(".."))
		{
			if(file.isFile()){
				sftp.put(file.getName());
			}
			else if (file.isDirectory())
			{
				Utility.makeRemoteDir(sftp,srcpath,file);
				Utility.putFiles(sftp,srcpath+"/"+file.getName(),despath+"/"+file.getName());
				sftp.cd("../");
			}
	 	}
		}		
	}
	
	
	public static void makeDir(String path,SftpFile file) throws Exception {
		File localdir = new File(path+"\\"+((SftpFile)file).getFilename());
		if (!localdir.exists()) {
			if (localdir.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}
	
	public static void makeRemoteDir(SftpClient sftpc,String path,File file) throws IOException {
		sftpc.mkdir(path+"/"+file.getName());
	}
}

