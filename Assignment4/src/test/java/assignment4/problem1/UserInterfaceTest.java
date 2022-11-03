package assignment4.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {
  private UserInterface userInterfaceTest;
  private ByteArrayInputStream inputStream;
  private PrintStream ps;
  private ByteArrayOutputStream byteArrayOutputStream;
  private File directoryTest;
  @BeforeEach
  void setUp() {
    directoryTest = new File("src/test/resources/TestDirectory");
    byteArrayOutputStream = new ByteArrayOutputStream();
    ps = new PrintStream(byteArrayOutputStream);
  }

  @Test
  void initiateProgram_No() {
    inputStream = new ByteArrayInputStream("2\nn\nq\n".getBytes());
    userInterfaceTest = new UserInterface(directoryTest, inputStream, ps, true);
    userInterfaceTest.initiateProgram();
    String outputText = byteArrayOutputStream.toString();
    assertEquals("The test works fine.\n", outputText);
  }

  @Test
  void initiateProgram_Yes_No() {
    inputStream = new ByteArrayInputStream("2\ny\nn\nq\n".getBytes());
    userInterfaceTest = new UserInterface(directoryTest, inputStream, ps, true);
    userInterfaceTest.initiateProgram();
    String outputText = byteArrayOutputStream.toString();
    assertEquals("The test works fine.\nThe test works fine.\n", outputText);
  }

  @Test
  void initiateProgram_No_1_No() {
    inputStream = new ByteArrayInputStream("2\nn\n4\nn\nq\n".getBytes());
    userInterfaceTest = new UserInterface(directoryTest, inputStream, ps, true);
    userInterfaceTest.initiateProgram();
    String outputText = byteArrayOutputStream.toString();
    assertEquals("The test works fine.\n", outputText);
  }

  @Test
  void initiateProgram_defMissing() {
    inputStream = new ByteArrayInputStream("1\nn\nq\n".getBytes());
    userInterfaceTest = new UserInterface(directoryTest, inputStream, ps, true);
    userInterfaceTest.initiateProgram();
    String outputText = byteArrayOutputStream.toString();
    assertEquals("The Test Generator JSON file does not have productions of non-terminal adverb to create a random sentence.\n", outputText);
  }

  @Test
  void initiateProgram_recursiveFlow() {
    File dir = new File("src/test/resources/recursiveFlow");
    inputStream = new ByteArrayInputStream("1\nn\nq\n".getBytes());
    userInterfaceTest = new UserInterface(dir, inputStream, ps, true);
    userInterfaceTest.initiateProgram();
    String outputText = byteArrayOutputStream.toString();
    assertEquals("Grammar file is creating infinite recursive call on non terminal element.\n", outputText);
  }

  @Test
  void emptyDirectoryExceptionTest() {
    assertThrows(EmptyDirectoryException.class, () -> {
      File dirTest = new File("src/test/resources/EmptyTestDirectory");
      inputStream = new ByteArrayInputStream("2\nn\nq\n".getBytes());
      userInterfaceTest = new UserInterface(dirTest, inputStream, ps, true);
      userInterfaceTest.initiateProgram();
    });
  }
}