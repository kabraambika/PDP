package assignment4.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {
  private CommandLineParser parser;
  @BeforeEach
  void setUp() {
    parser = new CommandLineParser("src/test/resources/TestDirectory");
  }

  @Test
  void getDirectoryFile() {
    File dir = new File("src/test/resources/TestDirectory");
    assertEquals(dir, parser.getDirectoryFile());
  }

  @Test
  void wrongDirPathTest() {
    assertThrows(DirectoryDoesNotExistException.class, ()-> {
      parser = new CommandLineParser("src/test/resources/TestDirs");
    });
  }
}