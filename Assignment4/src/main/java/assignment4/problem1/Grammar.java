package assignment4.problem1;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Grammar class represents the grammar json file with information like grammar title, grammar desc,
 * and grammar definitions and its one or more productions
 *
 * @author kabraambika19 and vrindabisani
 */
public class Grammar {

  private final String grammarTitle;
  private final String grammarDesc;
  private final Map<String, List<String>> grammarDefinitions;

  /**
   * Constructor of Grammar
   *
   * @param grammarTitle       Represented as String, grammar title in json file
   * @param grammarDesc        Represented as String, grammar description in json file
   * @param grammarDefinitions Represented as String, grammar non-terminal and its definitions in
   *                           json file
   */
  public Grammar(String grammarTitle, String grammarDesc,
      Map<String, List<String>> grammarDefinitions) {
    this.grammarTitle = grammarTitle;
    this.grammarDesc = grammarDesc;
    this.grammarDefinitions = grammarDefinitions;
  }

  /**
   * Getter of grammar title
   *
   * @return Represented as String, this.grammarTitle
   */
  public String getGrammarTitle() {
    return this.grammarTitle;
  }

  /**
   * Getter of grammar description
   *
   * @return Represented as String, this.grammarDesc
   */
  public String getGrammarDesc() {
    return this.grammarDesc;
  }

  /**
   * This method provides list of values of given element from grammarDefinitions
   *
   * @param element Represented as String, name of element in grammar
   * @return Represented as List of String
   */
  public List<String> getProductions(String element) {
    return this.grammarDefinitions.get(element);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Grammar grammar = (Grammar) obj;
    return Objects.equals(this.getGrammarTitle(), grammar.getGrammarTitle())
        && Objects.equals(this.getGrammarDesc(), grammar.getGrammarDesc())
        && Objects.equals(this.grammarDefinitions, grammar.grammarDefinitions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getGrammarTitle(), this.getGrammarDesc(), this.grammarDefinitions);
  }

  @Override
  public String toString() {
    return "Grammar{" +
        "grammarTitle='" + this.getGrammarTitle() + '\'' +
        ", grammarDesc='" + this.getGrammarDesc() + '\'' +
        ", grammarDefinitions=" + this.grammarDefinitions +
        '}';
  }
}
