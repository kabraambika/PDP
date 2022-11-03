package assignment3.problem1.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * TemplateHelper reads template and returns template content in string
 * @author kabraambika19
 */
public class TemplateHelper {

  /**
   * This static method reads template file by provided template path in String
   * @param filePath template path, Represented as String
   * @return String, template content
   * @throws IOException While getting file, streaming file and reading if something goes wrong, exception is thrown
   */
  public static String readFile(String filePath) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    String lineSeparator = System.lineSeparator();
    File file = new File(filePath);

    try(InputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      String singleLine;
      while((singleLine = bufferedReader.readLine()) != null) {
        stringBuilder.append(singleLine).append(lineSeparator);
      }
    }
    catch(FileNotFoundException fileEx) {
      throw new FileNotFoundException("File was not found : " + filePath);
    }
    catch(IOException ex) {
      throw new IOException("Something went wrong while reading file : " + filePath);
    }
    return stringBuilder.toString();
  }
}
