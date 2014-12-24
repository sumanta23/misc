package org.sumanta.cli;

import java.io.PrintStream;

import org.sumanta.common.Common;
import org.sumanta.common.SshInterface;

public class CliInterface {

	public static void main(final String[] args) throws Exception {
		try{
		Common.setSource(args[0].split(":")[1]);
		Common.setDestination(args[1]);
		Common.setIporhostname(args[0].split("@")[1].split(":")[0]);
		Common.setUser(args[0].split("@")[0]);
		Common.setPasswd(args[2]);
		SshInterface.pull();
		}
		catch(Exception e)
		{
			final PrintStream out=System.out;
			out.println(e.getMessage());
			out.println("cli <source> <destn> <password>");
			out.println("ex: cli root@192.168.2.1:/var/tmp/mydir local_mydir ****");
		}
	}
}
