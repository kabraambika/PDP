package assignment3.problem1.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CSVReader is used to read the content of CSV file and stores in List of String
 * @author kabraambika19
 */
public class CSVReader {
  private List<String> cvsContent;

  /**
   * Constructor of CSVReader
   * @param csvPath path of csv file
   * @throws IOException when file is not found or something went wrong while reading the CSV file
   */
  public CSVReader(String csvPath) throws IOException {
    this.cvsContent = new ArrayList<>();
    this.readCSV(csvPath);
  }

  /**
   * Gets the CSV content in form of list of strings
   * @return List of String, this.cvsContent
   */
  public List<String> getCvsContent() {
    return this.cvsContent;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CSVReader csvReader = (CSVReader) obj;
    return Objects.equals(this.getCvsContent(), csvReader.getCvsContent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getCvsContent());
  }

  @Override
  public String toString() {
    return "CSVReader{" +
        "cvsContent=" + this.getCvsContent() +
        '}';
  }

  /**
   * This private method reads CSV file and stores each line of CSV in List
   * @param csvPath path of CSV file
   */
  private void readCSV(String csvPath) throws IOException {
    File file = new File(csvPath);

    try(InputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      String singleLine;
      while((singleLine = bufferedReader.readLine()) != null) {
        if(!singleLine.trim().isEmpty()){
          this.getCvsContent().add(singleLine);
        }
      }
    }
    catch(FileNotFoundException fileEx) {
      throw new FileNotFoundException("File was not found : " + fileEx.getMessage());
    }
    catch(IOException ex) {
      throw new IOException("Something went wrong in CSV file: " + csvPath);
    }
  }
}
