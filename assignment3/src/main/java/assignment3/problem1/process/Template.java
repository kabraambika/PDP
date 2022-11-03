package assignment3.problem1.process;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Template class reads template and provides template content and list of placeholders, this class implements ITemplate interface
 * @author kabraambika19
 */
public class Template implements ITemplate {
  private String templateContent;
  private List<String> placeholders;
  /**
   * Regex constant for placeholder
   */
  private static final String PLACEHOLDER_REGEX = "\\[\\[(.+?)\\]\\]";
  /**
   * Constant for placeholder pattern instance
   */
  private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile(PLACEHOLDER_REGEX);

  /**
   * Constructor of Template
   * @param templatePath path of template file, String
   * @throws IOException This exception is thrown if something goes wrong while reading template file
   */
  public Template(String templatePath) throws IOException {
    this.placeholders = new ArrayList<>();
    this.processTemplate(templatePath);
  }

  /**
   * This method is used to read Template and get placeholders from template content
   * @param templatePath path of template file, String
   * @throws IOException This exception is thrown if something goes wrong while reading template file
   */
  private void processTemplate(String templatePath) throws IOException {
    this.templateContent = TemplateHelper.readFile(templatePath);
    this.processPlaceholdersInTemplate();
  }

  /**
   * Gets the template content in String
   * @return String
   */
  @Override
  public String getTemplateContent() {
    return this.templateContent;
  }

  /**
   * Gets list of placeholders in template
   * @return List of String
   */
  @Override
  public List<String> getPlaceholders() {
    return this.placeholders;
  }

  /**
   * This private method helps in getting placeholder from template content by pattern instance of placeholder regex
   */
  private void processPlaceholdersInTemplate() {
    Matcher matcher = PLACEHOLDER_PATTERN.matcher(this.getTemplateContent());
    while(matcher.find()) {
      this.getPlaceholders().add(matcher.group(1));
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
    Template template = (Template) obj;
    return Objects.equals(this.getTemplateContent(), template.getTemplateContent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getTemplateContent());
  }

  @Override
  public String toString() {
    return "Template{" +
        "templateContent='" + this.getTemplateContent() + '\'' +
        '}';
  }
}
