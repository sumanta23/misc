package org.sumanta.command;

public class WindowsFileSystem implements FileSystem {

  @Override
  public void openFile() {
    System.out.println("opening file in Windows");
    
  }

  @Override
  public void readFile() {
    System.out.println("reading file in Windows");
    
  }

  @Override
  public void closFile() {
    System.out.println("closing file in Windows");
    
  }

}
