package org.sumanta.command;

import org.junit.Test;

public class CommandTest {

  @Test
  public void test() {
    
    FileSystem fileSystem;
    
    if(System.getProperty("os.name").contains("x")){
      fileSystem=new UnixFileSystem();
    }else{
      fileSystem=new WindowsFileSystem();
    }
    
    ReadFile readFile=new ReadFile(fileSystem);
    
    FileInvoker fileInvoker=new FileInvoker(readFile);
    
    fileInvoker.execute();
  }

}
