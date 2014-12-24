package org.sumanta.common;

import com.sshtools.j2ssh.SftpClient;
import com.sshtools.j2ssh.SshClient;

public class SshInterface {

	public static void pull() throws Exception
	{
		final SshClient sshClnt=Utility.sshClnt;
		Utility.connect(Common.getIporhostname(), Common.getUser(), Common.getPasswd());
		final SftpClient sftp = sshClnt.openSftpClient();

		 Utility.getFiles(sftp, Common.source,
				 Common.destination);
		 sftp.quit();
		 sshClnt.disconnect();
	}
	
	public static void push() throws Exception
	{
		final SshClient sshClnt=Utility.sshClnt;
		Utility.connect(Common.getIporhostname(), Common.getUser(), Common.getPasswd());
		final SftpClient sftp = sshClnt.openSftpClient();

		 Utility.putFiles(sftp, Common.source,
				 Common.destination);
		 sftp.quit();
		 sshClnt.disconnect();
	}
	
}
