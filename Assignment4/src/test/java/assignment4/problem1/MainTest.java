package assignment4.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

  @BeforeEach
  void setUp() {
    Main main = new Main();
  }

  @Test
  void mainTest() {
    assertThrows(NoSuchElementException.class, () -> {
      Main.main(new String[]{"src/test/resources/TestDirectory"});
    });
  }

  @Test
  void mainTest_EmptyException() {
    assertThrows(EmptyDirectoryException.class, () -> {
      Main.main(new String[]{"src/test/resources/EmptyTestDirectory"});
    });
  }

  @Test
  void mainTest_NoArgs() {
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
      Main.main(new String[]{});
    });
  }
}
