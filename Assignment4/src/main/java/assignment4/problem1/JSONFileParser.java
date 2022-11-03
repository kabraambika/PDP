package assignment4.problem1;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * JSONFileParser is class which parses grammar json file and return grammar instance of Grammar
 * class
 *
 * @author kabraambika19 and vrindabisani
 */
public class JSONFileParser {

  /**
   * Constant used for json extension
   */
  private static final String JSON_EXTENSION = ".json";
  /**
   * Constant for element grammarTitle in json file
   */
  private static final String GRAMMAR_TITLE = "grammarTitle";

  /**
   * Constant for element grammarDesc in json file
   */
  private static final String GRAMMAR_DESC = "grammarDesc";
  /**
   * Constant for empty string
   */
  private static final String EMPTY_STRING = "";
  private String jsonFileName;

  /**
   * Constructor of JSONFileParser which validates JSON File, if not valid then throws
   * InvalidJSONFileException exception
   *
   * @param jsonFileName Represented as String, name of json File
   * @throws InvalidJSONFileException if json file is not valid as conditions like: file extension
   *                                  is not json, file does not exist, is not a file or can not be
   *                                  read
   */
  public JSONFileParser(String jsonFileName) throws InvalidJSONFileException {
    if (validateFile(jsonFileName)) {
      this.jsonFileName = jsonFileName;
    } else {
      throw new InvalidJSONFileException("Invalid " + jsonFileName + " json file !");
    }
  }

  /**
   * This private method reads json file at given path and returns grammar instance
   *
   * @return Represented as Grammar, provides information like grammar title, grammar desc, and
   * other elements in map
   */
  public Grammar processJsonFile() {
    JSONFileReader jsonReader = new JSONFileReader();
    Map<String, JsonElement> grammarJson = jsonReader.readFile(this.jsonFileName);
    return parseJsonContent(grammarJson);
  }

  /**
   * This private method removes GRAMMAR_TITLE and GRAMMAR_DESC from json and creates grammar
   * instance
   *
   * @param jsonElementMap Map of json elements from json file
   * @return Represented as Grammar, Grammar instance
   */
  private Grammar parseJsonContent(Map<String, JsonElement> jsonElementMap) {
    String grammarTitle = getGrammarTitleFromJson(jsonElementMap);
    String grammarDesc = getGrammarDescFromJson(jsonElementMap);
    jsonElementMap.remove(GRAMMAR_TITLE);
    jsonElementMap.remove(GRAMMAR_DESC);

    Map<String, List<String>> nonTerminalMap = getNonTerminalDefinitions(jsonElementMap);

    return new Grammar(grammarTitle, grammarDesc, nonTerminalMap);
  }

  /**
   * This helper method creates a map of non-terminal element definitions.
   * This function converts map of String and jsonElement into non-terminal names and productions into map
   * The names of non-terminals will be case-insensitively, matching Adj and adj, for example
   *
   * @param jsonElementMap Map of String,JSONElement from json file
   * @return This function return map as key is name of non-terminal and value is list of String, productions
   */
  private Map<String, List<String>> getNonTerminalDefinitions(Map<String, JsonElement> jsonElementMap) {
    Map<String, List<String>> definitionsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    jsonElementMap.forEach((nonTerminal, jsonValue) -> {
      JsonArray productionArray = jsonValue.getAsJsonArray();
      List<String> productions = new ArrayList<>();

      if (productionArray != null) {
        for (int index = 0; index < productionArray.size(); index++) {
          productions.add(productionArray.get(index).getAsString());
        }
      }
      definitionsMap.put(nonTerminal, productions);
    });

    return definitionsMap;
  }

  /**
   * This private method gets value of grammarDesc element from map of grammar json from reader
   *
   * @param jsonElementMap Map of String,JSONElement from json file
   * @return Represented as String
   */
  private String getGrammarDescFromJson(Map<String, JsonElement> jsonElementMap) {
    String grammarDesc = EMPTY_STRING;
    if (jsonElementMap.containsKey(GRAMMAR_DESC)) {
      grammarDesc = jsonElementMap.get(GRAMMAR_DESC).getAsString();
    }
    return grammarDesc;
  }

  /**
   * This private method gets value of grammarTitle element from map of grammar json from reader
   *
   * @param jsonElementMap Map of String,JSONElement from json file
   * @return Represented as String
   */
  private String getGrammarTitleFromJson(Map<String, JsonElement> jsonElementMap) {
    String grammarTitle = EMPTY_STRING;
    if (jsonElementMap.containsKey(GRAMMAR_TITLE)) {
      grammarTitle = jsonElementMap.get(GRAMMAR_TITLE).getAsString();
    }
    return grammarTitle;
  }

  /**
   * Validates if file is valid or not : conditions are valid json extension, file exists, file
   * object is file and file can be read
   *
   * @param jsonFileName Represented as String, json file path
   * @return represented as boolean
   */
  private boolean validateFile(String jsonFileName) {
    File jsonFile = new File(jsonFileName);
    return validateExtension(jsonFileName) && jsonFile.exists() && jsonFile.isFile()
        && jsonFile.canRead();
  }

  /**
   * Validates if file has valid json extension
   *
   * @param jsonFileName Represented as String, json file path
   * @return represented as boolean
   */
  private boolean validateExtension(String jsonFileName) {
    return jsonFileName.endsWith(JSON_EXTENSION);
  }
}
