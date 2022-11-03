package assignment4.problem1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SentenceGenerator is a class used generate random sentence according to grammar provided
 *
 * @author kabraambika19 and vrindabisani
 */
public class SentenceGenerator {

  /**
   * Constant for start non-terminal
   */
  private static final String START_NON_TERMINAL = "start";

  /**
   * Constant for Empty string
   */
  private static final String EMPTY_SENTENCE = "";
  /**
   * Constant for single space
   */
  private static final String SINGLE_SPACE = " ";

  /**
   * Regex for placeholder element
   */
  private static final String NON_TERMINAL_REGEX = "(?<=\\<)(.*?)(?=\\>)";

  /**
   * Constant for pattern complied for placeholder regex
   */
  private static final Pattern NON_TERMINAL_PATTERN = Pattern.compile(NON_TERMINAL_REGEX);
  /**
   * Regex for punctuation
   */
  private static final String PUNCTUATION_REGEX = "\\p{Punct}";
  /**
   * Constant for pattern of punctuation regex
   */
  private static final Pattern PUNCTUATION_PATTERN = Pattern.compile(PUNCTUATION_REGEX);
  private Grammar grammar;
  private Long randomSeed;

  /**
   * Constructor of SentenceGenerator
   *
   * @param grammar    Represented as Grammar instance, represents grammar json file
   * @param randomSeed Represented as Long, number used to generate random number for creating
   *                   sentence
   */
  public SentenceGenerator(Grammar grammar, Long randomSeed) {
    this.grammar = grammar;
    this.randomSeed = randomSeed;
  }

  /**
   * Getter of grammar instance
   *
   * @return this.grammar, Represented as Grammar
   */
  public Grammar getGrammar() {
    return this.grammar;
  }

  /**
   * This method generates sentence according to start provided in grammar instance
   *
   * @return Represented as String, final sentence for user
   */
  public String generateRandomSentence() throws MissingDefinitionException {
    //Choose one of the start productions at random
    String startProduction = readDefinition(START_NON_TERMINAL);
    //add words of start production in stack
    Stack<String> grammarElements = splitStartProduction(startProduction);
    return createSentence(grammarElements).trim(); //replace placeholder by value
  }

  /**
   * This helper method recursively replaces a non-terminal, considering its definition, which will
   * contain a set of productions. then chooses one of the productions at random. Take the words
   * from the chosen production in sequence and add them in stack (recursively) and expands it to
   * generate a random sentence.
   *
   * @param grammarElements Represented as Stack of string, Stack of start production elements
   * @return Represented as String, empty string if stack is empty else sentence
   */
  private String createSentence(Stack<String> grammarElements) throws MissingDefinitionException {
    if (grammarElements.isEmpty()) {
      return EMPTY_SENTENCE; //base case: when there is no stack of grammar elements
    }
    else {
      String topElement = grammarElements.pop(); //get word from stack

      //get grammarElement name by removing starting and ending angular bracket
      String grammarElement = getGrammarElement(topElement);

      if (grammarElement.isEmpty()) {
        return textSpaceCorrection(topElement) + createSentence(grammarElements);
      } else {
        //get value of grammarElement from grammar
        String elementValue = readDefinition(grammarElement);

        //create list of words for grammarElement value
        List<String> innerElementList = Arrays.asList(elementValue.split(SINGLE_SPACE));

        Collections.reverse(innerElementList); //reverse list
        grammarElements.addAll(innerElementList); //add reversed list in stack

        return createSentence(grammarElements);
      }
    }
  }

  /**
   * This private method adds space with terminal, if terminal is a punctuation then no space
   * needed
   *
   * @param terminal String, top terminal from stack of sentence
   * @return String, if punctuation, return terminal again else return after adding space before
   * element
   */
  private String textSpaceCorrection(String terminal) {
    if (isPunctuation(terminal)) {
      return terminal;
    } else {
      return SINGLE_SPACE + terminal;
    }
  }

  /**
   * This private method checks if terminal is punctuation or not
   *
   * @param terminal Represented as String, word from stack
   * @return boolean, return true if terminal is punctuation or else return false
   */
  private boolean isPunctuation(String terminal) {
    String terminalString = terminal.trim();
    Matcher matcher = PUNCTUATION_PATTERN.matcher(terminalString);
    if (!terminalString.isEmpty() && matcher.find() && matcher.start() == 0) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  /**
   * Getter for placeholder nonTerminal with the help of regex pattern by finding match or not
   *
   * @param nonTerminal Represented as String, word from sentence
   * @return Represented as String, Empty string if nonTerminal is not a placeholder else
   * placeholder name
   */
  private String getGrammarElement(String nonTerminal) {
    Matcher matcher = NON_TERMINAL_PATTERN.matcher(nonTerminal);
    if (matcher.find()) {
      return matcher.group(1).trim();
    }

    return EMPTY_SENTENCE;
  }

  /**
   * Generated a stack of words in start element in given grammar
   *
   * @param grammarExpression Represented as string, start sentence in grammar
   * @return Represented as Stack of String
   */
  private Stack<String> splitStartProduction(String grammarExpression) {
    Stack<String> wordsStack = new Stack<>();
    List<String> wordsList = Arrays.asList(grammarExpression.split(SINGLE_SPACE));
    Collections.reverse(wordsList);
    wordsStack.addAll(wordsList);
    return wordsStack;
  }

  /**
   * This private method returns value of element at any random number in grammar
   *
   * @param element Represented as String, Grammar element
   * @return String, value of element at any random number in grammar
   * @throws MissingDefinitionException if there is no value of element in grammar json file
   */
  private String readDefinition(String element) throws MissingDefinitionException {
    List<String> productionList = this.getGrammar().getProductions(element);
    if (productionList == null) {
      throw new MissingDefinitionException("The " + this.grammar.getGrammarTitle()
          + " JSON file does not have productions of non-terminal " + element
          + " to create a random sentence.");
    }

    Random random = generateRandomNumber();
    return productionList.get(random.nextInt(productionList.size()));
  }

  /**
   * Generates random instance according to seed provided or not
   *
   * @return Represented as Random, instance of Random
   */
  private Random generateRandomNumber() {
    return (this.randomSeed == null) ? new Random() : new Random(this.randomSeed);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SentenceGenerator that = (SentenceGenerator) obj;
    return Objects.equals(this.getGrammar(), that.getGrammar());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getGrammar());
  }

  @Override
  public String toString() {
    return "SentenceGenerator{" +
        "grammar=" + this.getGrammar() +
        '}';
  }
}