package assignment3.problem1.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CSVParser is a file responsible for reading CSV file and stores csv data in nested list after parsing.
 * each line is stored in list and further all lines are stored in list
 * @author kabraambika19
 **/
public class CSVParser {

  /**
   * csvData stored in nested list
   */
  private List<List<String>> csvData;
  /**
   * Regex expression for splitting single line of CSV file
   */
  private static final String CSV_SPLIT = "([^\\\"](?:[^\\\"]*[^\\\"]))";
  /**
   * Constant created of Pattern instance of CSV Regex expression
   */
  private static final Pattern CSV_PATTERN = Pattern.compile(CSV_SPLIT);
  private CSVReader csvReader;

  /**
   * Constructor of CSVParser
   * initializing the list for csvData and reads the CSV file for given path as input
   * @param csvPath Represented as string, CSV file path provided in args
   * @throws IOException when file is not found or something went wrong while reading the CSV file
   */
  public CSVParser(String csvPath) throws IOException {
    this.csvData = new ArrayList<>();
    csvReader = new CSVReader(csvPath);
    this.parseCSVContent(csvReader.getCvsContent());
  }

  /**
   * Getter method for csvData
   * @return this.csvData, list of String type list
   */
  public List<List<String>> getCsvData() {
    return this.csvData;
  }

  /**
   * This helper method parse list of strings of CSV to store single line of csv single value in list after apply regex and processing data
   * @param cvsContent Represented as list of string of csv content
   */
  private void parseCSVContent(List<String> cvsContent) {
    for(String csvLine : cvsContent) {
      List<String> singleLineContent = new ArrayList<>();
      Matcher matcher = CSV_PATTERN.matcher(csvLine);
      while(matcher.find()) {
        singleLineContent.add(matcher.group(1));
      }
      this.csvData.add(singleLineContent);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CSVParser csvParser = (CSVParser) obj;
    return Objects.equals(this.getCsvData(), csvParser.getCsvData());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getCsvData());
  }
}