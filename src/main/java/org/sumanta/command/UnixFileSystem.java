package org.sumanta.command;

public class UnixFileSystem implements FileSystem{

  @Override
  public void openFile() {
    System.out.println("opening file in Unix");
    
  }

  @Override
  public void readFile() {
    System.out.println("reading file in Unix");
    
  }

  @Override
  public void closFile() {
    System.out.println("closing file in Unix");
    
  }

}
