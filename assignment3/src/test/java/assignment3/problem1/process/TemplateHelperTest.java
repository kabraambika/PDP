package assignment3.problem1.process;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateHelperTest {
  private TemplateHelper reader;
  @BeforeEach
  void setUp() {
    reader = new TemplateHelper();
  }

  @Test
  void readFile() throws IOException {
    TemplateHelper.readFile("src/test/resources/letter-template-small.txt");
  }

  @Test
  void readFile_fileNotFoundException() {
    assertThrows(FileNotFoundException.class, () -> {
      TemplateHelper.readFile("letter-template-one.txt");
    });
  }
}