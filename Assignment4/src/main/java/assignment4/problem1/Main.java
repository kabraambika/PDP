package assignment4.problem1;

public class Main {

  public static void main(String[] args) {
    try {
      CommandLineParser parser = new CommandLineParser(args[0]);
      UserInterface ui;
      ui = new UserInterface(parser.getDirectoryFile(), System.in, System.out, false);
      ui.initiateProgram();
    }
    catch(ArrayIndexOutOfBoundsException ex) {
      throw new ArrayIndexOutOfBoundsException(ex.getMessage());
    }
    catch (EmptyDirectoryException directoryException) {
      throw new EmptyDirectoryException(directoryException.getMessage());
    }
  }
}
