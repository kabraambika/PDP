package assignment4.problem1;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * JSONFileReader is used to read grammar json file at given path
 *
 * @author kabraambika19 and vrindabisani
 */
public class JSONFileReader {

  /**
   * This function is used to read json file from directory at given path in inputs
   *
   * @param jsonFileName Represented as String, path of json file
   * @return Represented as Map, where key is element in String and Value is List of String
   */
  public Map<String, JsonElement> readFile(String jsonFileName) {
    Map<String, JsonElement> grammarJson;
    try (Reader fileReader = Files.newBufferedReader(Paths.get(jsonFileName))) {
      JsonElement jsonElement = JsonParser.parseReader(fileReader);
      JsonObject rootObject = jsonElement.getAsJsonObject();
      grammarJson = rootObject.asMap();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return grammarJson;
  }
}
