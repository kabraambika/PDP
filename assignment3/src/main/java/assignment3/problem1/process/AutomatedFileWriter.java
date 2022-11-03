package assignment3.problem1.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * AutomatedFileWriter class is used to write documents in output directory provided in args
 */
public class AutomatedFileWriter {

  /**
   * Constructor of AutomatedFileWriter
   * @param outputFilesContent List of AutomatedDocument, list of files
   * @param outputDir String, name of output directory
   * @throws SecurityException throws the exception if unable to create the named directory at given path
   * @throws IOException throws exception, if something goes wrong while writing document
   */
  public AutomatedFileWriter (List<AutomatedDocument> outputFilesContent, String outputDir)
      throws SecurityException, IOException {
    File outputDirectory = doesOutputDirectoryExists(outputDir) ? this.getOutputDirectory(outputDir) : this.createOutputDirectory(outputDir);
    this.writeFile(outputFilesContent, outputDirectory);
  }

  /**
   * this private method is to get existing Output Directory
   * @param outputDir name of output directory
   * @return Represented as File, Output Directory
   */
  private File getOutputDirectory(String outputDir) {
    return new File(outputDir);
  }

  /**
   * This method is used to check if output directory exists, isDirectory and readable
   * @param outputDir name of output directory
   * @return Represented as Boolean
   */
  private Boolean doesOutputDirectoryExists (String outputDir){
    Path path = Paths.get(outputDir);
    return Files.exists(path) && Files.isDirectory(path) && Files.isReadable(path);
  }

  /**
   * This private method creates new output directory
   * @param outputDir name of output directory
   * @return Represented as File, Output Directory
   * @throws SecurityException throws the exception if unable to create the named directory at given path
   */
  private File createOutputDirectory(String outputDir) throws
      SecurityException {
    File outputDirectory = new File(outputDir);
    boolean isDirectoryCreated = outputDirectory.mkdir();
    if(!isDirectoryCreated) {
      throw new SecurityException("Security manager does not permit the named directory to be created at given path");
    }
    return outputDirectory;
  }

  /**
   * This private method writes file in output directory
   * @param outputFilesContent List of AutomatedDocument
   * @param outputDirectory Represented as File, output directory
   * @throws IOException throws exception, if something goes wrong while writing document
   */
  private void writeFile(List<AutomatedDocument> outputFilesContent, File outputDirectory)
      throws IOException {
    for(AutomatedDocument outputContent : outputFilesContent) {
      File autoDoc = new File(outputDirectory, outputContent.getUniqueName()+".txt");

      try (FileWriter writer = new FileWriter(autoDoc);
          BufferedWriter bufferedWriter = new BufferedWriter(writer)){
        bufferedWriter.write(outputContent.getDocumentContent());
      }
      catch (IOException e) {
        throw new IOException("Something went wrong while writing document!");
      }
    }
  }
}
