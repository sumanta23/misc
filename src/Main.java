import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.sumanta.ssh.util;

import com.sshtools.j2ssh.SftpClient;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.sftp.FileAttributes;
import com.sshtools.j2ssh.sftp.SftpFile;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;


public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.NoOpLog");
		// TODO Auto-generated method stub
		//localSystem("c:\\myfiles");
		//remoteSambaSystem("", "", "");
		//remoteNfsSystem("");
		remotesshSystem("", "", "");
	}

	
	public static void localSystem(String path)
	{
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		try{
		File f=new File(path);
		if(f.isDirectory())
		{
			File fa[]=f.listFiles();
			for (File file : fa) {
				System.out.println(file.getName()+"   |   "+file.getPath()+"   |   "
						+java.nio.file.Files.getOwner(file.toPath())+"   |   "+ft.format(file.lastModified()));
			}
		}
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("file not found ");
			fnf.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void remoteSambaSystem(String path,String username,String password) throws IOException {
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		//String path="smb://ip_address/"+sharedFolder+"/test.txt";
		path="smb://192.168.150.141/share/";
	    NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("",username, password);
	    SmbFile smbFile = new SmbFile(path,auth);
	    if (smbFile.isDirectory()) {
	    	SmbFile fa[]=smbFile.listFiles();
			for (SmbFile file : fa) {
			System.out.println(file.getName()+"|"+file.getPath()+"|"
					+file+"|"+ft.format(file.getLastModified()));
			}
		}
		
	}
	
	public static void remoteNfsSystem(String path) {
		path="//192.168.150.141/share/";
		if(!path.endsWith("/"))
		{
			path=path+"/";
		}
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		try{
		File f=new File(path);
		if(f.isDirectory())
		{
			File fa[]=f.listFiles();
			for (File file : fa) {
				System.out.println(file.getName()+"   |   "+file.getPath()+"   |   "
						+java.nio.file.Files.getOwner(file.toPath())+"   |   "+ft.format(file.lastModified()));
			}
		}
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("file not found ");
			fnf.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	private static void remotesshSystem(String path,String username,String password) throws Exception {
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		SshClient sshClnt=util.sshClnt;
		util.connect("192.168.150.141", "root", "password");
		path="192.168.150.141:/share";
		 SftpClient sftp = sshClnt.openSftpClient();
		 sftp.cd("/share");
		 try{
				List list = sftp.ls();
				Iterator i = list.iterator();
				while(i.hasNext())
				{
				SftpFile file = (SftpFile)i.next();
				System.out.println(file.getFilename()+"  |  "+file.getAbsolutePath()+"  |  "
						+file.getAttributes().getUID()+"   |   "+ft.format(file.getAttributes().getAccessedTime()));
				}
		 	}
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 sftp.quit();
			 sshClnt.disconnect();
		 }
	}
	
	
}
