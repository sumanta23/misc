package org.sumanta.command;

public class CloseFile implements Command {


  FileSystem fileSystem;
  
  public CloseFile(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public void execute() {
    this.fileSystem.closFile();
  }

}
