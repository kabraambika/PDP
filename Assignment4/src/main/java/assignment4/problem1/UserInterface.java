package assignment4.problem1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
  private static final String QUIT = "q";
  private static final String YES = "y";
  private static final String NO = "n";
  private File directory;
  private List<Grammar> grammarList;
  private Scanner scanner;
  private PrintStream printStream;
  private boolean testMode;

  public UserInterface(File directory, InputStream inputStream, PrintStream printStream, boolean testMode) {
    this.scanner = new Scanner(inputStream);
    this.printStream = printStream;
    this.directory = directory;
    this.grammarList = new ArrayList<>();
    this.testMode = testMode;
  }

  public void initiateProgram() throws EmptyDirectoryException {
    System.out.println("Loading grammars...");
    this.grammarList = this.loadGrammars(this.directory);
    String grammarInput = this.readGrammarOption();
    this.runUserInput(grammarInput);
    String secondInput = this.readInputToContinue();
    this.continueProgram(secondInput, grammarInput);
  }

  private void continueProgram(String secondInput, String grammarInput) {
    if(secondInput.equals(YES)) {
      this.runUserInput(grammarInput);
      String continueInput = this.readInputToContinue();
      this.continueProgram(continueInput, grammarInput);
    }
    else if (secondInput.equals(NO)) {
      String grammarOption = this.readGrammarOption();
      if(!this.testMode) {
        this.runUserInput(grammarOption);
        String continueInput = this.readInputToContinue();
        this.continueProgram(continueInput, grammarOption);
      }
    }
  }

  private String readInputToContinue() {
    System.out.println("Would you like another from same grammar? (y/n)");

    String continueInput = this.scanner.nextLine().trim();
    while (continueInput == null || !validInputToContinue(continueInput)) {
      System.out.println("Invalid choice.\nWould you like another from same grammar? (y/n)");
      continueInput = this.scanner.nextLine().trim();
    }
    return continueInput;
  }

  private boolean validInputToContinue(String continueInput) {
    String userInput = continueInput.trim();
    if(userInput.equals(YES) || userInput.equals(NO))
      return Boolean.TRUE;
    else
      return Boolean.FALSE;
  }

  private void runUserInput(String userInput) {
    int grammarIndex;
    if(userInput.equals(QUIT)) {
      System.out.println("Existing program...");
      System.exit(0);
    }
    else {
      grammarIndex = Integer.parseInt(userInput) - 1;
      SentenceGenerator sentenceGenerator = new SentenceGenerator(this.grammarList.get(grammarIndex), null);

      try {
        String finalSentence = sentenceGenerator.generateRandomSentence();
        printStream.println(finalSentence);
      }
      catch (MissingDefinitionException definitionException) {
        printStream.println(definitionException.getMessage());
      }
      catch (StackOverflowError overflowError) {
        printStream.println("Grammar file is creating infinite recursive call on non terminal element.");
      }
    }
  }

  private String readGrammarOption() {
    System.out.println("The following grammars are available:");
    int grammarIndex = 1;
    for(Grammar grammar : this.grammarList) {
      System.out.println(grammarIndex++ + ". " + grammar.getGrammarTitle());
    }
    System.out.println("\nPlease enter a number representing one of the grammar option above (press 'q' to quit)");
    return scanUserInput();
  }

  private String scanUserInput() {
    String chosenGrammar = this.scanner.nextLine().trim();
    while (chosenGrammar == null || !validGrammarIndex(chosenGrammar)) {
      System.out.println("Invalid grammar choice.\nPlease enter a number representing one of the grammar option above (press 'q' to quit)");
      chosenGrammar = this.scanner.nextLine().trim();
    }
    return chosenGrammar.trim();
  }

  private boolean validGrammarIndex(String chosenGrammar) {
    int chosenIndex;

    if(chosenGrammar.equalsIgnoreCase(QUIT)) {
      return Boolean.TRUE;
    }

    try {
      chosenIndex = Integer.parseInt(chosenGrammar);
    }
    catch (NumberFormatException formatException) {
      return false;
    }

    return chosenIndex <= this.grammarList.size() && chosenIndex > 0;
  }

  /**
   * Loads grammar files from the directory
   * @param grammarDirectory path to grammar directory
   * @return list of grammars from json files in the directory
   * @throws EmptyDirectoryException if directory has no json grammar files
   * @throws DirectoryDoesNotExistException if directory does not exist
   */
  private List<Grammar> loadGrammars(File grammarDirectory) throws EmptyDirectoryException {
    List<Grammar> grammars = new ArrayList<>();
    File[] grammarFiles = grammarDirectory.listFiles();
    if(grammarFiles.length == 0) {
      throw new EmptyDirectoryException("Grammar files are not available in directory");
    }
    else {
      for(File path: grammarFiles) {
        JSONFileParser jsonFileParser = new JSONFileParser(path.getAbsolutePath());
        grammars.add(jsonFileParser.processJsonFile());
      }
    }
    return grammars;
  }
}
