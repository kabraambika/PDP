package assignment3.problem1.process;

import java.util.List;

/**
 * ITemplate is an interface defined for Template to get template content and placeholders
 */
public interface ITemplate {

  /**
   * Gets the template content in String
   * @return String
   */
  String getTemplateContent();

  /**
   * Gets list of placeholders in template
   * @return List of String
   */
  List<String> getPlaceholders();
}
