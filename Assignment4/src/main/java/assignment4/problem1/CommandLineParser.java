package assignment4.problem1;
import java.io.File;
import java.util.List;


public class CommandLineParser {
  private String directoryPath;
  public CommandLineParser(String directoryPath) {
    if(validateDirectory(directoryPath)) {
      this.directoryPath = directoryPath;
    } else {
      throw new DirectoryDoesNotExistException("Unable to process directory path for reading grammar.");
    }
  }

  private boolean validateDirectory(String directoryPath) {
    File grammarDirectory = new File(directoryPath);
    return grammarDirectory.exists() && grammarDirectory.isDirectory() && grammarDirectory.canRead();
  }

  public File getDirectoryFile() {
    return new File(this.directoryPath);
  }
}

