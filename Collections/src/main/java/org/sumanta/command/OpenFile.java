package org.sumanta.command;

public class OpenFile implements Command {

  FileSystem fileSystem;

  public OpenFile(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public void execute() {
    this.fileSystem.openFile();
  }

}
