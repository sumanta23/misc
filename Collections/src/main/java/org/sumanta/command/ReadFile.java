package org.sumanta.command;

public class ReadFile implements Command {

  FileSystem fileSystem;
  
  public ReadFile(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public void execute() {
    this.fileSystem.readFile();
  }

}
