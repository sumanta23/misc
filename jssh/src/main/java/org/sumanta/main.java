package org.sumanta;



import java.io.InputStream;
import java.util.*;

//import com.sshtools.ant.Ssh;
import com.sshtools.j2ssh.SftpClient;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.session.SessionChannelClient;
import com.sshtools.j2ssh.sftp.SftpFile;
import com.sshtools.j2ssh.transport.IgnoreHostKeyVerification;
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub


		/*SshClient sshClnt=new SshClient();
		sshClnt.connect("192.168.150.133",new IgnoreHostKeyVerification());
		PasswordAuthenticationClient  pac = new PasswordAuthenticationClient();
		pac.setUsername("root");
		pac.setPassword("password");
		int result = sshClnt.authenticate(pac);
		if (result == AuthenticationProtocolState.COMPLETE) {*/
		SshClient sshClnt=util.sshClnt;
		util.connect("192.168.150.1141", "root", "password");
		 SftpClient sftp = sshClnt.openSftpClient();
		// sftp.lcd("C:\\Users\\Sumanta\\Linuxshare");
		 //sftp.cd("/root/windowsshare");
		 //sftp.get("a.txt");
		 util.getFiles(sftp, "/root/windowsshare",
				 "C:\\Users\\Sumanta\\Linuxshare");
		 sftp.quit();
		 sshClnt.disconnect();
		

		
		
		
	}

}
