package Lab4.problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyPriorityQueueTest {
  private MyPriorityQueue<Integer> priorityQueueTest;
  @BeforeEach
  void setUp() {
    priorityQueueTest = new MyPriorityQueue<>();
  }

  @Test
  void insert() {
    priorityQueueTest.insert(3);
    priorityQueueTest.insert(2);
    priorityQueueTest.insert(4);
    priorityQueueTest.insert(1);
  }

  @Test
  void remove() {
    priorityQueueTest.insert(3);
    priorityQueueTest.insert(2);
    priorityQueueTest.insert(4);
    priorityQueueTest.insert(1);
    assertEquals(4, priorityQueueTest.remove());
  }

  @Test
  void front() {
    priorityQueueTest.insert(3);
    priorityQueueTest.insert(2);
    priorityQueueTest.insert(4);
    priorityQueueTest.insert(1);
    assertEquals(4, priorityQueueTest.front());
  }

  @Test
  void isEmpty() {
    assertTrue(priorityQueueTest.isEmpty());
  }
}