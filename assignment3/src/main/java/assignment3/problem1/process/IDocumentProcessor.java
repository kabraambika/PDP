package assignment3.problem1.process;

import java.util.List;

/**
 * IDocumentProcessor is an interface for Document processor which gets Output files
 * @author kabraambika19
 */
public interface IDocumentProcessor {

  /**
   * Gets the list of documents, type AutomatedDocument
   * @return List of AutomatedDocument
   */
  List<AutomatedDocument> getOutputFiles();
}
